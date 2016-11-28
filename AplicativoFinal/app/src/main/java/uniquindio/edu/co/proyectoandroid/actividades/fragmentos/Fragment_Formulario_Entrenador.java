package uniquindio.edu.co.proyectoandroid.actividades.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import uniquindio.edu.co.proyectoandroid.R;
import uniquindio.edu.co.proyectoandroid.actividades.InicioActivity;

/**
 * @autor Diego Fernando Echeverry
 * @autor Luisa Maria Valderrama
 */
public class Fragment_Formulario_Entrenador extends Fragment {

	public static final String ARG_ID_ENTRADA_SELECIONADA = "item_id";

	/**
	 * Metodo para mostrar un fragmento
	 * @param inflater
	 * @param container
	 * @param savedInstanceState
     * @return
     */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.formulario_detalle_entrenador_fragmento, container, false);

		return rootView;
	}

}