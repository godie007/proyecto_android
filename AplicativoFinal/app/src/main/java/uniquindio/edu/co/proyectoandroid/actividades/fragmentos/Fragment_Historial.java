package uniquindio.edu.co.proyectoandroid.actividades.fragmentos;


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
import uniquindio.edu.co.proyectoandroid.actividades.modelo.Historial;
/**
 * @autor Diego Fernando Echeverry
 * @autor Luisa Maria Valderrama
 */
public class Fragment_Historial extends Fragment {

	public static final String ARG_ID_ENTRADA_SELECIONADA = "item_id";

	private RecyclerView lista;

	/**
	 * Metodo para mostrar un fragmento
	 * @param inflater
	 * @param container
	 * @param savedInstanceState
     * @return
     */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.historial_lista_fragmento, container, false);
        // se muestra el listado de historiales en un adaptador para luego retornalo como fragmento
		lista = (RecyclerView) rootView.findViewById(R.id.ListaHistorial);
		lista.setHasFixedSize(true);
		List<Historial> historials = new ArrayList<>();
		historials.add(new Historial("Historial 1","ocurre un evento"));
		historials.add(new Historial("Historial 2","ocurre un evento"));
		historials.add(new Historial("Historial 3","ocurre un evento"));
		historials.add(new Historial("Historial 4","ocurre un evento"));
		HistorialAdapter historialAdapter=new HistorialAdapter(historials);
		lista.setAdapter(historialAdapter);
		lista.setLayoutManager(new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.VERTICAL, false));

		return rootView;
	}
}