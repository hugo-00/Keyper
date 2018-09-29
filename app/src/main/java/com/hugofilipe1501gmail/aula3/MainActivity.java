package com.hugofilipe1501gmail.aula3;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PasswordAdapter adapter;
    private RecyclerView recyclerView;
    private SenhaDatabase database;
    private EditText edt_add_título;
    private EditText edt_add_senha;

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

    public void actionAdd (final View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View view1 = inflater.inflate(R.layout.dialog_layout, null);

        builder.setView(view1);
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                edt_add_título = view1.findViewById(R.id.edt_add_título);
                edt_add_senha = view1.findViewById(R.id.edt_add_senha);
                String título = edt_add_título.getText().toString();
                String senha = edt_add_senha.getText().toString();
                Senha tmp = new Senha(título, senha);
                database.getSenhaDao().insert(tmp);
                adapter.add(tmp);

            }
        });
        builder.show();
    }
    public void removefromDB (Senha s){
        database.getSenhaDao().Delete(s);
    }
}
