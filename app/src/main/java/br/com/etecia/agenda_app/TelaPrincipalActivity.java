package br.com.etecia.agenda_app;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TelaPrincipalActivity extends AppCompatActivity {

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
        //Apresenta a variavel botNavigation, JAVA + Xml
        BottomNavigationView bot_nav_tela_principal = findViewById(R.id.botNavgationTelaPrincipal);
        //abre a tela padrão sempre que for iniciado vai abrir na tela colocada aqui.
        getSupportFragmentManager().beginTransaction().replace(R.id.TelaPrincipalFlameContainer, new AgendaFragment()).commit();

        //Pega o toque para saber qual tela foi escolhida pelo usuário.
        bot_nav_tela_principal.setOnItemSelectedListener(item -> {
            //Fragmento vazio para receber a tela selecionada
            Fragment fragment_escolhido = null;

            /*Compara qual tela foi escolhida atravez do id e atribui a o fragment correspondente a
             variavel fragment_escolhido.
             */
            if(item.getItemId() == R.id.menuPrinncipalAgenda){
                fragment_escolhido = new AgendaFragment();

            } else if (item.getItemId() == R.id.menuPrinncipalServico) {
                fragment_escolhido = new ServicoFragment();

            } else if (item.getItemId() == R.id.menuPrinncipalPerfil) {
                fragment_escolhido = new PerfilFragment();

            }


            //Abre o fragmento esolhido
            if (fragment_escolhido != null){
                getSupportFragmentManager().beginTransaction().replace(R.id.TelaPrincipalFlameContainer, fragment_escolhido).commit();
            }
            return true;
        });
    }
}