package br.com.etecia.agenda_app;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class AdaptadorTelaSecundaria extends FragmentStateAdapter {


    public AdaptadorTelaSecundaria(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new TelaSecundariaAgendaFragment();
            case 1:
                return new TelaSecundariaCriarServicoFragment();
            case 2:
                return  new TelaSecundariaPerfilFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
