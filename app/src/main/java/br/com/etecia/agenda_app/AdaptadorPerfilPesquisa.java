package br.com.etecia.agenda_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorPerfilPesquisa extends RecyclerView.Adapter<AdaptadorPerfilPesquisa.ViewHolder> {
    Context context;
    List<ObjPerfilPesquisa> lista_perfil;

    public AdaptadorPerfilPesquisa(Context context, List<ObjPerfilPesquisa> lista_perfil) {
        this.context = context;
        this.lista_perfil = lista_perfil;
    }

    @NonNull
    @Override
    public AdaptadorPerfilPesquisa.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.modelo_tela_inicial_perfil_servico,parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPerfilPesquisa.ViewHolder holder, int position) {
        holder.nome_perfil.setText(lista_perfil.get(position).getNome_perfil());
    }

    @Override
    public int getItemCount() {
        return lista_perfil.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nome_perfil;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nome_perfil = itemView.findViewById(R.id.txtNomePerfilPesquisa);
        }
    }
}
