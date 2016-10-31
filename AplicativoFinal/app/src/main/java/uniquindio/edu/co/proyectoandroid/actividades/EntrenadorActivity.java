package uniquindio.edu.co.proyectoandroid.actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import uniquindio.edu.co.proyectoandroid.R;
/**
 * @autor Diego Fernando Echeverry
 * @autor Luisa Maria Valderrama
 */
public class EntrenadorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenadores);

        //se habilita el boton atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //se muestra el titulo con la nueva configuracion de idioma
        getSupportActionBar().setTitle(R.string.app_name);

    }

    /**
     * Metodo para redireccionar a la actividad DetalleEntrenadorActivity indicando que se eleciona el item 1 de la lista de entrenadores
     * @param view
     */
    public void verDetalleEntrenador1(View view){
        Intent intent = new Intent(this, DetalleEntrenadorActivity.class);
        intent.putExtra("Entrenador","1");
        startActivity(intent);
    }
    /**
     * Metodo para redireccionar a la actividad DetalleEntrenadorActivity indicando que se eleciona el item 2 de la lista de entrenadores
     * @param view
     */
    public void verDetalleEntrenador2(View view){
        Intent intent = new Intent(this, DetalleEntrenadorActivity.class);
        intent.putExtra("Entrenador","2");
        startActivity(intent);
    }
    /**
     * Metodo para redireccionar a la actividad DetalleEntrenadorActivity indicando que se eleciona el item 3 de la lista de entrenadores
     * @param view
     */
    public void verDetalleEntrenador3(View view){
        Intent intent = new Intent(this, DetalleEntrenadorActivity.class);
        intent.putExtra("Entrenador","3");
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
