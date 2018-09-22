package com.hugofilipe1501gmail.aula3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PasswordAdapter adapter;
    private RecyclerView recyclerView;
    private SenhaDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inicializar o Adapter
        adapter = new PasswordAdapter();

        // inicializar o RecyclerView
        recyclerView = findViewById(R.id.recycler_items);

        // layout manager
        LinearLayoutManager lm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adapter);

        //inicializar database
        database = SenhaDatabase.getInstancia(this);

        //preencher o RecyclerView
        preencherLista();

    }

    private void preencherLista(){
        List<Senha> dados = database.getSenhaDao().getSenhas();
        if(dados.isEmpty()){
            Toast.makeText(this,"Lista Vazio!", Toast.LENGTH_LONG).show();
        }else {
            adapter.add(dados);
        }
    }

    public void actionAdd (View view){
        Senha tmp = new Senha( "Google", "1234");
        database.getSenhaDao().insert(tmp);
        adapter.add(tmp);
    }
}
