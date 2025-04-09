package br.com.etecia.agenda_app;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class AdaptadorTelaPrincipal extends FragmentStateAdapter {
    public AdaptadorTelaPrincipal(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new PesquisaPerfFragment();
            case 1:
                return new AgendaFragment();
            case 2:
                return  new ServicoFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
