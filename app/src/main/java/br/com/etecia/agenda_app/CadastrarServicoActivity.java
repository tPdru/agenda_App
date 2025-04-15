package br.com.etecia.agenda_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputEditText;

public class CadastrarServicoActivity extends AppCompatActivity {

    MaterialToolbar material_toolbar;
    TextInputEditText nome_serv, valor_serv, descricao_serv;
    Button btn_criar_servico;

    //singleton
    TesteInfo testeInfo = TesteInfo.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.cadastrar_servico_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //Apresentação XML + JAVA
        nome_serv = findViewById(R.id.txtImpCriarServicoNome);
        valor_serv = findViewById(R.id.txtImpCriarServicoValor);
        descricao_serv = findViewById(R.id.txtImpCriarServicoDescricao);
        material_toolbar = findViewById(R.id.tbNavVoltar);
        btn_criar_servico = findViewById(R.id.btnCriarServico);

        //Botões
        //Arow back
        material_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TelaSecundariaActivity.class));
                finish();
            }
        });

        //Botão salvar novo serviço
        btn_criar_servico.setOnClickListener(new View.OnClickListener() {
            String nome, descricao, val;
            float valor;
            @Override
            public void onClick(View v) {
                nome = nome_serv.getText().toString();
                descricao = descricao_serv.getText().toString();
                val = valor_serv.getText().toString().trim();
                valor = Float.parseFloat(val);
                testeInfo.lista_servico_info.add(
                        new ObjServico(descricao, nome, valor)
                );
                Toast.makeText(CadastrarServicoActivity.this, "Serviço criado com sucesso!"
                        , Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), TelaSecundariaActivity.class));
                finish();
            }
        });

    }
}