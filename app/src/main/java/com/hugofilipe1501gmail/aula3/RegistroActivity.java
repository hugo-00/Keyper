package com.hugofilipe1501gmail.aula3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    private EditText edtSenha;
    private Button btnEntrar;
    public static String PREFERENCE_NAME = "prefs";
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        //referenciar as views
        edtSenha = findViewById(R.id.edt_senha);
        btnEntrar = findViewById(R.id.btn_entrar);

        //preferences = getPreferences(0);
        preferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
        editor = preferences.edit();

        String senha = preferences.getString("senha", "");

        // verifica se existe uma senha
        if(senha.trim().isEmpty()){
            registrarSenha();
        }

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String senha = edtSenha.getText().toString();

                verificarSenha(senha);
            }
        });

    }

    private void registrarSenha(){
        //iniciar actividade de registro de senha
        Intent intent = new Intent(this, RegistrarSenhaActivity.class);
        startActivity(intent);

    }

    private void verificarSenha(String senha){
        String senhaArmazenada = preferences.getString("senha", "");
        if(senhaArmazenada.equals(senha)){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        } else {
            Toast.makeText(this, "senha invalida!", Toast.LENGTH_LONG).show();
        }

    }
}
