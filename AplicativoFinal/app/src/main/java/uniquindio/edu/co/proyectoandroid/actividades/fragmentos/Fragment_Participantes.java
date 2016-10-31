package uniquindio.edu.co.proyectoandroid.actividades.fragmentos;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import uniquindio.edu.co.proyectoandroid.R;
import uniquindio.edu.co.proyectoandroid.actividades.adaptadores.HistorialAdapter;
import uniquindio.edu.co.proyectoandroid.actividades.adaptadores.ParticipanteAdapter;
import uniquindio.edu.co.proyectoandroid.actividades.modelo.Historial;
import uniquindio.edu.co.proyectoandroid.actividades.modelo.Participante;
/**
 * @autor Diego Fernando Echeverry
 * @autor Luisa Maria Valderrama
 */
public class Fragment_Participantes extends Fragment {

	public static final String ARG_ID_ENTRADA_SELECIONADA = "item_id";

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
		lista = (RecyclerView) rootView.findViewById(R.id.ListaParticipantes);
		lista.setHasFixedSize(true);
		List<Participante> participantes = new ArrayList<>();
		participantes.add(new Participante("Garfied",R.drawable.nick));
		participantes.add(new Participante("Juanes",R.drawable.juanes));
		participantes.add(new Participante("Michael",R.drawable.michael));
		ParticipanteAdapter participanteAdapter = new ParticipanteAdapter(participantes);
		lista.setAdapter(participanteAdapter);
		lista.setLayoutManager(new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.VERTICAL, false));

		return rootView;
	}
}