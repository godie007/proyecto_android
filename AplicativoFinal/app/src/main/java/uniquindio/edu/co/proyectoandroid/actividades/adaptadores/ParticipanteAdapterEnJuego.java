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
 * Created by Luisa on 10/23/2016.
 */
public class ParticipanteAdapterEnJuego extends  RecyclerView.Adapter<ParticipanteAdapterEnJuego.ParticipanteViewHolder>{

    private List<Participante> participantes;

    public ParticipanteAdapterEnJuego(List<Participante> participantes) {
        this.participantes = participantes;
    }

    @Override
    public ParticipanteAdapterEnJuego.ParticipanteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adaptador_participantes_en_juego, parent, false);
        ParticipanteViewHolder nvh = new ParticipanteViewHolder(itemView);
        return nvh;
    }

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

        public ParticipanteViewHolder(View itemView) {
            super(itemView);
            txtNombre = (TextView) itemView.findViewById(R.id.labelnombre);
            imagen = (ImageView) itemView.findViewById(R.id.imagenparticipante);
        }

        public void binParticipante(Participante p) {
            txtNombre.setText(p.getNombre());
            imagen.setImageResource(p.getFoto());
        }
    }
}
