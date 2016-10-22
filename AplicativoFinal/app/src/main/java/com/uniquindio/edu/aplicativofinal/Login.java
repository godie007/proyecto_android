package com.uniquindio.edu.aplicativofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void verInicio(View view){
        //Toast.makeText(getApplicationContext(), "Ok Vamos a la otra Ventana", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, Inicio.class);
        startActivity(intent);
    }
}
