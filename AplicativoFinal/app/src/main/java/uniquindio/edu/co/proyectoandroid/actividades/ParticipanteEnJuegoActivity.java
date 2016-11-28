package uniquindio.edu.co.proyectoandroid.actividades;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.HttpClientBuilder;
import cz.msebera.android.httpclient.util.EntityUtils;
import uniquindio.edu.co.proyectoandroid.R;
import uniquindio.edu.co.proyectoandroid.actividades.adaptadores.ParticipanteAdapter;
import uniquindio.edu.co.proyectoandroid.actividades.adaptadores.ParticipanteAdapterEnJuego;
import uniquindio.edu.co.proyectoandroid.actividades.modelo.Participante;
/**
 * @autor Diego Fernando Echeverry
 * @autor Luisa Maria Valderrama
 */
public class ParticipanteEnJuegoActivity extends AppCompatActivity {
    private RecyclerView lista;
    private List<Participante> participantes = new ArrayList<>();
     ParticipanteAdapterEnJuego participanteAdapter = new ParticipanteAdapterEnJuego(participantes);
    /**
     * Metodo para inicializar la activdad de participantes en Juego
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participante_en_juego);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(R.string.app_name);

        ParticipanteEnJuegoActivity.Hilo hiloSecundario = new ParticipanteEnJuegoActivity.Hilo(this.getApplicationContext());
        hiloSecundario.execute(0);

        lista = (RecyclerView) findViewById(R.id.ListaParticipanteEnJuego);
        lista.setHasFixedSize(true);


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
    public class Hilo extends AsyncTask<Integer, Integer, Integer> {
        private Context context;

        public Hilo(Context contexto){
            context = contexto;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Integer doInBackground(Integer... params) {
            mostrarPersonajes();
            return params[0];
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);

            participanteAdapter = new ParticipanteAdapterEnJuego(participantes);
            lista.setAdapter(participanteAdapter);
            lista.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        }

        public void  mostrarPersonajes() {


            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet("http://10.0.2.2/participanteJuego/");
            request.setHeader("content-type", "application/json");

            try {

                Type listType = new TypeToken<ArrayList<Participante>>() {
                }.getType();
                GsonBuilder gsonBuilder = new GsonBuilder();

                HttpResponse resp = httpClient.execute(request);
                String respStr = EntityUtils.toString(resp.getEntity());


                Gson gson = gsonBuilder.create();
                participantes = gson.fromJson(respStr, listType);
                Log.v("salida",participantes.get(0).toString());


            } catch (Exception e) {
                e.printStackTrace();
                Log.v("Listar-WebService", e.getMessage());
            }
        }

    }
}
