package com.hugofilipe1501gmail.aula3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegistrarSenhaActivity extends AppCompatActivity {

    private EditText edt_senha, edt_senha_2;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_senha);

        edt_senha = findViewById(R.id.edt_senha);
        edt_senha_2 = findViewById(R.id.edt_senha_2);

        //preferences = getPreferences(0);
        preferences = getSharedPreferences(RegistroActivity.PREFERENCE_NAME, 0);
    }

    public void salvarSenha(View view){
        String senha1 = edt_senha.getText().toString();
        String senha2 = edt_senha_2.getText().toString();

        if(senha1.isEmpty() || senha2.isEmpty()){
            return;
        }

        if(!senha1.equals(senha2)){
            edt_senha_2.setError("As senha não coincidem");
        } else {
            // as senhas coincidem

            String senha = edt_senha_2.getText().toString();

            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("senha", senha2);
            editor.commit();

            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }

    }
}
