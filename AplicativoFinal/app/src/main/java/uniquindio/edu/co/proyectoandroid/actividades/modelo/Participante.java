package uniquindio.edu.co.proyectoandroid.actividades.modelo;

/**
 * @autor Diego Fernando Echeverry
 * @autor Luisa Maria Valderrama
 */
public class Participante {
    private String _id;
    private String enlace;
    private String estado;
    private String cedula;
    private String nombre;
    private String relacion;
    private String entrenador;
    private int foto;
    private int numVotos;

    /**
     * Metodo Constructor
     * @param nombre
     * @param foto
     */
    public Participante(String nombre, int foto) {
        this.nombre = nombre;
        this.foto = foto;
        numVotos =0;
    }

    /**
     * Metodo constructor
     * @param cedula
     * @param nombre
     * @param foto
     * @param entrenador
     * @param relacion
     * @param enlace
     * @param estado
     * @param numVotos
     */
    public Participante(String cedula, String nombre, int foto, String entrenador, String relacion, String enlace,String estado,int numVotos) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.foto = foto;
        this.entrenador = entrenador;
        this.relacion = relacion;
        this.enlace = enlace;
        this.estado =estado;
        this.numVotos =numVotos;
    }
    /**
     * Metodo constructor
     * @param cedula
     * @param nombre
     * @param foto
     * @param entrenador
     * @param relacion
     * @param enlace
     * @param estado
     * @param numVotos
     */
    public Participante(String cedula, String nombre, int foto, String entrenador, String relacion, String enlace,String estado,int numVotos,String _id) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.foto = foto;
        this.entrenador = entrenador;
        this.relacion = relacion;
        this.enlace = enlace;
        this.estado =estado;
        this.numVotos =numVotos;
        this._id=_id;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumVotos() {
        return numVotos;
    }

    public void setNumVotos(int numVotos) {
        this.numVotos = numVotos;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "_id='" + _id + '\'' +
                ", enlace='" + enlace + '\'' +
                ", estado='" + estado + '\'' +
                ", cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", relacion='" + relacion + '\'' +
                ", entrenador='" + entrenador + '\'' +
                ", foto=" + foto +
                ", numVotos=" + numVotos +
                '}';
    }
}
