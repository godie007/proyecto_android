package uniquindio.edu.co.proyectoandroid.actividades;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import uniquindio.edu.co.proyectoandroid.R;
import uniquindio.edu.co.proyectoandroid.actividades.modelo.Contactos;
import uniquindio.edu.co.proyectoandroid.actividades.modelo.MiBaseDatos;
import uniquindio.edu.co.proyectoandroid.actividades.util.Utilidades;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import org.json.JSONObject;

/**
 * @autor Diego Fernando Echeverry
 * @autor Luisa Maria Valderrama
 */
public class LoginActivity extends AppCompatActivity {
    //variables necesarias para gestionar el login
    private EditText usuario;
    private EditText password;
    List<Contactos> usuarios;
    CallbackManager callbackManager;

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

        // Initialize SDK before setContentView(Layout ID)
        FacebookSdk.sdkInitialize(getApplicationContext());

        MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

        // Escribimos 4 registros en nuestra tabla
        /**
            MDB.insertarCONTACTO(1, "dfe", "123");
            MDB.insertarCONTACTO(2, "root","123");
            MDB.insertarCONTACTO(3, "lmv",  "123");
            MDB.insertarCONTACTO(4, "123", "123");
         **/
        // Recuperamos los registros
        usuarios = MDB.recuperarCONTACTOS();

        setContentView(R.layout.activity_login);

        //se habilita el boton atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //se muestra el titulo con la nueva configuracion de idioma
        getSupportActionBar().setTitle(R.string.app_name);

        usuario = (EditText)findViewById(R.id.usuario);
        password = (EditText)findViewById(R.id.password);


        // Modificamos el registro 3
        //MDB.modificarCONTACTO(3, "PPPPP", 121212121, "xxxx@xxxx.es");
        // Borramos el registro 3
        //MDB.borrarCONTACTO(3);

    }
    // Private method to handle Facebook login and callback
    private void loginFacebook() {
        callbackManager = CallbackManager.Factory.create();

        // Set permissions
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("email","user_photos","public_profile"));

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {

                    System.out.println("Success");
                    GraphRequest.newMeRequest(
                            loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                                @Override
                                public void onCompleted(JSONObject json, GraphResponse response) {
                                    if (response.getError() != null) {
                                        Toast.makeText(getApplicationContext(), "Error al Iniciar Sesion Facebook!", Toast.LENGTH_LONG).show();
                                    } else {
                                        Intent intent = new Intent(getApplicationContext(), InicioAdminActivity.class);
                                        startActivity(intent);

                                    }
                                }

                            }).executeAsync();

                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(getApplicationContext(), "Se Cancelo Inicio de Sesion Facebook!", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(FacebookException error) {
                        Toast.makeText(getApplicationContext(), "Error al Iniciar Sesion Facebook!", Toast.LENGTH_LONG).show();
                    }
                });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        callbackManager.onActivityResult(requestCode, resultCode, data);
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

        if(nombre.equals("") && pass.equals("")){
            loginFacebook();
        }else{
            ingresar(nombre,pass);
        }

    }

    /**
     * Metodo para validar si los datos del usuario son validos y dependiendo del rol al que este registrado ingresa por una u otra actividad de inicio
     * @param nombre
     * @param password
     */
    public void ingresar(String nombre,String password){
        boolean error = true;
        if(Utilidades.estaConectado(getBaseContext())){

            for (Contactos us:usuarios) {
                if (us.getNick().equals(nombre) && us.getPassword().equals(password)){
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
        }else{
            Toast.makeText(LoginActivity.this, "No hay conexión a internet ", Toast.LENGTH_SHORT).show();
        }
    }

}
