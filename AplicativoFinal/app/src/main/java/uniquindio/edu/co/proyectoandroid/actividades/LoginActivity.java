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

public class LoginActivity extends AppCompatActivity {
    private EditText usuario;
    private EditText password;
    ArrayList<Usuario> usuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Locale locale = new Locale("ES");
        Locale.setDefault(locale);
        Resources resources = this.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        getSupportActionBar().setTitle(R.string.app_name);

        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("dfe","123"));
        usuarios.add(new Usuario("root","123"));

        setContentView(R.layout.activity_login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        usuario = (EditText)findViewById(R.id.usuario);
        password = (EditText)findViewById(R.id.password);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    public void verInicio(View view){
        String nombre = usuario.getText().toString();
        String pass = password.getText().toString();
        ingresar(nombre,pass);
    }

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
