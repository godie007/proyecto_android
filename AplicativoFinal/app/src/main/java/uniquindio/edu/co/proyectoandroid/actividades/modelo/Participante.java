package uniquindio.edu.co.proyectoandroid.actividades.modelo;

/**
 * @autor Diego Fernando Echeverry
 * @autor Luisa Maria Valderrama
 */
public class Participante {

    private String cedula;
    private String nombre;
    private int foto;
    private String entrenador;
    private String relacion;
    private String enlace;

    /**
     * Metodo Constructor
     * @param nombre
     * @param foto
     */
    public Participante(String nombre, int foto) {
        this.nombre = nombre;
        this.foto = foto;
    }
    // Metodos accesores y modificadores
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
}
