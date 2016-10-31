package uniquindio.edu.co.proyectoandroid.actividades.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import uniquindio.edu.co.proyectoandroid.R;
import uniquindio.edu.co.proyectoandroid.actividades.modelo.Participante;

/**
 * @autor Diego Fernando Echeverry
 * @autor Luisa Maria Valderrama
 */
public class ParticipanteAdapterEnJuego extends  RecyclerView.Adapter<ParticipanteAdapterEnJuego.ParticipanteViewHolder>{

    private List<Participante> participantes;

    /**
     * metodo para inicializar los participante en juego
     * @param participantes
     */
    public ParticipanteAdapterEnJuego(List<Participante> participantes) {
        this.participantes = participantes;
    }

    /**
     * metodo para mostrar en un adaptadore los participantes en juego
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ParticipanteAdapterEnJuego.ParticipanteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adaptador_participantes_en_juego, parent, false);
        ParticipanteViewHolder nvh = new ParticipanteViewHolder(itemView);
        return nvh;
    }

    /**
     * metodo para recorre uno a uno ca de elemento de la lista de participantes
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ParticipanteAdapterEnJuego.ParticipanteViewHolder holder, int position) {
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

        /**
         * Metodo contructor para inicializar los componente que van a ser usados par amostrar los determinados valores
         * @param itemView
         */
        public ParticipanteViewHolder(View itemView) {
            super(itemView);
            txtNombre = (TextView) itemView.findViewById(R.id.labelnombre);
            imagen = (ImageView) itemView.findViewById(R.id.imagenparticipante);
        }

        /**
         * metodo para inicializar los valore de los items del adaptador de participantes en juegos
         * @param p
         */
        public void binParticipante(Participante p) {
            txtNombre.setText(p.getNombre());
            imagen.setImageResource(p.getFoto());
        }
    }
}
