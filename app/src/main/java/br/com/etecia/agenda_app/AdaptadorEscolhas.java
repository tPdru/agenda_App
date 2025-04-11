package br.com.etecia.agenda_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class AdaptadorEscolhas extends RecyclerView.Adapter<AdaptadorEscolhas.ViewHolder> {

    public static final int TELA_MODELO_GRANDE_AGENDAR = 0;
    public static final int TELA_MODELO_PEQUENO_AGENDAR = 1;
    public static final int TELA_MODELO_lOCAL_AGENDAR = 2;

    Context context;
    List<ObjServicoRemove> lista_escolhas;
    private int origem;

    public AdaptadorEscolhas(Context context, List<ObjServicoRemove> lista_escolhas, int origem) {
        this.context = context;
        this.lista_escolhas = lista_escolhas;
        this.origem = origem;
    }


    @NonNull
    @Override
    public AdaptadorEscolhas.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.modelo_servico_remove_lista,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorEscolhas.ViewHolder holder, int position) {
        holder.nome.setText(lista_escolhas.get(position).getNome());
        holder.valor.setText(lista_escolhas.get(position).getValor());

    }

    @Override
    public int getItemCount() {
        return lista_escolhas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nome, valor;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.txtModRemoveServicoListaNome);
            valor = itemView.findViewById(R.id.txtModRemoveServicoListaValor);
        }
    }
}
