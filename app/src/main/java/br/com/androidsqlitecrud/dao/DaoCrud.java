package br.com.androidsqlitecrud.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.androidsqlitecrud.dados.BaseDados;
import br.com.androidsqlitecrud.metodo.MetodoCrud;
import br.com.androidsqlitecrud.model.Crud;

public class DaoCrud implements MetodoCrud {
    //declaração de variaveis para conectar ao banco de dados sqlite
    SQLiteDatabase sqlEscrever;
    SQLiteDatabase sqlLeitura;

    public DaoCrud(Context context) {
        BaseDados base = new BaseDados(context);
        //inserir dados da tabela
        sqlEscrever = base.getWritableDatabase();
        //realizar leitura na base de dados
        sqlLeitura = base.getReadableDatabase();
    }

    @Override
    public boolean createCrud(Crud create) {
        //Classe Instancia para inserir dados na base de dados
        ContentValues valores = new ContentValues();
        //passar String key para inserir nos campos na tabela cadastro
        //key declarada ao cria a tabela cadastro: campos da tabela cadastros
        valores.put("nome", create.getNome());
        valores.put("email", create.getEmail());
        valores.put("celular", create.getCelular());
        valores.put("endereco", create.getEndereco());
        valores.put("observacao", create.getObservacao());
        //lanchar um try caso returno false lance uma excption para tratar o erro
        try {
            //gravar na tabela cadastro
            //passando no paramentro o nome da tabela e os valores
            sqlEscrever.insert(BaseDados.TABELA_CADASTRO, null, valores);
            //retorna verdadeiro caso a inserir seja realizado com sucesso
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCrud(Crud alterar) {
        //Classe Instancia para inserir dados na base de dados
        ContentValues valores = new ContentValues();
        //passar String key para inserir nos campos na tabela clientes
        //key declarada ao cria a tabela cliente: campos da tabela clientes
        valores.put("nome", alterar.getNome());
        valores.put("email", alterar.getEmail());
        valores.put("celular", alterar.getCelular());
        valores.put("endereco", alterar.getEndereco());
        valores.put("observacao", alterar.getObservacao());
        //lançar o try para verificar se o bloco de codigo estao correto
        try {
            String[] codigo = {alterar.getCodigo().toString()};
            //atualizar os dados na tabela clientes
            sqlEscrever.update(BaseDados.TABELA_CADASTRO, valores, "codigo = ?", codigo );
            //retorna verdadeiro caso a inserir seja realizado com sucesso
            return true;
        }catch (Exception e){
            Log.i("Informação: ","Erro ao atualizar dados: "+e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteCrud(Crud excluir) {
        try {
            String[] codigo = {excluir.getCodigo().toString()};
            sqlEscrever.delete(BaseDados.TABELA_CADASTRO,"codigo = ?", codigo);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Crud> listarCrud() {

        //declarar variaveis para realizar a operação de listar
        //Vamos precisar:
        List<Crud> listaCrud = new ArrayList<>();
        //vamos para o camando sqlite e atributo a uma strindo
        String sqlSelect = "select *from "+ BaseDados.TABELA_CADASTRO+";";
        Cursor cursor = sqlLeitura.rawQuery(sqlSelect, null);

        //iniciar um while para percorrer os campos da tabela
        while (cursor.moveToNext()){
            //instanciar um cliente model
            Crud crud = new Crud();

            Long codigo = cursor.getLong(cursor.getColumnIndex("codigo"));
            //declarar variaves para receber os atributos da classe cliente
            String txtNome, txtCelular, txtEmail, txtEndereco, txtObservacao;
            txtNome = cursor.getString(cursor.getColumnIndex("nome"));
            txtCelular = cursor.getString(cursor.getColumnIndex("email"));
            txtEmail = cursor.getString(cursor.getColumnIndex("celular"));
            txtEndereco = cursor.getString(cursor.getColumnIndex("endereco"));
            txtObservacao = cursor.getString(cursor.getColumnIndex("observacao"));

            crud.setCodigo(codigo);
            crud.setNome(txtNome);
            crud.setEmail(txtEmail);
            crud.setCelular(txtCelular);
            crud.setEndereco(txtEndereco);
            crud.setObservacao(txtObservacao);

            listaCrud.add(crud);
        }
        return listaCrud;
    }
}
