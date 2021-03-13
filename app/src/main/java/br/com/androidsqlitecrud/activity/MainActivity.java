package br.com.androidsqlitecrud.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import br.com.androidsqlitecrud.R;

public class MainActivity extends AppCompatActivity {

    public void createCrud(View view){
        startActivity(new Intent(MainActivity.this, CreateActivity.class));
    }
    public void readCrud(View view){
        startActivity(new Intent(MainActivity.this, ReadActivity.class));
    }
    public void updateCrud(View view){
        startActivity(new Intent(MainActivity.this, UpdateActivity.class));
    }
    public void deleteCrud(View view){
        //startActivity(new Intent(MainActivity.this, DeleteActivity.class));
        Intent intent = new Intent(MainActivity.this, DeleteActivity.class);
        intent.putExtra("resultado", true);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemDesenvolvedor:
                startActivity(new Intent(MainActivity.this, SobreActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
