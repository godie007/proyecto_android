package uniquindio.edu.co.proyectoandroid.actividades;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import uniquindio.edu.co.proyectoandroid.R;
import uniquindio.edu.co.proyectoandroid.actividades.util.Usuario;
/**
 * @autor Diego Fernando Echeverry
 * @autor Luisa Maria Valderrama
 */
public class LoginActivity extends AppCompatActivity {
    //variables necesarias para gestionar el login
    private EditText usuario;
    private EditText password;
    ArrayList<Usuario> usuarios;
    /**
     * Metodo para inicializar la activdad de participantes
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // se configura el idioma inicial
        Locale locale = new Locale("ES");
        Locale.setDefault(locale);
        Resources resources = this.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());

        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("dfe","123"));
        usuarios.add(new Usuario("root","123"));

        setContentView(R.layout.activity_login);

        //se habilita el boton atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //se muestra el titulo con la nueva configuracion de idioma
        getSupportActionBar().setTitle(R.string.app_name);

        usuario = (EditText)findViewById(R.id.usuario);
        password = (EditText)findViewById(R.id.password);


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

    /**
     * este metodo se ejecuta al momento de presionar en el boton iniciar sesion en la actividad login
     * @param view
     */
    public void verInicio(View view){
        String nombre = usuario.getText().toString();
        String pass = password.getText().toString();
        ingresar(nombre,pass);
    }

    /**
     * Metodo para validar si los datos del usuario son validos y dependiendo del rol al que este registrado ingresa por una u otra actividad de inicio
     * @param nombre
     * @param password
     */
    public void ingresar(String nombre,String password){
        boolean error = true;
        for (Usuario us:usuarios) {
            if (us.getNombre().equals(nombre) && us.getPassword().equals(password)){
                error = false;
                if (nombre.equals("root")){
                    Intent intent = new Intent(this, InicioAdminActivity.class);
                    startActivity(intent);
                    break;
                }else{
                    Intent intent = new Intent(this, InicioActivity.class);
                    startActivity(intent);
                    break;
                }
            }
        }
        if (error) {
            Toast.makeText(getApplicationContext(), "Datos Incorrectos!", Toast.LENGTH_LONG).show();
        }
    }

}
