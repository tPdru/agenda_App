package br.com.etecia.agenda_app;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class TelaSecundariaCriarServicoFragment extends Fragment {
    Button btn_novo_servico;
    List<ObjServico> lista_servicos;
    RecyclerView recycler_view;
    AdaptadorServicos adaptador_servicos;

    TesteInfo teste_info = TesteInfo.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tela_secundaria_criar_servico_layout, container, false);

        //ligaçoes XML + JAVA
        btn_novo_servico = view.findViewById(R.id.btnTelaSecundariaNovoServico);
        recycler_view = view.findViewById(R.id.recTelaSecundariaServicos);

        //instancias
        lista_servicos = new ArrayList<>();
        adaptador_servicos = new AdaptadorServicos(getContext(), teste_info.lista_servico_info
                , AdaptadorServicos.TELA_EDITAR_SERVICO, new AdaptadorServicos.OnservicoClickLister() {
            @Override
            public void onServicoEscolhido(ObjServico escolhido) {

            }
        });

        //Adicionando objetos
        /*adicionarServico("teste 1", 30.99f);
        adicionarServico("teste 2", 40.99f);
        adicionarServico("teste 3", 10.99f);
        adicionarServico("teste 4", 300.99f);
        adicionarServico("teste 5", 60.99f);
        adicionarServico("teste 6", 99.99f);*/

        //Configuraçao recycleView
        recycler_view.setLayoutManager(new GridLayoutManager(getContext(),2));

        //Ligando adaptador + recycleView
        recycler_view.setAdapter(adaptador_servicos);

        //Usando o botao para chamar a tela de adicionar serviço
        btn_novo_servico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CadastrarServicoActivity.class));
            }
        });

        return view;
    }

}