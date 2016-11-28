package uniquindio.edu.co.proyectoandroid.actividades.modelo;
/**
 * @autor Diego Fernando Echeverry
 * @autor Luisa Maria Valderrama
 */
public class Historial {

    // variable
    private String nombre;
    private String descrpcion;
    private String entrenador;

    /**
     * Metodo contructor
     * @param nombre
     * @param descrpcion
     */
    public Historial(String nombre, String descrpcion,String entrenador) {
        this.nombre = nombre;
        this.descrpcion = descrpcion;
        this.entrenador =entrenador;
    }
    // Metodos accesores y modificadores
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescrpcion() {
        return descrpcion;
    }

    @Override
    public String toString() {
        return "Historial{" +
                "nombre='" + nombre + '\'' +
                ", descrpcion='" + descrpcion + '\'' +
                ", entrenador='" + entrenador + '\'' +
                '}';
    }
}
