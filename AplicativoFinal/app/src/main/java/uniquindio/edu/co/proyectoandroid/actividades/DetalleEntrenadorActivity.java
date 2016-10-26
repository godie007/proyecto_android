package uniquindio.edu.co.proyectoandroid.actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import uniquindio.edu.co.proyectoandroid.R;
import uniquindio.edu.co.proyectoandroid.actividades.adaptadores.HistorialAdapter;
import uniquindio.edu.co.proyectoandroid.actividades.adaptadores.ParticipanteAdapter;
import uniquindio.edu.co.proyectoandroid.actividades.modelo.Historial;
import uniquindio.edu.co.proyectoandroid.actividades.modelo.Participante;

public class DetalleEntrenadorActivity extends AppCompatActivity {
    private String entrenador;
    private RecyclerView lista;
    private RecyclerView lista2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_entrenador);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Bundle bundle = getIntent().getExtras();
        entrenador = bundle.getString("Entrenador");
        EditText nombre = (EditText)findViewById(R.id.nombre);
        EditText genero = (EditText)findViewById(R.id.genero);
        ImageView imgView = (ImageView)findViewById(R.id.foto);
        nombre.setEnabled(false);
        genero.setEnabled(false);
        if (entrenador.equals("1")){
            nombre.setText("jhonny rivera");
            genero.setText("Masculino");
            imgView.setImageResource(R.drawable.jhonny);
        }
        if (entrenador.equals("2")){
            nombre.setText("Rihanna");
            genero.setText("Femenino");
            imgView.setImageResource(R.drawable.rihanna);
        }
        if (entrenador.equals("3")){
            nombre.setText("Adele");
            genero.setText("Femenino");
            imgView.setImageResource(R.drawable.adele);
        }

        lista = (RecyclerView) findViewById(R.id.ListaHistorial);
        lista.setHasFixedSize(true);
        List<Historial> historials = new ArrayList<>();
        historials.add(new Historial("Dia1","ocurre un evento"));
        historials.add(new Historial("Dia2","ocurre un evento"));
        HistorialAdapter historialAdapter=new HistorialAdapter(historials);
        lista.setAdapter(historialAdapter);
        lista.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        lista2 = (RecyclerView) findViewById(R.id.ListaParticipantes);
        lista2.setHasFixedSize(true);
        List<Participante> participantes = new ArrayList<>();
        participantes.add(new Participante("Luisa",R.drawable.rihanna));
        participantes.add(new Participante("Julian",R.drawable.jhonny));
        participantes.add(new Participante("Julian",R.drawable.adele));
        ParticipanteAdapter participanteAdapter = new ParticipanteAdapter(participantes);
        lista2.setAdapter(participanteAdapter);
        lista2.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

