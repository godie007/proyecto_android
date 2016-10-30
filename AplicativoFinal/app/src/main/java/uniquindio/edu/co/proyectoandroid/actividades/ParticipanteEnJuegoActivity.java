package uniquindio.edu.co.proyectoandroid.actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import uniquindio.edu.co.proyectoandroid.R;
import uniquindio.edu.co.proyectoandroid.actividades.adaptadores.ParticipanteAdapter;
import uniquindio.edu.co.proyectoandroid.actividades.adaptadores.ParticipanteAdapterEnJuego;
import uniquindio.edu.co.proyectoandroid.actividades.modelo.Participante;

public class ParticipanteEnJuegoActivity extends AppCompatActivity {
    private RecyclerView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participante_en_juego);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(R.string.app_name);

        lista = (RecyclerView) findViewById(R.id.ListaParticipanteEnJuego);
        lista.setHasFixedSize(true);
        List<Participante> participantes = new ArrayList<>();
        participantes.add(new Participante("michael jackson",R.drawable.michael));
        participantes.add(new Participante("Juanes",R.drawable.juanes));
        participantes.add(new Participante("Green Day",R.drawable.green));
        ParticipanteAdapterEnJuego participanteAdapter=new ParticipanteAdapterEnJuego(participantes);
        lista.setAdapter(participanteAdapter);
        lista.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
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
