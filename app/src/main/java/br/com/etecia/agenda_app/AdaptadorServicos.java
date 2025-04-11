package br.com.etecia.agenda_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorServicos extends RecyclerView.Adapter<AdaptadorServicos.ViewHolder> {

    public static final int TELA_MEU_PERFIL = 0;
    public static final int TELA_EDITAR_SERVICO = 1;
    public static final int TELA_AGENDAMENTO_LOCAL = 2;


    private OnservicoClickLister escultar;

    Context context;
    List<ObjServico> lista_servicos;
    private int origem;

    AgendamentoLocalPjActivity ag_local = new AgendamentoLocalPjActivity();


    public AdaptadorServicos(Context context, List<ObjServico> lista_servicos, int origem, OnservicoClickLister escultar) {
        this.context = context;
        this.lista_servicos = lista_servicos;
        this.origem = origem;
        this.escultar = escultar;
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
                //pega a posição atual do item clicado
                int pos = holder.getAdapterPosition();
                //Verifica se a posição do item clicado e valida
                if(pos == RecyclerView.NO_POSITION) return;

                //Caso seja valida continua para ver em qual tela o usuarrio esta etomar a ação correta
                switch (origem){
                    case 0:
                        //pegando o contexto do item clicado
                        Intent intent = new Intent(v.getContext(), VerMaisSobreServioActivity.class);
                        //salvando as informaçoes do serviço escolhido
                        intent.putExtra("nomeServico",lista_servicos.get(pos).nome_servico);
                        intent.putExtra("valorServico", lista_servicos.get(pos).valor_servico);
                        //iniciando a nova activity
                        v.getContext().startActivity(intent);
                        break;
                    case 1:
                        Toast.makeText(context, "Editar Serviço", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(context, "Colocar no \"Carrinho\"", Toast.LENGTH_SHORT).show();
                        //pegando o contexto do item clicado
                        Intent intent1 = new Intent(v.getContext(), AgendamentoLocalPjActivity.class);
                        //salvando as informaçoes do serviço escolhido
                        intent1.putExtra("nomeEscolhaServ", lista_servicos.get(pos).nome_servico);
                        intent1.putExtra("valorEscolhaServ", lista_servicos.get(pos).valor_servico);
                        if(escultar != null){
                            escultar.onServicoEscolhido(lista_servicos.get(pos));
                        }
                        break;

                }
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

    //Interface
    public  interface OnservicoClickLister{
        void onServicoEscolhido(ObjServico escolhido);
    }

}
