package br.com.etecia.agenda_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorServicos extends RecyclerView.Adapter<AdaptadorServicos.ViewHolder> {
    Context context;
    List<ObjServico> lista_servicos;

    public AdaptadorServicos(Context context, List<ObjServico> lista_servicos) {
        this.context = context;
        this.lista_servicos = lista_servicos;
    }

    @NonNull
    @Override
    public AdaptadorServicos.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.modelo_card_de_servico, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorServicos.ViewHolder holder, int position) {
        ObjServico item = lista_servicos.get(position);
        holder.nome_servico.setText(lista_servicos.get(position).getNome_servico());
        holder.valor_servico.setText(lista_servicos.get(position).getValor_servico());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pegando o contexto do item clicado
                Intent intent = new Intent(v.getContext(), VerMaisSobreServioActivity.class);
                //salvando as informaçoes do serviço escolhido
                intent.putExtra("nomeServico",lista_servicos.get(position).nome_servico);
                intent.putExtra("valorServico", lista_servicos.get(position).valor_servico);
                //iniciando a nova activity
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista_servicos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nome_servico, valor_servico;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nome_servico = itemView.findViewById(R.id.txtCardServNomeServico);
            valor_servico = itemView.findViewById(R.id.txtCardServValorServico);
        }
    }
}
