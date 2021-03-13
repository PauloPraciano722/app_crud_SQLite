package br.com.androidsqlitecrud.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.com.androidsqlitecrud.R;

public class SobreActivity extends AppCompatActivity {
    private TextView txtSobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtSobre = (TextView)findViewById(R.id.idTxtSobre);
        txtSobre.setText("DESCRIÇÃO: "+
                "\n"+"Aplicativo realizar um crud com Sqlite de um cadastro qualquer."+
                "\n\n"+"Nome App: SQLite Crud"+
                "\n"+"Modelo: Android"+
                "\n"+"Version: 1.0"+
                "\n"+"Marca: Yaco TI"+
                "\n"+"Licença: open source"+
                "\n"+"Desenvolvedor: Gilber Carvalho"+
                "\n"+"Formação: Bacharel sistema de informação"+
                "\n\n"+"Contato"+
                "\n"+"Email: gilbercs@hotmail.com"+
                "\n"+"phone: (92) 99312 - 4740");

    }
}
