package br.com.etecia.agenda_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorFragAgenda extends RecyclerView.Adapter<AdaptadorFragAgenda.ViewHolder> {
    Context context;
    List<ObjAgendado> lista_agendado;

    public AdaptadorFragAgenda(Context context, List<ObjAgendado> lista_agendado) {
        this.context = context;
        this.lista_agendado = lista_agendado;
    }

    @NonNull
    @Override
    public AdaptadorFragAgenda.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.modelo_comentario,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorFragAgenda.ViewHolder holder, int position) {
        holder.nome_age.setText(lista_agendado.get(position).getNome_agendado());
        holder.servico_age.setText(lista_agendado.get(position).getValor_agendado());
    }

    @Override
    public int getItemCount() {
        return lista_agendado.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nome_age, servico_age;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nome_age = itemView.findViewById(R.id.txtNomeClienteAgendado);
            servico_age = itemView.findViewById(R.id.txtServicoAgendado);
        }
    }
}
