package br.com.etecia.agenda_app;

import static br.com.etecia.agenda_app.AgendamentoLocalPjActivity.*;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class TelaSecundariaAgendaFragment extends Fragment {

    MaterialDatePicker<Long> datepiker;
    MaterialTimePicker timePicker;
    Button btn_date, btn_hora;
    List<ObjAgendadoPj> lista_agendados_pj;
    RecyclerView rec_view_agenda_pj;
    AdaptadorAgendaPj adaptador_agenda_pj;
    TesteInfo teste_info;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tela_secundaria_agenda_layout, container, false);

        //apresentaçoes XML + Java
        rec_view_agenda_pj = view.findViewById(R.id.recTelaSecundariaAgenda);
        btn_date = view.findViewById(R.id.btnData);
        btn_hora = view.findViewById(R.id.btnHora);

        //singleton
        teste_info = TesteInfo.getInstance();


        //instanciando
        datepiker = new MaterialDatePicker<>();
        timePicker = new MaterialTimePicker();
        lista_agendados_pj = new ArrayList<>();
        adaptador_agenda_pj = new AdaptadorAgendaPj(getContext(),lista_agendados_pj);
        //Instancias com metodos



        //construção data e time piker
        datepiker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Selecione a data").build();

        timePicker = new MaterialTimePicker.Builder().setTimeFormat(TimeFormat.CLOCK_12H)
                .setTitleText("Escolha a Hora").build();

        //Confiruração recycleView
        rec_view_agenda_pj.setLayoutManager(new GridLayoutManager(getContext(),1));
        rec_view_agenda_pj.setAdapter(adaptador_agenda_pj);

        //Testando o recebimento de informações atravez do singleton
        if(teste_info.new_item){
            adicionarAgendado(teste_info.nome_cli, teste_info.servico_cli, teste_info.valor_cli);
            teste_info.new_item = false;
        }


        //botão para escolher a data
        btn_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mostra o seletor de datas na tela
                datepiker.show(getChildFragmentManager(),"date");
            }
        });

        //Botao "Ok" apos a data ter sido escolhida
        datepiker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
            @Override
            public void onPositiveButtonClick(Long selection) {
                //formata a data selecionada
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                String data_formatada = format.format(new Date(selection));

                Toast.makeText(getContext(), data_formatada, Toast.LENGTH_SHORT).show();
                btn_date.setText(data_formatada);

            }
        });

        //botao para escolher a hora
        btn_hora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker.show(getChildFragmentManager(), "hora");
            }
        });

        //Botao "Ok" apos a hora ter sido escolhida
        timePicker.addOnPositiveButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Recebendo Hora e minutos como int
                int hora = timePicker.getHour();
                int minute = timePicker.getMinute();

                //Configurando um calendar para recceber int e transformar em time
                //Instanciando calendar
                Calendar calendar = Calendar.getInstance();
                //setando hora e minuto
                calendar.set(Calendar.HOUR_OF_DAY, hora);
                calendar.set(Calendar.MINUTE, minute);

                //Formatar hora
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
                String horario_formatado = simpleDateFormat.format(calendar.getTime());
                btn_hora.setText(horario_formatado);

            }
        });

        return view;
    }

    //Função adicionar na agenda
    private void adicionarAgendado(String nome, String servico, String valor_total){
        String servico_formatado = "Seviços: " + servico;
        lista_agendados_pj.add(
                new ObjAgendadoPj(R.drawable.foto_usuario,nome,servico_formatado,valor_total)
        );
        adaptador_agenda_pj.notifyItemInserted(lista_agendados_pj.size()- 1);
    }
}