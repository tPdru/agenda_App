package br.com.etecia.agenda_app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorListaAgendamento extends RecyclerView.Adapter<AdaptadorListaAgendamento.ViewHolder> {
    List<ObjListaAgendamento> lista_agendamento;
    Context context;

    public AdaptadorListaAgendamento(List<ObjListaAgendamento> lista_agendamento, Context context) {
        this.lista_agendamento = lista_agendamento;
        this.context = context;
    }



    @NonNull
    @Override
    public AdaptadorListaAgendamento.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorListaAgendamento.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return lista_agendamento.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtNomePerfilPJ,txtValorAgendamento,txtEnderecoAgendamento,btnDataAgendamento,txtAvaliacaoPerfilPJ;
        ImageView imgPerfilPJ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNomePerfilPJ = itemView.findViewById(R.id.txtNomePerfilPJ);
            txtValorAgendamento = itemView.findViewById(R.id.txtValorAgendamento);
            txtEnderecoAgendamento = itemView.findViewById(R.id.txtEnderecoAgendamento);
            btnDataAgendamento = itemView.findViewById(R.id.btnDataAgendamento);
            txtAvaliacaoPerfilPJ = itemView.findViewById(R.id.txtAvaliacaoPerfilPJ) ;
        }
    }
}
