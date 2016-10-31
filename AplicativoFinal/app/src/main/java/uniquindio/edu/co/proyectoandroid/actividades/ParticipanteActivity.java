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
import uniquindio.edu.co.proyectoandroid.actividades.modelo.Participante;
/**
 * @autor Diego Fernando Echeverry
 * @autor Luisa Maria Valderrama
 */
public class ParticipanteActivity extends AppCompatActivity {

    private RecyclerView lista;

    /**
     * Metodo para inicializar la activdad de participantes
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participantes);

        //se habilita el boton atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //se muestra el titulo con la nueva configuracion de idioma
        getSupportActionBar().setTitle(R.string.app_name);
        //lista de votos a ser mostrada en la actividad de votos
        lista = (RecyclerView) findViewById(R.id.ListaParticipante);
        lista.setHasFixedSize(true);
        List<Participante> participantes = new ArrayList<>();
        participantes.add(new Participante("Luisa",R.drawable.rihanna));
        participantes.add(new Participante("Julian",R.drawable.jhonny));
        participantes.add(new Participante("Julian",R.drawable.adele));
        ParticipanteAdapter participanteAdapter=new ParticipanteAdapter(participantes);
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

