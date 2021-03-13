package br.com.androidsqlitecrud.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.androidsqlitecrud.R;
import br.com.androidsqlitecrud.dao.DaoCrud;
import br.com.androidsqlitecrud.model.Crud;

public class CreateActivity extends AppCompatActivity {
    //declaração de variaveis
    private EditText codigo;
    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtCelular;
    private EditText edtEndereco;
    private EditText edtObservacao;

    private Button botaoCreate;
//metodo para inicializar componentes
    public void inicializar(){
        edtNome = (EditText)findViewById(R.id.idEdtNome);
        edtEmail = (EditText)findViewById(R.id.idEdtEmail);
        edtCelular =(EditText)findViewById(R.id.idEdtCelular);
        edtEndereco = (EditText)findViewById(R.id.idEdtEndereco);
        edtObservacao = (EditText)findViewById(R.id.idEdtObservacao);
        botaoCreate = (Button)findViewById(R.id.idBotaoUpdate);
    }
    //limpar Campos
    public void limparcampos(){
        edtNome.setText("");
        edtEmail.setText("");
        edtCelular.setText("");
        edtEndereco.setText("");
        edtObservacao.setText("");
    }
    //metodo Create
    public void create(View view){
        String txtNome;
        String txtEmail;
        String txtCelular;
        String txtEndereco;
        String txtObservacao;
        txtNome = edtNome.getText().toString();
        txtEmail = edtEmail.getText().toString();
        txtCelular = edtCelular.getText().toString();
        txtEndereco = edtEndereco.getText().toString();
        txtObservacao = edtObservacao.getText().toString();
        if (!txtNome.isEmpty()){
            if (!txtEmail.isEmpty()){
                if (!txtCelular.isEmpty()){
                    if (!txtEndereco.isEmpty()){
                        //extancia classe dao
                        DaoCrud escreverSqlite = new DaoCrud(getBaseContext());
                        //extanciaro modelo
                        Crud setInsert = new Crud();
                        //setar o dados
                        setInsert.setNome(txtNome);
                        setInsert.setEmail(txtEmail);
                        setInsert.setCelular(txtCelular);
                        setInsert.setEndereco(txtEndereco);
                        setInsert.setObservacao(txtObservacao);
                        //boolean para verificar a inserção
                        boolean resultado;
                        //passar para o metodo de salvar na base de dados SQLite
                        resultado = escreverSqlite.createCrud(setInsert);
                        if (resultado == true){
                            Toast.makeText(CreateActivity.this, "Dados inseridos com " +
                                    "sucesso!!",Toast.LENGTH_LONG).show();
                            limparcampos();
                        }else {
                            Toast.makeText(CreateActivity.this, "Erro ao inserir dados!!",Toast.LENGTH_LONG).show();
                        }
                    }else {
                        Toast.makeText(CreateActivity.this,"Preencha o campo Endereço!",
                                Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(CreateActivity.this,"Preencha o campo Celular!",
                            Toast.LENGTH_LONG).show();
                }
            }else {
                Toast.makeText(CreateActivity.this,"Preencha o campo Email!",
                        Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(CreateActivity.this,"Preencha o campo nome!",
                    Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        inicializar();
    }
}
