package uniquindio.edu.co.proyectoandroid.actividades;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

import uniquindio.edu.co.proyectoandroid.R;
import uniquindio.edu.co.proyectoandroid.actividades.fragmentos.Fragment_Formulario_Entrenador;
import uniquindio.edu.co.proyectoandroid.actividades.fragmentos.Fragment_Historial;
import uniquindio.edu.co.proyectoandroid.actividades.fragmentos.Fragment_Participantes;

/**
 * @autor Diego Fernando Echeverry
 * @autor Luisa Maria Valderrama
 */
public class DetalleEntrenadorActivity extends AppCompatActivity {
    private String entrenador;


    /**
     * Metodo para inicializar los detalles de un determinado entrenador
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_entrenador);

        //se habilita el boton atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //se muestra el titulo con la nueva configuracion de idioma
        getSupportActionBar().setTitle(R.string.app_name);


        Bundle bundle = getIntent().getExtras();
        entrenador = bundle.getString("Entrenador");
        EditText nombre = (EditText)findViewById(R.id.nombre);
        EditText genero = (EditText)findViewById(R.id.genero);
        ImageView imgView = (ImageView)findViewById(R.id.foto);
        nombre.setEnabled(false);
        genero.setEnabled(false);
        if (entrenador.equals("0")){
            nombre.setText("jhonny rivera");
            genero.setText("Masculino");
            imgView.setImageResource(R.drawable.jhonny);
        }
        if (entrenador.equals("1")){
            nombre.setText("Rihanna");
            genero.setText("Femenino");
            imgView.setImageResource(R.drawable.rihanna);
        }
        if (entrenador.equals("2")){
            nombre.setText("Adele");
            genero.setText("Femenino");
            imgView.setImageResource(R.drawable.adele);
        }

        if (savedInstanceState == null) {
            Bundle args = new Bundle();
            args.putString("Entrenador", entrenador);
            Fragment_Participantes participantes = new Fragment_Participantes();
            participantes.setArguments(args);
            getSupportFragmentManager().beginTransaction().
            replace(R.id.partocipantes, participantes, "Hola").
            commit();

            Fragment_Historial historial = new Fragment_Historial();
            historial.setArguments(args);
            getSupportFragmentManager().beginTransaction().
            replace(R.id.historial, historial, "Hola").
            commit();
        }
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

