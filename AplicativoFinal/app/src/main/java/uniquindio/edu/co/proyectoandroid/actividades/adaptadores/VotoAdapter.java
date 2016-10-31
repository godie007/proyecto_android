package uniquindio.edu.co.proyectoandroid.actividades.adaptadores;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import uniquindio.edu.co.proyectoandroid.R;
import uniquindio.edu.co.proyectoandroid.actividades.DetallesDelParticipante;
import uniquindio.edu.co.proyectoandroid.actividades.modelo.Voto;

/**
 * @autor Diego Fernando Echeverry
 * @autor Luisa Maria Valderrama
 */
public class VotoAdapter extends  RecyclerView.Adapter<VotoAdapter.VotoViewHolder>{

    private List<Voto> participantes;

    /**
     *  Metodo para asi
     * @param participantes
     */
    public VotoAdapter(List<Voto> participantes) {
        this.participantes = participantes;
    }

    /**
     * Metodo para crear la lista
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public VotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adaptador_voto, parent, false);
        VotoViewHolder nvh = new VotoViewHolder(itemView);
        return nvh;
    }

    /**
     * Metodo para inicializar valores
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(VotoViewHolder holder, int position) {
        Voto participante=participantes.get(position);
        holder.binParticipante(participante);
    }

    @Override
    public int getItemCount() {
        return participantes.size();
    }
    public static class VotoViewHolder extends RecyclerView.ViewHolder {
        private TextView nombre;
        private ImageView imagen;
        private TextView numero;
        private ImageButton btn_voto;

        /**
         * Metodo contructor para el uso de la lista de Participantes en votacion
         * @param itemView
         */
        public VotoViewHolder(final View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            imagen = (ImageView) itemView.findViewById(R.id.imagen);
            numero = (TextView) itemView.findViewById(R.id.numero);
            btn_voto = (ImageButton) itemView.findViewById(R.id.btn_voto);
            // evento para el boton agregar voto
            btn_voto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.getContext().startActivity(new Intent(v.getContext(), DetallesDelParticipante.class));
                }
            });

        }

        /**
         * Metodo para inicializar los valores de cada item de la lista de Participantes en votacion
         * @param p
         */
        public void binParticipante(Voto p) {
            nombre.setText(p.getNombre());
            imagen.setImageResource(p.getFoto());
            numero.setText(""+p.getNumero());
        }
    }
}
