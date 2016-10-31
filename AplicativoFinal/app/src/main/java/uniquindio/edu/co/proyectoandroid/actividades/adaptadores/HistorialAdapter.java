package uniquindio.edu.co.proyectoandroid.actividades.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import uniquindio.edu.co.proyectoandroid.R;
import uniquindio.edu.co.proyectoandroid.actividades.modelo.Historial;
/**
 * @autor Diego Fernando Echeverry
 * @autor Luisa Maria Valderrama
 */
public class HistorialAdapter extends  RecyclerView.Adapter<HistorialAdapter.HistorialViewHolder>{

    private List<Historial> historiales;

    /**
     * Metodo para inicializar la lista global de historiales
     * @param historiales
     */
    public HistorialAdapter(List<Historial> historiales) {
        this.historiales = historiales;
    }

    /**
     * Metodo para inicializar el listado de Historial
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public HistorialAdapter.HistorialViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adaptador_historial, parent, false);

        HistorialViewHolder nvh = new HistorialViewHolder(itemView);

        return nvh;
    }

    @Override
    public void onBindViewHolder(HistorialAdapter.HistorialViewHolder holder, int position) {
        Historial historial = historiales.get(position);
        holder.binParticipante(historial);
    }

    /**
     * este metodo returna el numer de elementos que tiene la lista de historiales
     * @return
     */
    @Override
    public int getItemCount() {
        return historiales.size();
    }
    public static class HistorialViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNombre;
        private TextView txtDescripcion;

        /**
         * Metodo contructor para inicializar en variales items de la interfaz
         * @param itemView
         */
        public HistorialViewHolder(View itemView) {
            super(itemView);
            txtNombre = (TextView) itemView.findViewById(R.id.nombre);
            txtDescripcion = (TextView) itemView.findViewById(R.id.descripcion);
        }

        /**
         * metodo para mostrar en en adaptador los elementos de la lista de historial
         * @param p
         */
        public void binParticipante(Historial p) {
            txtNombre.setText(p.getNombre());
            txtDescripcion.setText(p.getDescrpcion());
        }
    }
}
