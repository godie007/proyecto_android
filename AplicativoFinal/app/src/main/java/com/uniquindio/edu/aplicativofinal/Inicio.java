package com.uniquindio.edu.aplicativofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }

    public void verEntrenadores(View view){
        //Toast.makeText(getApplicationContext(), "Ok Vamos a la otra Ventana", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, Entrenador.class);
        startActivity(intent);
    }
    public void verParticipante(View view){
        Intent intent = new Intent(this, Participante.class);
        startActivity(intent);
    }
    public void verParticipanteEnJuego(View view){
        Intent intent = new Intent(this, ParticipanteEnJuego.class);
        startActivity(intent);
    }
    public void agregarParticipante(View view){
        Intent intent = new Intent(this, AgregarParticipante.class);
        startActivity(intent);
    }
    public void verVotacion(View view){
        Intent intent = new Intent(this, Votacion.class);
        startActivity(intent);
    }
}
