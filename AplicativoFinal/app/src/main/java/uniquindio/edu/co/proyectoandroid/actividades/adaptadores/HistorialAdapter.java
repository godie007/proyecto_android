package uniquindio.edu.co.proyectoandroid.actividades.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import uniquindio.edu.co.proyectoandroid.R;
import uniquindio.edu.co.proyectoandroid.actividades.modelo.Historial;
import uniquindio.edu.co.proyectoandroid.actividades.modelo.Participante;

/**
 * Created by Godie007 on 10/25/2016.
 */
public class HistorialAdapter extends  RecyclerView.Adapter<HistorialAdapter.HistorialViewHolder>{

    private List<Historial> historiales;

    public HistorialAdapter(List<Historial> historiales) {
        this.historiales = historiales;
    }

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

    @Override
    public int getItemCount() {
        return historiales.size();
    }
    public static class HistorialViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNombre;
        private TextView txtDescripcion;


        public HistorialViewHolder(View itemView) {
            super(itemView);
            txtNombre = (TextView) itemView.findViewById(R.id.nombre);
            txtDescripcion = (TextView) itemView.findViewById(R.id.descripcion);
        }

        public void binParticipante(Historial p) {
            txtNombre.setText(p.getNombre());
            txtDescripcion.setText(p.getDescrpcion());
        }
    }
}
