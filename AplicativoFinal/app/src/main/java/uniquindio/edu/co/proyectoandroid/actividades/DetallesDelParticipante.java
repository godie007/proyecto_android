package uniquindio.edu.co.proyectoandroid.actividades;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.client.methods.HttpPut;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.impl.client.HttpClientBuilder;
import cz.msebera.android.httpclient.util.EntityUtils;
import uniquindio.edu.co.proyectoandroid.R;
import uniquindio.edu.co.proyectoandroid.actividades.modelo.Participante;

/**
 * @autor Diego Fernando Echeverry
 * @autor Luisa Maria Valderrama
 */
public class DetallesDelParticipante extends AppCompatActivity {
    private Spinner entrenador;
    private Spinner universidad;
    private Spinner estado;
    private TextView nombre;
    private TextView cedula;
    private TextView numero;
    private TextView enlace;
    private String id;
    private List<Participante> participantes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_del_participante);
        //se habilita el boton atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //se muestra el titulo con la nueva configuracion de idioma
        getSupportActionBar().setTitle(R.string.app_name);

        entrenador= (Spinner)findViewById(R.id.entrenador);
        String[] items = new String[]{"Jonny Rivera", "Rihana", "Adele"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        entrenador.setAdapter(adapter);

        universidad = (Spinner)findViewById(R.id.univercity);
        String[] items2 = new String[]{"Uniquindio", "Eafi", "Andes","Pontifica","EAM","Andes"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        universidad.setAdapter(adapter2);

        estado = (Spinner)findViewById(R.id.estado);
        String[] items3 = new String[]{"Activo", "Innactivo"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items3);
        estado.setAdapter(adapter3);
        nombre = (TextView) findViewById(R.id.nombre);
        cedula = (TextView) findViewById(R.id.cedula);
        numero = (TextView) findViewById(R.id.votos);
        enlace = (TextView) findViewById(R.id.enlace);

        Bundle bundle = getIntent().getExtras();
        if (bundle!= null){
            id = bundle.getString("id");
            if (id != null){
                HiloGET hiloSecundario = new HiloGET(getApplicationContext());
                hiloSecundario.execute(id);
            }
        }

        ImageButton btn_imagen = (ImageButton)findViewById(R.id.imageButton);
        btn_imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.parse("file://" + "/sdcard/test.jpg"), "image/*");
                startActivity(intent);
            }
        });
        Button clickButton = (Button) findViewById(R.id.btn_guardar);
        clickButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id==null){
                    ingresar();
                }else{
                    actualizar();
                }
            }
        });

    }

    private void actualizar() {
        try {
            //Participante(cedula,nombre,foto,entrenador,relacion,enlace)
            new HiloPUT().execute("http://10.0.2.2/participante/",
                    cedula.getText().toString(),
                    nombre.getText().toString(),
                    "2130837594",
                    entrenador.getSelectedItemPosition()+"",
                    universidad.getSelectedItemPosition()+"",
                    enlace.getText().toString(),
                    estado.getSelectedItemPosition()+"",
                    numero.getText().toString(),
                    id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
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
    public void ingresar(){

        try {
            //Participante(cedula,nombre,foto,entrenador,relacion,enlace)
            new HiloPOST().execute("http://10.0.2.2/participante/",
                    cedula.getText().toString(),
                    nombre.getText().toString(),
                    "2130837594",
                    entrenador.getSelectedItemPosition()+"",
                    universidad.getSelectedItemPosition()+"",
                    enlace.getText().toString(),
                    estado.getSelectedItemPosition()+"",
                    numero.getText().toString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    class HiloPOST extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... arg0) {
            String text =null;
            try {
                HttpClient httpClient = HttpClientBuilder.create().build();
                HttpPost httppost = new HttpPost(arg0[0]);
                httppost.setHeader("content-type", "application/json");


                //Participante(cedula,nombre,foto,entrenador,relacion,enlace,estado,numVotos)
                Participante maicol = new Participante(arg0[1], arg0[2],Integer.parseInt(arg0[3]),arg0[4],arg0[5],arg0[6],arg0[7],Integer.parseInt(arg0[8]));
                Gson gson= new Gson();
                String json = gson.toJson(maicol);
                StringEntity entity = new StringEntity(json);
                httppost.setEntity(entity);
                HttpResponse resp = httpClient.execute(httppost);
                HttpEntity ent = resp.getEntity();
                text = EntityUtils.toString(ent);
                Log.v("salida",text);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            return text;
        }

        @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);

        }

    }
    public class HiloGET extends AsyncTask<String,Void,String>{
        private Context context;

        public HiloGET(Context contexto){
            context = contexto;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... arg0) {
            mostrarPersonajes(arg0[0]);
            return arg0[0];
        }

        @Override
        protected void onPostExecute(String integer) {
            super.onPostExecute(integer);
            nombre.setText(participantes.get(0).getNombre());
            cedula.setText(participantes.get(0).getCedula());
            entrenador.setSelection(Integer.parseInt(participantes.get(0).getEntrenador()));
            universidad.setSelection(Integer.parseInt(participantes.get(0).getRelacion()));
            numero.setText(" "+participantes.get(0).getNumVotos());
            enlace.setText(participantes.get(0).getEnlace());
            estado.setSelection(Integer.parseInt(participantes.get(0).getEstado()));

        }

        public void  mostrarPersonajes(String participante) {
            if (entrenador != null) {

                HttpClient httpClient = HttpClientBuilder.create().build();
                HttpGet request = new HttpGet("http://10.0.2.2/buscar/"+participante);
                request.setHeader("content-type", "application/json");

                try {

                    Type listType = new TypeToken<ArrayList<Participante>>() {
                    }.getType();
                    GsonBuilder gsonBuilder = new GsonBuilder();

                    HttpResponse resp = httpClient.execute(request);
                    String respStr = EntityUtils.toString(resp.getEntity());


                    Gson gson = gsonBuilder.create();
                    participantes = gson.fromJson(respStr, listType);
                    Log.v("salida", participantes.get(0).toString());

                } catch (Exception e) {
                    e.printStackTrace();
                    Log.v("Listar-WebService", e.getMessage());
                }
            }
        }
    }
    class HiloPUT extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... arg0) {
            String text =null;
            try {
                HttpClient httpClient = HttpClientBuilder.create().build();
                HttpPut httppost = new HttpPut(arg0[0]);
                httppost.setHeader("content-type", "application/json");


                //Participante(cedula,nombre,foto,entrenador,relacion,enlace,estado,numVotos)
                Participante maicol = new Participante(arg0[1], arg0[2],Integer.parseInt(arg0[3].trim()),arg0[4],arg0[5],arg0[6],arg0[7],Integer.parseInt(arg0[8].trim()),arg0[9].trim());
                Gson gson= new Gson();
                String json = gson.toJson(maicol);
                StringEntity entity = new StringEntity(json);
                httppost.setEntity(entity);
                HttpResponse resp = httpClient.execute(httppost);
                HttpEntity ent = resp.getEntity();
                text = EntityUtils.toString(ent);
                Log.v("salida",text);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            return text;
        }

        @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);

        }

    }
}
