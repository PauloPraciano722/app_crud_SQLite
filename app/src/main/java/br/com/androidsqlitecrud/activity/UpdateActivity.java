package br.com.androidsqlitecrud.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import br.com.androidsqlitecrud.R;
import br.com.androidsqlitecrud.adapter.AdapterUpdate;
import br.com.androidsqlitecrud.dao.DaoCrud;
import br.com.androidsqlitecrud.model.Crud;

public class UpdateActivity extends AppCompatActivity {
private RecyclerView recyclerView;
private AdapterUpdate adapterUpdate;
private List<Crud> listaCrudUpdate = new ArrayList<>();
public void inicializar(){
    recyclerView = (RecyclerView)findViewById(R.id.idRecyclerViewUpdate);
}
public void carregarListaUpdate(){
    DaoCrud daoCrud = new DaoCrud(getApplicationContext());
    listaCrudUpdate = daoCrud.listarCrud();
    adapterUpdate = new AdapterUpdate(listaCrudUpdate, getApplicationContext());
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setHasFixedSize(true);
    recyclerView.addItemDecoration(new DividerItemDecoration(getBaseContext(), LinearLayout.VERTICAL));
    recyclerView.setAdapter(adapterUpdate);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        inicializar();
    }

    @Override
    protected void onStart() {
    carregarListaUpdate();
        super.onStart();
    }
}
