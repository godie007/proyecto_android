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
        getSupportActionBar().setTitle(R.string.app_name);
        // Comprobamos que previamente no hayamos entrado en esta actividad (por ejemplo, al rotar el dispositivo). Si es así se añade el fragmento al contenedor
        if (savedInstanceState == null) {
            // Crea el fragmento del detalle de la entrada y lo añade a la actividad

            Bundle arguments = new Bundle();
            arguments.putString(Fragment_Historial.ARG_ID_ENTRADA_SELECIONADA, getIntent().getStringExtra(Fragment_Historial.ARG_ID_ENTRADA_SELECIONADA));
            Fragment frag1 = new Fragment_Historial();
            frag1.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_listadoHistorial,frag1).commit();

            Bundle arguments2 = new Bundle();
            arguments2.putString(Fragment_Formulario_Entrenador.ARG_ID_ENTRADA_SELECIONADA, getIntent().getStringExtra(Fragment_Formulario_Entrenador.ARG_ID_ENTRADA_SELECIONADA));
            Fragment frag2 = new Fragment_Formulario_Entrenador();
            frag2.setArguments(arguments2);
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_formulario,frag2).commit();


            Bundle arguments3 = new Bundle();
            arguments3.putString(Fragment_Participantes.ARG_ID_ENTRADA_SELECIONADA, getIntent().getStringExtra(Fragment_Participantes.ARG_ID_ENTRADA_SELECIONADA));
            Fragment frag3 = new Fragment_Participantes();
            frag3.setArguments(arguments3);
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_partocipantes,frag3).commit();

        }

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

