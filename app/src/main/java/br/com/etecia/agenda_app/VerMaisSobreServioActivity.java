package br.com.etecia.agenda_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;

public class VerMaisSobreServioActivity extends AppCompatActivity {

    MaterialToolbar matoobar_arow_back;
    TextView txt_ver_mais_nome, txt_ver_mais_valor;
    int img_ver_mais_imagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ver_mais_sobre_servico_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        //pegando as string que foram salvas, na escolha de serviços
        String nomeServico = getIntent().getStringExtra("nomeServico");
        String valorServico = getIntent().getStringExtra("valorServico");

        //apresentação XML + JAVA
        matoobar_arow_back = findViewById(R.id.toolBarVerMais);
        txt_ver_mais_nome = findViewById(R.id.txtNomeVerMais);
        txt_ver_mais_valor = findViewById(R.id.txtValorVerMais);

        //Setando as imformaçoes de acordo com o card selecionado
        txt_ver_mais_valor.setText(valorServico);
        txt_ver_mais_nome.setText(nomeServico);

        //ativando o click na arow back para voltar
        matoobar_arow_back.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pegando o context e preparando o intente para levarr informaçoes
                Intent intent = new Intent(getApplicationContext(),PesquisaPerfTelaTrabalhadorActivity.class);
                /* Exmplo de salvar no Intent
                //salvando a informaçao da aba do tabque tem que abrir;
                intent.putExtra("voltarVerMais",1);
                //iniciando a nova activit e fechando esta
                 */
                startActivity(intent);
                finish();
            }
        });


    }
}