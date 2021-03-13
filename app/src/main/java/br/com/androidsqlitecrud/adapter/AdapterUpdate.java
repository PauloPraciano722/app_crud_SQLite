package br.com.androidsqlitecrud.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import br.com.androidsqlitecrud.R;
import br.com.androidsqlitecrud.dao.DaoCrud;
import br.com.androidsqlitecrud.model.Crud;

public class AdapterUpdate extends RecyclerView.Adapter<AdapterUpdate.MyViewHolder>{
    private List<Crud> listaUpdate;
    private Context context;

    public AdapterUpdate(List<Crud> list, Context context) {
        this.listaUpdate = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemUpdate = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.adapter_update, viewGroup, false
        );
        return new MyViewHolder(itemUpdate);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        Crud crudUpdate = listaUpdate.get(i);
        myViewHolder.edtCampoNome.setText(crudUpdate.getNome());
        myViewHolder.edtCampoEmail.setText(crudUpdate.getEmail());
        myViewHolder.edtCampoCelular.setText(crudUpdate.getCelular());
        myViewHolder.edtCampoEndereco.setText(crudUpdate.getEndereco());
        myViewHolder.edtCampoObservacao.setText(crudUpdate.getObservacao());

        //update
        myViewHolder.btdUpadate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtNome, txtEmail, txtCelular, txtEndereco, txtObservacao;
                txtNome = myViewHolder.edtCampoNome.getText().toString();
                txtEmail = myViewHolder.edtCampoEmail.getText().toString();
                txtCelular = myViewHolder.edtCampoCelular.getText().toString();
                txtEndereco = myViewHolder.edtCampoEndereco.getText().toString();
                txtObservacao = myViewHolder.edtCampoObservacao.getText().toString();
                if (!txtNome.isEmpty()){
                    if (!txtEmail.isEmpty()){
                        if (!txtCelular.isEmpty()){
                            if (!txtEndereco.isEmpty()){
                                DaoCrud rescreverUpdate = new DaoCrud(context);
                                Crud setEscrever = listaUpdate.get(i);
                                setEscrever.getCodigo();
                                setEscrever.setNome(txtNome);
                                setEscrever.setEmail(txtEmail);
                                setEscrever.setCelular(txtCelular);
                                setEscrever.setEndereco(txtEndereco);
                                setEscrever.setObservacao(txtObservacao);
                                Boolean resultado = rescreverUpdate.updateCrud(setEscrever);
                                if (resultado==true){
                                    Toast.makeText(myViewHolder.activity, "Update realizado com sucesso!",Toast.LENGTH_LONG)
                                            .show();
                                }

                            }else {
                                Toast.makeText(myViewHolder.activity, "Preencha o campo Endereço!", Toast.LENGTH_LONG).show();
                            }
                        }else {
                            Toast.makeText(myViewHolder.activity, "Preencha o campo Celular!", Toast.LENGTH_LONG).show();
                        }
                    }else {
                        Toast.makeText(myViewHolder.activity, "Preencha o campo Email!", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(myViewHolder.activity, "Preencha o campo Adapter Nome!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaUpdate.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        Context activity;
        EditText edtCampoNome;
        EditText edtCampoEmail;
        EditText edtCampoCelular;
        EditText edtCampoEndereco;
        EditText edtCampoObservacao;
        Button btdUpadate;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            activity = itemView.getContext();
            edtCampoNome = itemView.findViewById(R.id.idUpdateNome);
            edtCampoEmail = itemView.findViewById(R.id.idUpdateEmail);
            edtCampoCelular = itemView.findViewById(R.id.idUpdateCelular);
            edtCampoEndereco = itemView.findViewById(R.id.idUpdateEndereco);
            edtCampoObservacao = itemView.findViewById(R.id.idUpdateObervacao);
            btdUpadate = itemView.findViewById(R.id.idBtnAdapterUpdate);
        }
    }


}
