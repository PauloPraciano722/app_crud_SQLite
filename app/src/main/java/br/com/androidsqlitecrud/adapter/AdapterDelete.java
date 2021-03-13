package br.com.androidsqlitecrud.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.androidsqlitecrud.R;
import br.com.androidsqlitecrud.dao.DaoCrud;
import br.com.androidsqlitecrud.model.Crud;

public class AdapterDelete extends RecyclerView.Adapter<AdapterDelete.MyViewHolder>{
    private List<Crud> crudList;
    private Context context;

    public AdapterDelete(List<Crud> lista, Context context) {
        this.crudList = lista;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemListaCrud = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_delete, viewGroup, false);
        return new MyViewHolder(itemListaCrud);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int posicao) {

        //Delete
        Crud crud = crudList.get(posicao);
        myViewHolder.txtDeleteNome.setText("Nome: "+crud.getNome() );
        myViewHolder.txtDeleteEmail.setText("Email: "+crud.getEmail());
        myViewHolder.txtDeleteCelular.setText("Celular: "+crud.getCelular());
        myViewHolder.txtDeleteEndereco.setText("Endereço: "+crud.getEndereco());
        myViewHolder.txtDeleteObservacao.setText("Observação: "+crud.getObservacao());
        myViewHolder.btnDeleteBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(myViewHolder.activity);
                builder.setCancelable(false);
                builder.setTitle("Delete");
                builder.setPositiveButton("Confirmar!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DaoCrud daoCrud = new DaoCrud(context);
                        Toast.makeText(context, "Delete",Toast.LENGTH_LONG).cancel();
                        Crud deleteCrud = crudList.get(posicao);
                        deleteCrud.getCodigo();
                        daoCrud.deleteCrud(deleteCrud);
                        crudList.remove(posicao);
                        notifyItemRemoved(posicao);
                        notifyItemRangeChanged(posicao, getItemCount());
                    }
                });
                builder.setNegativeButton("Cancelar", null);
                builder.create().show();
            }
        });
        //fim delete


    }

    @Override
    public int getItemCount() {
        return this.crudList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        //declaração de atributos da class
        Context activity;
        TextView txtDeleteNome;
        TextView txtDeleteEmail;
        TextView txtDeleteCelular;
        TextView txtDeleteEndereco;
        TextView txtDeleteObservacao;
        Button btnDeleteBotao;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            activity = itemView.getContext();
            txtDeleteNome = itemView.findViewById(R.id.idDeleteNome);
            txtDeleteEmail = itemView.findViewById(R.id.idDeleteEmail);
            txtDeleteCelular = itemView.findViewById(R.id.idDeleteCelular);
            txtDeleteEndereco = itemView.findViewById(R.id.idDeleteEndereco);
            txtDeleteObservacao = itemView.findViewById(R.id.idDeleteObervacao);
            btnDeleteBotao = itemView.findViewById(R.id.idBtnAdapterDelete);

        }
    }
}
