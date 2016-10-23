package uniquindio.edu.co.proyectoandroid.actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import uniquindio.edu.co.proyectoandroid.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    public void verInicio(View view){
        //Toast.makeText(getApplicationContext(), "Ok Vamos a la otra Ventana", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, InicioActivity.class);
        startActivity(intent);
    }
}
