package br.com.etecia.agenda_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

public class AgendamentoLocalPjActivity extends AppCompatActivity {

    MaterialToolbar matoobar_agendamento_local;
    Button btn_agendar_data;
    RecyclerView rec_servicos, rec_servicos_escolhidos;

    List<ObjServico> lista_servicos;
    List<ObjServicoRemove> lista_escolhas;

    AdaptadorServicos adaptador_servicos;
    AdaptadorEscolhas adaptador_escolhas;

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

        //Apresentação XML + JAVA
        matoobar_agendamento_local = findViewById(R.id.topBarNavTrabalhadorAjendamentoLocal);
        btn_agendar_data = findViewById(R.id.btnAgendarDataPj);
        rec_servicos = findViewById(R.id.recParaEscolhaServicos);
        rec_servicos_escolhidos = findViewById(R.id.recServicosEscolhidos);

        //instancias
        lista_servicos = new ArrayList<>();
        lista_escolhas = new ArrayList<>();
        // Lister adicionado
        adaptador_servicos = new AdaptadorServicos(getApplicationContext(), lista_servicos
                , AdaptadorServicos.TELA_AGENDAMENTO_LOCAL, new AdaptadorServicos.OnservicoClickLister() {
            @Override
            public void onServicoEscolhido(ObjServico escolhido) {
                verificarEscolhido();
            }
        });
        adaptador_escolhas = new AdaptadorEscolhas(getApplicationContext(),lista_escolhas
                , AdaptadorEscolhas.TELA_MODELO_lOCAL_AGENDAR);

        //Configurando RecycleView
        rec_servicos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        rec_servicos.setAdapter(adaptador_servicos);
        rec_servicos_escolhidos.setLayoutManager(new GridLayoutManager(getApplicationContext(),1));
        rec_servicos_escolhidos.setAdapter(adaptador_escolhas);

        //Adicionando dados a lista
        adicionarServico("teste 1", 30.99f);
        adicionarServico("teste 2", 40.99f);
        adicionarServico("teste 3", 10.99f);
        adicionarServico("teste 4", 300.99f);
        adicionarServico("teste 5", 60.99f);
        adicionarServico("teste 6", 99.99f);

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

            }
        });

    }

    //Função de adicionar itens ao recycleView
    private void adicionarServico(String nome, float valor){
        String nome_form = "Nome: " + nome;
        String valor_form = "Valor: " + valor;
        lista_servicos.add(
                new ObjServico(nome_form, valor_form)
        );
    }
    //Função adicionar item a escolhas
    private void adicionarEscolhido(String nome, String valor){
        String nome_form = "Nome: " + nome;
        String valor_form = "Valor: " + valor;
        lista_escolhas.add(
                new ObjServicoRemove(nome_form, valor_form)
        );
    }

    //função verificar itens da lista escolhido
    public void verificarEscolhido(){
        //Pegando informações do intent
        String nome = getIntent().getStringExtra("nomeEscolhaServ");
        String valor = getIntent().getStringExtra("valorEscolhaServ");
        boolean adicionou = getIntent().getBooleanExtra("addIsOn", false);
        adicionarEscolhido(nome, valor);
        adaptador_escolhas.notifyItemInserted(lista_escolhas.size() - 1);
    }
}