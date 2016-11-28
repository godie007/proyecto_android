package uniquindio.edu.co.proyectoandroid.actividades;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Locale;

import uniquindio.edu.co.proyectoandroid.R;
import uniquindio.edu.co.proyectoandroid.actividades.util.Utilidades;
/**
 * @autor Diego Fernando Echeverry
 * @autor Luisa Maria Valderrama
 */
public class InicioAdminActivity extends AppCompatActivity {
    private ArrayAdapter arrayAdapter;
    private ListView monthsListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utilidades.obtenerLenguaje(this);
        setContentView(R.layout.activity_inicio_admin);

        //se habilita el boton atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //se muestra el titulo con la nueva configuracion de idioma
        getSupportActionBar().setTitle(R.string.app_name);

        // se toma arreglo del menu principal administrativo como reccurso
        String[] itemsMenu = getResources().getStringArray(R.array.menu_principal_admin);
        monthsListView = (ListView) findViewById(R.id.menu);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, itemsMenu);
        monthsListView.setAdapter(arrayAdapter);
        monthsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                if (position == 0){ // si selecciona el item de Entrenadores
                    verEntrenadores();
                }
                if (position == 1){ // si Selecciona el item de Participantes
                    verParticipante();
                }
                if (position == 2){ // si Selecciona el item de Participantes por Juego
                    verParticipanteEnJuego();
                }
                if (position == 3){ // si Selecciona el item de Agregar Participantes
                    agregarParticipante();
                }
                if (position == 4){ // si Selecciona el item de Votaciones
                    verVotacion();
                }
                if (position == 5){ // si Selecciona el item de Cambiar Idioma
                    cambiarIdioma();
                }

            }
        });

    }


    /**
     * metodo para redireccionar a la actividad de Entrenadores
     */
    public void verEntrenadores(){
        Intent intent = new Intent(this, EntrenadorActivity.class);
        startActivity(intent);
    }
    /**
     * metodo para redireccionar a la actividad de Participantes
     */
    public void verParticipante(){
        Intent intent = new Intent(this, ParticipanteActivity.class);
        startActivity(intent);
    }
    public void verParticipanteEnJuego(){
        Intent intent = new Intent(this, ParticipanteEnJuegoActivity.class);
        startActivity(intent);
    }
    /**
     * metodo para redireccionar a la actividad de Agregar Entrenadores
     */
    public void agregarParticipante(){
        Toast.makeText(InicioAdminActivity.this, "Agregar Participante", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DetallesDelParticipante.class);
        startActivity(intent);
    }
    /**
     * metodo para redireccionar a la actividad de Votaciones
     */
    public void verVotacion(){
        if(Utilidades.estaConectado(getApplicationContext())){
            Intent intent = new Intent(this, VotacionActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(InicioAdminActivity.this, "No hay conexión a internet ", Toast.LENGTH_SHORT).show();
        }

    }
    /**
     * metodo para cambiar de idioma de Español a Ingles o viceversa
     */
    public void cambiarIdioma(){

        Configuration config = new Configuration();
        Locale current = getResources().getConfiguration().locale;
        if (current.getLanguage().equals("en")){
            config.locale = new Locale("es");
        }else{
            config.locale = new Locale("en");
        }
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

        Intent intent = getIntent();
        finish();
        startActivity(intent);
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
