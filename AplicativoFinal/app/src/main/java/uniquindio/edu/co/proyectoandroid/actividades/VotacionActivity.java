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
import uniquindio.edu.co.proyectoandroid.actividades.adaptadores.VotoAdapter;
import uniquindio.edu.co.proyectoandroid.actividades.modelo.Participante;
import uniquindio.edu.co.proyectoandroid.actividades.modelo.Voto;

/**
 * @autor Diego Fernando Echeverry
 * @autor Luisa Maria Valderrama
 */
public class VotacionActivity extends AppCompatActivity {
    // lista para mostar en la actividad de votacion
    private RecyclerView lista;

    /**
     * Metodo para inicializar la activdad de votaciones
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votacion);
        //se habilita el boton atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //se muestra el titulo con la nueva configuracion de idioma
        getSupportActionBar().setTitle(R.string.app_name);

        //lista de votos a ser mostrada en la actividad de votos
        List<Voto> votos = new ArrayList<>();
        votos.add(new Voto("Juan",R.drawable.rihanna,1));
        votos.add(new Voto("Adriana",R.drawable.adele,3));
        votos.add(new Voto("Diego",R.drawable.green,2));
        lista = (RecyclerView) findViewById(R.id.ListaParticipante);
        lista.setHasFixedSize(true);
        VotoAdapter participanteAdapter=new VotoAdapter(votos);
        lista.setAdapter(participanteAdapter);
        lista.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
    }

    /**
     *  Se indica en el menu superior al momento de presionar atras el sistema redirige a la actividad anterior
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Al momento de presionar el voton atras se finaliza la actividad actual
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
