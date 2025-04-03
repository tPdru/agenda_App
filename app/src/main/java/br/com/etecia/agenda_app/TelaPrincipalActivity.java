package br.com.etecia.agenda_app;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TelaPrincipalActivity extends AppCompatActivity {

    ViewPager2 view_pager_tela_principal;
    AdaptadorTelaPrincipal adaptador_tela_principal;
    BottomNavigationView bot_nav_tela_principal;

    MaterialToolbar mate_top_bar_items;


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

        //Apresentando XML + JAVA
        mate_top_bar_items = findViewById(R.id.topBarNavTelaPrincipal);
        //Pegando a opção que o usuario clicou e chamando a activit correspondente
        mate_top_bar_items.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.menuItemtopBarPerfil) {
                startActivity(new Intent(getApplicationContext(),TelaSecundariaActivity.class));
                //finish();
                return true;
            } else if (item.getItemId() == R.id.menuItemtopBarCarrinho) {
                startActivity(new Intent(getApplicationContext(),TelaSecundariaActivity.class));
                finish();
                return true;
            }
            return true;
        });





        //Apresentando variaveis, JAVA + Xml
        bot_nav_tela_principal = findViewById(R.id.botNavgationTelaPrincipal);
        view_pager_tela_principal = findViewById(R.id.viewPagTelaPrincipal);
        //Instanciando
        adaptador_tela_principal = new AdaptadorTelaPrincipal(this);

        //Ligando viewPager e adaptador
        view_pager_tela_principal.setAdapter(adaptador_tela_principal);



        //Pega o toque para saber qual tela foi escolhida pelo usuário.
        bot_nav_tela_principal.setOnItemSelectedListener(item -> {

            //Compara qual tela foi escolhida atravez do id e atribui o valor correspondente no Adaptador.
            if(item.getItemId() == R.id.menuPrincipalPesquisa){
                view_pager_tela_principal.setCurrentItem(0);

            } else if (item.getItemId() == R.id.menuPrincipalAgenda) {
                view_pager_tela_principal.setCurrentItem(1);

            } else if (item.getItemId() == R.id.menuPrincipalServico) {
                view_pager_tela_principal.setCurrentItem(2);

            } else if (item.getItemId() == R.id.menuPrincipalPerfil) {
                view_pager_tela_principal.setCurrentItem(3);
            }

            return true;
        });


        view_pager_tela_principal.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if(position == 0){
                    bot_nav_tela_principal.setSelectedItemId(R.id.menuPrincipalPesquisa);
                } else if (position == 1) {
                    bot_nav_tela_principal.setSelectedItemId(R.id.menuPrincipalAgenda);
                } else if (position == 2) {
                    bot_nav_tela_principal.setSelectedItemId(R.id.menuPrincipalServico);
                } else if (position == 3) {
                    bot_nav_tela_principal.setSelectedItemId(R.id.menuPrincipalPerfil);
                }
            }
        });
    }
}