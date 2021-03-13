package br.com.androidsqlitecrud.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import br.com.androidsqlitecrud.R;
import br.com.androidsqlitecrud.adapter.AdapterRead;
import br.com.androidsqlitecrud.dao.DaoCrud;
import br.com.androidsqlitecrud.model.Crud;

public class ReadActivity extends AppCompatActivity {
    private RecyclerView recyclerViewLista;
    private AdapterRead adapterRead;
    private List<Crud> listCrud = new ArrayList<>();

    public void inicializar(){
        recyclerViewLista = (RecyclerView)findViewById(R.id.idLista);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        inicializar();
        DaoCrud daoCrud = new DaoCrud(getBaseContext());
        listCrud = daoCrud.listarCrud();
        adapterRead = new AdapterRead(listCrud, getBaseContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewLista.setLayoutManager(layoutManager);
        recyclerViewLista.setHasFixedSize(true);
        recyclerViewLista.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerViewLista.setAdapter(adapterRead);

    }
}
