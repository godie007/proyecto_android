package uniquindio.edu.co.proyectoandroid.actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import uniquindio.edu.co.proyectoandroid.R;
import uniquindio.edu.co.proyectoandroid.actividades.util.Utilidades;

public class InicioAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utilidades.obtenerLenguaje(this);
        setContentView(R.layout.activity_inicio_admin);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(R.string.app_name);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    public void verEntrenadores(View view){
        //Toast.makeText(getApplicationContext(), "Ok Vamos a la otra Ventana", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, EntrenadorActivity.class);
        startActivity(intent);
    }
    public void verParticipante(View view){
        Intent intent = new Intent(this, ParticipanteActivity.class);
        startActivity(intent);
    }
    public void verParticipanteEnJuego(View view){
        Intent intent = new Intent(this, ParticipanteEnJuegoActivity.class);
        startActivity(intent);
    }
    public void agregarParticipante(View view){
        Intent intent = new Intent(this, AgregarParticipanteActivity.class);
        startActivity(intent);
    }
    public void verVotacion(View view){
        if(Utilidades.estaConectado(getApplicationContext())){
            Intent intent = new Intent(this, VotacionActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(InicioAdminActivity.this, "No hay conexión a internet ", Toast.LENGTH_SHORT).show();
        }

    }

    public void cambiarIdioma(View view){
        Utilidades.cambiarIdioma(getApplicationContext());
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
