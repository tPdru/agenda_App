package br.com.etecia.agenda_app;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;

public class TelaSecundariaPerfilFragment extends Fragment {

    Button button;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tela_secundaria_perfil_layout, container, false);

        button = view.findViewById(R.id.btnLoginConfiguracaoPJ);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //provavelmente criaremos um IF caso o usuário já tenha uma conta
                startActivity(new Intent(getContext(), LoginActivity.class));

            }
        });



        return view;
    }




}