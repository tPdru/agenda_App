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

import com.google.android.material.appbar.MaterialToolbar;

public class AgendamentoLocalPjActivity extends AppCompatActivity {

    MaterialToolbar matoobar_agendamento_local;
    Button btn_agendar_data;

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
}