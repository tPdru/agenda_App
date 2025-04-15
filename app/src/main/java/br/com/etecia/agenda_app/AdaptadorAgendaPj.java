package br.com.etecia.agenda_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorAgendaPj extends RecyclerView.Adapter<AdaptadorAgendaPj.ViewHolder> {

    Context context;
    List<ObjAgendadoPj> lista_agendado_pj;

    public AdaptadorAgendaPj(Context context, List<ObjAgendadoPj> lista_agendado_pj) {
        this.context = context;
        this.lista_agendado_pj = lista_agendado_pj;
    }

    @NonNull
    @Override
    public AdaptadorAgendaPj.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.modelo_agendado_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorAgendaPj.ViewHolder holder, int position) {
        holder.nome_cli.setText(lista_agendado_pj.get(position).getNome_cliente());
        holder.servico_cli.setText(lista_agendado_pj.get(position).getServicos());
        holder.valor_total_cli.setText(lista_agendado_pj.get(position).getValor_total());
        holder.img_foto_cli.setImageResource(lista_agendado_pj.get(position).getImg_perfil_cliente());
    }

    @Override
    public int getItemCount() {
        return lista_agendado_pj.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nome_cli, servico_cli, valor_total_cli;
        ImageView img_foto_cli;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nome_cli = itemView.findViewById(R.id.txtNomeClienteAgendado);
            servico_cli = itemView.findViewById(R.id.txtServicoAgendado);
            valor_total_cli = itemView.findViewById(R.id.txtModelAgendadoPjValorTotal);
            img_foto_cli = itemView.findViewById(R.id.imgfoto);
        }
    }
}
