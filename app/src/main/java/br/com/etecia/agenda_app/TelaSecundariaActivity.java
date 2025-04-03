package br.com.etecia.agenda_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TelaSecundariaActivity extends AppCompatActivity {

    MaterialToolbar mate_top_bar_secundaria;

    ViewPager2 view_pager_tela_secundaria;
    AdaptadorTelaSecundaria adaptador_tela_secundaria;
    BottomNavigationView bot_nav_Tela_secundaria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.tela_secundaria_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Apresentação XML + JAVA
        mate_top_bar_secundaria = findViewById(R.id.topBarNavTelaSecundariaBack);
        //Ativando a seta de navegação para voltar
        mate_top_bar_secundaria.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TelaPrincipalActivity.class));
                finish();
            }
        });

        //Apresentação XML + JAVA
        view_pager_tela_secundaria = findViewById(R.id.viewPagTelaSecundaria);
        bot_nav_Tela_secundaria = findViewById(R.id.botNavgationTelaSecundaria);
        //Instanciando
        adaptador_tela_secundaria = new AdaptadorTelaSecundaria(this);






    }
}