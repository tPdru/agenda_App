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

public class PesquisaPerfTelaTrabalhadorActivity extends AppCompatActivity {

    MaterialToolbar matoobar_perfil_trabalhador;
    Button btn_novo_agendamento_local;

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
        btn_novo_agendamento_local = findViewById(R.id.btnNovoAgendamentoLocal);

        //Ligando arow back
        matoobar_perfil_trabalhador.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TelaPrincipalActivity.class));
                finish();
            }
        });

        //Chamando a tela de agendamento local
        btn_novo_agendamento_local.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AgendamentoLocalPjActivity.class));
            }
        });

    }
}