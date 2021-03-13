package br.com.androidsqlitecrud.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import br.com.androidsqlitecrud.R;
import br.com.androidsqlitecrud.adapter.AdapterDelete;
import br.com.androidsqlitecrud.adapter.AdapterRead;
import br.com.androidsqlitecrud.dao.DaoCrud;
import br.com.androidsqlitecrud.model.Crud;

public class DeleteActivity extends AppCompatActivity {
//declaração de variavel
    private RecyclerView recyclerViewDelete;
    private AdapterDelete adapterDelete;
    private List<Crud> listaCrudDelete = new ArrayList<>();

    //metodo para inicializar componenetes
    public void inicializar(){
        recyclerViewDelete = (RecyclerView)findViewById(R.id.idRecyclerViewListaDelete);
    }
    //metodo para carregar Lista de dados cadastrado
    //para realizar delete
    public  void carregarListaDelete(){
        //lista do bancos de dados SQLite
        DaoCrud daoCrud = new DaoCrud(getBaseContext());
        listaCrudDelete = daoCrud.listarCrud();
        adapterDelete = new AdapterDelete(listaCrudDelete, getBaseContext());
        //configurar recyclearview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        recyclerViewDelete.setLayoutManager(layoutManager);
        recyclerViewDelete.setHasFixedSize(true);
        recyclerViewDelete.addItemDecoration(new DividerItemDecoration(getBaseContext(), LinearLayout.VERTICAL));
        recyclerViewDelete.setAdapter(adapterDelete);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        inicializar();
    }

    @Override
    protected void onStart() {
        carregarListaDelete();
        super.onStart();
    }
}
