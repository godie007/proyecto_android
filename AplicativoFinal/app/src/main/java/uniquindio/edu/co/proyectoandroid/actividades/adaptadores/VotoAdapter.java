package uniquindio.edu.co.proyectoandroid.actividades.adaptadores;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.FacebookSdk;

import java.util.List;
import uniquindio.edu.co.proyectoandroid.R;
import uniquindio.edu.co.proyectoandroid.actividades.DetallesDelParticipante;
import uniquindio.edu.co.proyectoandroid.actividades.modelo.Participante;


/**
 * @autor Diego Fernando Echeverry
 * @autor Luisa Maria Valderrama
 */
public class VotoAdapter extends  RecyclerView.Adapter<VotoAdapter.VotoViewHolder>{
    private List<Participante> participantes;

    /**
     * metodo constructor para inicializar el listado de particioantes
     * @param participantes
     */
    public VotoAdapter(List<Participante> participantes) {
        this.participantes = participantes;
    }

    /**
     * metodo para mostrar en un adaptador el listado de participantes
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public VotoAdapter.VotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adaptador_voto, parent, false);
        VotoAdapter.VotoViewHolder nvh = new VotoAdapter.VotoViewHolder(itemView);
        return nvh;
    }

    @Override
    public void onBindViewHolder(VotoViewHolder holder, int position) {
        Participante participante=participantes.get(position);
        holder.binParticipante(participante);
    }


    @Override
    public int getItemCount() {
        return participantes.size();
    }
    public static class VotoViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNombre;
        private ImageView imagen;
        private ImageButton ver;
        private TextView numVotos;

        /**
         * metodo para inicializar las variables de los elementos a mostrar in interfaz
         * @param itemView
         */
        public VotoViewHolder(final View itemView) {
            super(itemView);
            txtNombre = (TextView) itemView.findViewById(R.id.nombre);
            imagen = (ImageView) itemView.findViewById(R.id.imagen);
            numVotos  = (TextView) itemView.findViewById(R.id.numero);
            ver = (ImageButton) itemView.findViewById(R.id.btn_voto);
            ver.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //v.getContext().startActivity(new Intent(v.getContext(), DetallesDelParticipante.class));
                }
            });
        }

        /**
         * Metodo para inicializar los valores de un participantes en lo elemento del adaptadore
         * @param p
         */
        public void binParticipante(Participante p) {
            txtNombre.setText(p.getNombre());
            imagen.setImageResource(p.getFoto());
            numVotos.setText(""+p.getNumVotos());
        }
    }
}
