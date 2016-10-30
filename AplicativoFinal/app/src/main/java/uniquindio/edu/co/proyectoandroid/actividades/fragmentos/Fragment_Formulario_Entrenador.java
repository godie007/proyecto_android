package uniquindio.edu.co.proyectoandroid.actividades.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uniquindio.edu.co.proyectoandroid.R;

public class Fragment_Formulario_Entrenador extends Fragment {

	public static final String ARG_ID_ENTRADA_SELECIONADA = "item_id";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.formulario_detalle_entrenador_fragmento, container, false);
		return rootView;
	}
}