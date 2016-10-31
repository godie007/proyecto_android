package uniquindio.edu.co.proyectoandroid.actividades.adaptadores;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import uniquindio.edu.co.proyectoandroid.R;
import uniquindio.edu.co.proyectoandroid.actividades.DetallesDelParticipante;
import uniquindio.edu.co.proyectoandroid.actividades.InicioAdminActivity;
import uniquindio.edu.co.proyectoandroid.actividades.modelo.Participante;
/**
 * @autor Diego Fernando Echeverry
 * @autor Luisa Maria Valderrama
 */
public class ParticipanteAdapter extends  RecyclerView.Adapter<ParticipanteAdapter.ParticipanteViewHolder>{

    private List<Participante> participantes;

    /**
     * metodo constructor para inicializar el listado de particioantes
     * @param participantes
     */
    public ParticipanteAdapter(List<Participante> participantes) {
        this.participantes = participantes;
    }

    /**
     * metodo para mostrar en un adaptador el listado de participantes
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ParticipanteAdapter.ParticipanteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adaptador_participantes, parent, false);
        ParticipanteViewHolder nvh = new ParticipanteViewHolder(itemView);
        return nvh;
    }

    @Override
    public void onBindViewHolder(ParticipanteAdapter.ParticipanteViewHolder holder, int position) {
        Participante participante=participantes.get(position);
        holder.binParticipante(participante);
    }

    @Override
    public int getItemCount() {
        return participantes.size();
    }
    public static class ParticipanteViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNombre;
        private ImageView imagen;
        private TextView ver;

        /**
         * metodo para inicializar las variables de los elementos a mostrar in interfaz
         * @param itemView
         */
        public ParticipanteViewHolder(final View itemView) {
            super(itemView);
            txtNombre = (TextView) itemView.findViewById(R.id.labelnombre);
            imagen = (ImageView) itemView.findViewById(R.id.imagenparticipante);
            ver = (TextView) itemView.findViewById(R.id.ver);
            ver.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.getContext().startActivity(new Intent(v.getContext(), DetallesDelParticipante.class));
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
        }
    }
}
