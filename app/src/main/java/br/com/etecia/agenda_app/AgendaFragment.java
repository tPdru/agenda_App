package br.com.etecia.agenda_app;

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


public class AgendaFragment extends Fragment {
    RecyclerView recyclerView;
    List<ObjAgendado> lista_agendado = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_agenda_layout, container, false);

        //Apresentando xml/JAVA
        recyclerView = view.findViewById(R.id.recTelaAgenda);


        //Aicionando itens a lista
        adicionarAgendado("Pessoa 1", "Barba");
        adicionarAgendado("Pessoa 2", "Corte");
        adicionarAgendado("Pessoa 3", "Sombrancelha");
        adicionarAgendado("Pessoa 4", "Pintar cabelo");
        adicionarAgendado("Pessoa 5", "Corte");



        //Instanciando adaptador para gerenciar a lista
        AdaptadorFragAgenda adaptadorFragAgenda = new AdaptadorFragAgenda(getContext(), lista_agendado);

        //definindo a forma de apresentar os objetos no recycleView
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));

        //Fixa o tamanho do recycleView(temporario)
        //recyclerView.hasFixedSize();

        //ligando o REcycleView ao adaptador;
        recyclerView.setAdapter(adaptadorFragAgenda);

        return view;
    }

    //Função para adicionar itens ao recyclerView
    private void adicionarAgendado(String nome, String servico){
        String nome_sty = "Nome: " + nome;
        String servico_sty = "Serviço: " + servico;

        lista_agendado.add(
                new ObjAgendado(nome_sty, servico_sty)
        );
    }
}