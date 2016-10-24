package uniquindio.edu.co.proyectoandroid.actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import uniquindio.edu.co.proyectoandroid.R;

public class EntrenadorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenadores);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
    public void verDetalleEntrenador1(View view){
        Intent intent = new Intent(this, DetalleEntrenadorActivity.class);
        startActivity(intent);
    }
    public void verDetalleEntrenador2(View view){
        Intent intent = new Intent(this, DetalleEntrenadorActivity.class);
        startActivity(intent);
    }
    public void verDetalleEntrenador3(View view){
        Intent intent = new Intent(this, DetalleEntrenadorActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
