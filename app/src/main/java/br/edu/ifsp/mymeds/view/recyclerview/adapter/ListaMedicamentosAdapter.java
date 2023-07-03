package br.edu.ifsp.mymeds.view.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import br.edu.ifsp.mymeds.R;
import br.edu.ifsp.mymeds.model.Medicamento;

public class ListaMedicamentosAdapter extends RecyclerView.Adapter<ListaMedicamentosAdapter.ListaMedicamentosViewHolder> {

    private List<Medicamento> listaMedicamentos;
    private LayoutInflater mInflater;

    public ListaMedicamentosAdapter(List<Medicamento> listaMedicamentos, Context context) {
        this.listaMedicamentos = listaMedicamentos;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ListaMedicamentosAdapter.ListaMedicamentosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.medicamento, parent, false);
        return new ListaMedicamentosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaMedicamentosViewHolder holder, int position) {
        Medicamento medicamento = listaMedicamentos.get(position);

        holder.textViewNome.setText(medicamento.getNome());
        holder.textViewDescricao.setText(medicamento.getDescricao());
    }


    @Override
    public int getItemCount() {
        return listaMedicamentos.size();
    }

    public class ListaMedicamentosViewHolder extends RecyclerView.ViewHolder{
        TextView textViewNome;
        TextView textViewDescricao;

        public ListaMedicamentosViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNome = itemView.findViewById(R.id.textViewNome);
            textViewDescricao = itemView.findViewById(R.id.textViewDescricao);
        }

    }
}
