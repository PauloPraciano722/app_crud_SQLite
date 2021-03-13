package br.com.androidsqlitecrud.dados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BaseDados extends SQLiteOpenHelper{
    //declaração de variaveis static
    public  static final String BASEDADOS = "crud.db";
    //declara de variavis static tabela
    public static final String TABELA_CADASTRO = "cadastro";
    public BaseDados(Context context){
        super(context, BASEDADOS, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //criando tabela cliente
        String sqlCreate = "create table if not exists " + TABELA_CADASTRO + "(codigo integer primary key autoincrement," +
                "nome text not null," +
                "email text not null," +
                "celular text not null," +
                "endereco text not null," +
                "observacao text)";
        try {
            //executar comando sqlite do cadastro
            db.execSQL(sqlCreate);
        }catch (Exception erro){
            erro.printStackTrace();
            Log.i("Erro","Banco de dados: ");
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("create table if not exists "+ TABELA_CADASTRO);
        onCreate(db);

    }
}
