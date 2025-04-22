package br.com.etecia.agenda_app;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class PesquisaPerfFragment extends Fragment {

    RecyclerView recyclerView;
    List<ObjPerfilPesquisa> lista_perfil = new ArrayList<>();
    Button btn_meu_perfil;
    CardView card_meu_perfil;
    LinearLayout linear_Layout_meu_peril;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pesquisa_perf, container, false);


        //Apresentação de XML + JAVA
        recyclerView = view.findViewById(R.id.recPerfisTelaPesquisa);


        //instancias
        AdaptadorPerfilPesquisa adaptadorPerfilPesquisa = new AdaptadorPerfilPesquisa(getContext(), lista_perfil);

        //Capiturando o scroll no recycleView dx = horizontal | dy = vertical
        /*recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                //variaveis de controle
                RecyclerView.LayoutManager lay_manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                boolean primeiro_item = ((LinearLayoutManager) lay_manager).findFirstVisibleItemPosition() == 0;

                if(primeiro_item){
                    linear_Layout_meu_peril.setVisibility(View.GONE);
                    card_meu_perfil.setVisibility(View.VISIBLE);
                }else{
                    linear_Layout_meu_peril.setVisibility(View.VISIBLE);
                    card_meu_perfil.setVisibility(View.GONE);
                }
            }
        });*/

        //teste animação
        /*if(linear_Layout_meu_peril.getVisibility() == View.GONE){
            linear_Layout_meu_peril.setAlpha(0f);
            linear_Layout_meu_peril.setVisibility(View.VISIBLE);
            linear_Layout_meu_peril.animate()
                    .alpha(1f)
                    .setDuration(300)
                    .start();
        }else{
            linear_Layout_meu_peril.animate()
                    .alpha(0f)
                    .setDuration(300)
                    .withEndAction(() -> linear_Layout_meu_peril.setVisibility(View.GONE))
                    .start();

        }*/


        //acessando meu perfil card
        /*card_meu_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),PesquisaPerfTelaTrabalhadorActivity.class));
            }
        });
        //acessando meu perfil botao
        btn_meu_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), PesquisaPerfTelaTrabalhadorActivity.class));
            }
        });*/

        //Entrada de dados
        adicionarPerfil("Subaru");
        adicionarPerfil("Rimuru Tempest");
        adicionarPerfil("Ainz Ooal Gown");
        adicionarPerfil("Monkey D. Luffy");
        adicionarPerfil("Veldora Tempest");



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