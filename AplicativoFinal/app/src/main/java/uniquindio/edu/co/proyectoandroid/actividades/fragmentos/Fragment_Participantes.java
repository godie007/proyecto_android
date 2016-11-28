package uniquindio.edu.co.proyectoandroid.actividades.fragmentos;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import uniquindio.edu.co.proyectoandroid.R;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.util.EntityUtils;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.HttpClientBuilder;
import uniquindio.edu.co.proyectoandroid.actividades.modelo.Participante;
import uniquindio.edu.co.proyectoandroid.actividades.adaptadores.ParticipanteAdapter;


/**
 * @autor Diego Fernando Echeverry
 * @autor Luisa Maria Valderrama
 */
public class Fragment_Participantes extends Fragment {

	public static final String ARG_ID_ENTRADA_SELECIONADA = "item_id";
    private List<Participante> participantes = new ArrayList<>();
    private ParticipanteAdapter participanteAdapter;
    private String entrenador;

    private RecyclerView lista;


    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	/**
	 * metodo para mostrar el listado de participantes en un fragmento
	 * @param inflater
	 * @param container
	 * @param savedInstanceState
     * @return
     */

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.participantes_lista_fragmento, container, false);
        // se muestran los elementos del adaptador de participa para retornarlo en un framgento
        Hilo hiloSecundario = new Hilo(this.getContext());
        hiloSecundario.execute(0);

        lista = (RecyclerView) rootView.findViewById(R.id.ListaParticipantes);
		lista.setHasFixedSize(true);

        Bundle bundle = getArguments();
        if (bundle != null){
            entrenador = bundle.getString("Entrenador");
        }else{
            Log.v("->","No hay Argumentos");
        }


        return rootView;
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

            participanteAdapter = new ParticipanteAdapter(participantes);
            lista.setAdapter(participanteAdapter);
            lista.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        }

        public void  mostrarPersonajes() {
            if (entrenador != null) {


                HttpClient httpClient = HttpClientBuilder.create().build();
                HttpGet request = new HttpGet("http://10.0.2.2/participante/" + entrenador);
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
}