package br.com.androidsqlitecrud.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.androidsqlitecrud.R;
import br.com.androidsqlitecrud.model.Crud;

public class AdapterRead extends RecyclerView.Adapter<AdapterRead.MyViewHolder>{
    private List<Crud> crudList;
    private Context context;

    public AdapterRead(List<Crud> lista, Context context) {
        this.crudList = lista;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemListaCrud = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_read, viewGroup, false);
        return new MyViewHolder(itemListaCrud);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        readCrud(myViewHolder, i );


    }

    @Override
    public int getItemCount() {
        return this.crudList.size();
    }

    public void readCrud(MyViewHolder myViewHolder, int i){
        Crud crud =  crudList.get(i);
        myViewHolder.txtNome.setText("Nome: "+crud.getNome());
        myViewHolder.txtEmail.setText("Email: "+crud.getEmail());
        myViewHolder.txtCelular.setText("Celular: "+crud.getCelular());
        myViewHolder.txtEndereco.setText("Endereço: "+crud.getEndereco());
        myViewHolder.txtObservacao.setText("Observação: "+crud.getObservacao());
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        //declaração de atributos da class
        Context activity;
        TextView txtNome;
        TextView txtEmail;
        TextView txtCelular;
        TextView txtEndereco;
        TextView txtObservacao;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            activity = itemView.getContext();
            txtNome = itemView.findViewById(R.id.idAdpReadNome);
            txtEmail = itemView.findViewById(R.id.idAdpReadEmail);
            txtCelular = itemView.findViewById(R.id.idAdpReadCelular);
            txtEndereco = itemView.findViewById(R.id.idAdpReadEndereco);
            txtObservacao = itemView.findViewById(R.id.idAdpReadObervacao);
        }
    }
}
