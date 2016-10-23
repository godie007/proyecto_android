package uniquindio.edu.co.proyectoandroid.actividades.adaptadores;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import uniquindio.edu.co.proyectoandroid.R;
import uniquindio.edu.co.proyectoandroid.actividades.modelo.Participante;

/**
 * Created by Luisa on 10/23/2016.
 */
public class ParticipanteAdapter extends  RecyclerView.Adapter<ParticipanteAdapter.ParticipanteViewHolder>{

    private List<Participante> participantes;

    public ParticipanteAdapter(List<Participante> participantes) {
        this.participantes = participantes;
    }

    @Override
    public ParticipanteAdapter.ParticipanteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adaptadorparticipante, parent, false);

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
    public static class ParticipanteViewHolder
            extends RecyclerView.ViewHolder {
        private TextView txtNombre;
        private ImageView imagen;
        private Button buttonver;

        public ParticipanteViewHolder(View itemView) {
            super(itemView);
            txtNombre = (TextView) itemView.findViewById(R.id.labelnombre);
            imagen = (ImageView) itemView.findViewById(R.id.imagenparticipante);
            buttonver = (Button) itemView.findViewById(R.id.botonver);
        }

        public void binParticipante(Participante p) {
            txtNombre.setText(p.getNombre());
            imagen.setImageResource(p.getFoto());
        }
    }
}
