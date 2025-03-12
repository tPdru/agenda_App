package br.com.etecia.agenda_app;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TelaPrincipalActivity extends AppCompatActivity {

    ViewPager2 view_pager_tela_principal;
    AdaptadorTelaPrincipal adaptador_tela_principal;
    BottomNavigationView bot_nav_tela_principal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.tela_principal_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Apresentando variaveis, JAVA + Xml
        bot_nav_tela_principal = findViewById(R.id.botNavgationTelaPrincipal);
        view_pager_tela_principal = findViewById(R.id.viewPagTelaPrincipal);
        adaptador_tela_principal = new AdaptadorTelaPrincipal(this);

        //Ligando viewPager e adaptador
        view_pager_tela_principal.setAdapter(adaptador_tela_principal);



        //Pega o toque para saber qual tela foi escolhida pelo usuário.
        bot_nav_tela_principal.setOnItemSelectedListener(item -> {

            //Compara qual tela foi escolhida atravez do id e atribui o valor correspondente no Adaptador.
            if(item.getItemId() == R.id.menuPrinncipalAgenda){
                view_pager_tela_principal.setCurrentItem(0);

            } else if (item.getItemId() == R.id.menuPrinncipalServico) {
                view_pager_tela_principal.setCurrentItem(1);

            } else if (item.getItemId() == R.id.menuPrinncipalPerfil) {
                view_pager_tela_principal.setCurrentItem(2);

            }

            return true;
        });


        view_pager_tela_principal.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if(position == 0){
                    bot_nav_tela_principal.setSelectedItemId(R.id.menuPrinncipalAgenda);
                } else if (position == 1) {
                    bot_nav_tela_principal.setSelectedItemId(R.id.menuPrinncipalServico);
                } else if (position == 2) {
                    bot_nav_tela_principal.setSelectedItemId(R.id.menuPrinncipalPerfil);
                }
            }
        });
    }
}