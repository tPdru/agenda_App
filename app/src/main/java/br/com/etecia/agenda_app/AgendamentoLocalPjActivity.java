package br.com.etecia.agenda_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AgendamentoLocalPjActivity extends AppCompatActivity {


    MaterialToolbar matoobar_agendamento_local;
    Button btn_agendar_data, btn_dia, btn_hora;
    RecyclerView rec_servicos, rec_servicos_escolhidos;

    List<ObjServico> lista_servicos;
    List<ObjServicoRemove> lista_escolhas;

    AdaptadorServicos adaptador_servicos;
    AdaptadorEscolhas adaptador_escolhas;

    MaterialDatePicker<Long> datepiker;
    MaterialTimePicker timePicker;

    TextInputEditText imp_nome_cliente;

    TesteInfo teste_info;


    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.agendamento_local_pj_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        //construção data e time piker
        timePicker = new MaterialTimePicker.Builder().setTimeFormat(TimeFormat.CLOCK_24H)
                .setTitleText("Selecionar Hora").build();
        datepiker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Selecionar Dia").build();

        //Apresentação XML + JAVA
        matoobar_agendamento_local = findViewById(R.id.topBarNavTrabalhadorAjendamentoLocal);
        btn_dia = findViewById(R.id.btnAgendarLocalDia);
        btn_hora = findViewById(R.id.btnAgendarLocalHora);
        btn_agendar_data = findViewById(R.id.btnAgendarDataPj);
        rec_servicos = findViewById(R.id.recParaEscolhaServicos);
        rec_servicos_escolhidos = findViewById(R.id.recServicosEscolhidos);
        imp_nome_cliente = findViewById(R.id.txtInpAgendarLocalNome);

        //singleton
        teste_info = TesteInfo.getInstance();

        //instancias
        lista_servicos = new ArrayList<>();
        lista_escolhas = new ArrayList<>();
        adaptador_escolhas = new AdaptadorEscolhas(getApplicationContext(),lista_escolhas
                , AdaptadorEscolhas.TELA_MODELO_lOCAL_AGENDAR);
        adaptador_servicos = new AdaptadorServicos(getApplicationContext(), teste_info.lista_servico_info
                , AdaptadorServicos.TELA_AGENDAMENTO_LOCAL, new AdaptadorServicos.OnservicoClickLister() {
            @Override
            public void onServicoEscolhido(ObjServico escolhido) {
                //Adicionando dados na lista de escolhas
                adicionarEscolhido(escolhido.nome_servico, escolhido.valor_servico.toString());

            }
        });


        //Configurando RecycleView
        rec_servicos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        rec_servicos.setAdapter(adaptador_servicos);
        rec_servicos_escolhidos.setLayoutManager(new GridLayoutManager(getApplicationContext(),1));
        rec_servicos_escolhidos.setAdapter(adaptador_escolhas);

        //Adicionando dados a lista
        /*adicionarServico("teste 1", 30.99f);
        adicionarServico("teste 2", 40.99f);
        adicionarServico("teste 3", 10.99f);
        adicionarServico("teste 4", 300.99f);
        adicionarServico("teste 5", 60.99f);
        adicionarServico("teste 6", 99.99f);*/


        //Area de BOTÕES----------
        // Ativando a arow back
        matoobar_agendamento_local.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PesquisaPerfTelaTrabalhadorActivity.class));
                finish();
            }
        });

        //Botão de agendamento
        btn_agendar_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lista = lista_escolhas.size();
                String servicos_cli = lista_escolhas.get(0).getNome();
                if(imp_nome_cliente.getText() == null){
                    teste_info.nome_cli = "Vazio";
                }else {
                    teste_info.nome_cli = String.valueOf(imp_nome_cliente.getText());
                }
                teste_info.servico_cli = servicos_cli;
                teste_info.valor_cli = lista_escolhas.get(0).getValor();
                teste_info.new_item = true;
                Toast.makeText(AgendamentoLocalPjActivity.this, "Agendado com sucesso!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),PesquisaPerfTelaTrabalhadorActivity.class));
                finish();
            }
        });

        //Botão de Hora
        btn_hora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker.show(getSupportFragmentManager(),"hora");
            }
        });
        //Botão de dia
        btn_dia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datepiker.show(getSupportFragmentManager(),"dia");
            }
        });

        //Botoes de confirmação de escolha dia/hora
        timePicker.addOnPositiveButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Pegando a hora e os minutos separados
                int hora = timePicker.getHour();
                int minuto = timePicker.getMinute();

                //Calendar para juntar hora e minuto
                Calendar calendar = Calendar.getInstance();

                //Passando a hora e os minutos para o calendar
                calendar.set(Calendar.HOUR_OF_DAY, hora);
                calendar.set(Calendar.MINUTE, minuto);

                //Formatar hora
                SimpleDateFormat formatar = new SimpleDateFormat("hh:mm a", Locale.getDefault());
                String hora_formatada = formatar.format(calendar.getTime());

                //Mostrar para o usuario
                btn_hora.setText(hora_formatada);
            }
        });

        datepiker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
            @Override
            public void onPositiveButtonClick(Long selection) {
                //formatar dia
                //instancia da classe usada para formatar
                SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                //VAriável que recebe a data formatada
                String dia_formatado = formatar.format(new Date(selection));

                //Mostrando o horario para o usuario
                btn_dia.setText(dia_formatado);
            }
        });

    }

    //OnResume carrega toda vez que a tela fica visivel (proximo do update ou start)


    @Override
    protected void onResume() {
        super.onResume();

        adaptador_servicos.atualizarListaServico(teste_info.lista_servico_info);
    }

    //Função de adicionar itens ao recycleView
    private void adicionarServico(String nome, float valor, String descricao){
        String nome_form = "Nome: " + nome;
        String valor_form = "Valor: " + valor;
        teste_info.lista_servico_info.add(
                new ObjServico(descricao, nome_form, valor)
        );
    }
    //Função adicionar item a escolhas
    private void adicionarEscolhido(String nome, String valor){
        String nome_form = "Nome: " + nome;
        String valor_form = "Valor: " + valor;
        lista_escolhas.add(
                new ObjServicoRemove(nome_form, valor_form)
        );
        //Atualiza o tamanho da lista
        adaptador_escolhas.notifyItemInserted(lista_escolhas.size() - 1);
    }

}