package uniquindio.edu.co.proyectoandroid.actividades.modelo;

/**
 * Created by Jack on 10/23/2016.
 */
public class Historial {


    private String nombre;
    private String descrpcion;

    public Historial(String nombre, String descrpcion) {
        this.nombre = nombre;
        this.descrpcion = descrpcion;
    }

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
