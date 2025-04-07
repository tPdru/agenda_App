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


public class PesquisaPerfFragment extends Fragment {

    RecyclerView recyclerView;
    List<ObjPerfilPesquisa> lista_perfil = new ArrayList<>();
    Button btn_meu_perfil;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pesquisa_perf, container, false);

        //Apresentação de XML + JAVA
        recyclerView = view.findViewById(R.id.recPerfisTelaPesquisa);
        btn_meu_perfil = view.findViewById(R.id.btnMeuPerfil);

        //Entrada de dados
        adicionarPerfil("Subaru");
        adicionarPerfil("Rimuru Tempest");
        adicionarPerfil("Ainz Ooal Gown");
        adicionarPerfil("Monkey D. Luffy");
        adicionarPerfil("Veldora Tempest");

        //acessando meu perfil
        btn_meu_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), PesquisaPerfTelaTrabalhadorActivity.class));
            }
        });



        AdaptadorPerfilPesquisa adaptadorPerfilPesquisa = new AdaptadorPerfilPesquisa(getContext(), lista_perfil);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));

        recyclerView.setAdapter(adaptadorPerfilPesquisa);

        return view;
    }

    private void adicionarPerfil(String nome){
        lista_perfil.add(
          new ObjPerfilPesquisa(nome)
        );
    }
}