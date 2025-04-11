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
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class PesquisaPerfTelaTrabalhadorActivity extends AppCompatActivity {

    MaterialToolbar matoobar_perfil_trabalhador;
    FloatingActionButton id_fab_adicionar;
    RecyclerView rec_servicos, rec_avaliacoes;
    List<ObjServico> lista_servicos;
    List<ObjAvaliacao> lista_avaliacoes;
    AdaptadorServicos adaptador_servicos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.pesquisa_perf_tela_trabalhador_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Apresentação XML + JAVA
        matoobar_perfil_trabalhador = findViewById(R.id.materialTopBarPerfilTrabalhador);
        id_fab_adicionar = findViewById(R.id.id_fab_adicionar);
        rec_servicos = findViewById(R.id.recServicosAgeLocal);
        rec_avaliacoes = findViewById(R.id.recAvaliacoesMeuPerfil);

        //Instancias
        lista_servicos = new ArrayList<>();
        lista_avaliacoes = new ArrayList<>();
        adaptador_servicos = new AdaptadorServicos(getApplicationContext(), lista_servicos
                , AdaptadorServicos.TELA_MEU_PERFIL, new AdaptadorServicos.OnservicoClickLister() {
            @Override
            public void onServicoEscolhido(ObjServico escolhido) {

            }
        });

        //configurando RecycleView
        //LinearLayoutManager(já vem por padrão na vertical) modificado para a posição horizontal
        rec_servicos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        rec_servicos.setAdapter(adaptador_servicos);

        //Adicionando dados a lista
        adicionarServico("teste 1", 30.99f);
        adicionarServico("teste 2", 40.99f);
        adicionarServico("teste 3", 10.99f);
        adicionarServico("teste 4", 300.99f);
        adicionarServico("teste 5", 60.99f);
        adicionarServico("teste 6", 99.99f);



        //Ligando arow back
        matoobar_perfil_trabalhador.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TelaPrincipalActivity.class));
                finish();
            }
        });

        //Chamando a tela de agendamento local
        id_fab_adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AgendamentoLocalPjActivity.class));
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
}