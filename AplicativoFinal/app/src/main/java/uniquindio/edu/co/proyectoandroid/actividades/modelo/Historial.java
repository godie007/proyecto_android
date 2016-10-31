package uniquindio.edu.co.proyectoandroid.actividades.modelo;
/**
 * @autor Diego Fernando Echeverry
 * @autor Luisa Maria Valderrama
 */
public class Historial {

    // variable
    private String nombre;
    private String descrpcion;

    /**
     * Metodo contructor
     * @param nombre
     * @param descrpcion
     */
    public Historial(String nombre, String descrpcion) {
        this.nombre = nombre;
        this.descrpcion = descrpcion;
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

    public void setDescrpcion(String descrpcion) {
        this.descrpcion = descrpcion;
    }
}
