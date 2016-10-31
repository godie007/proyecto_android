package uniquindio.edu.co.proyectoandroid.actividades.modelo;
/**
 * @autor Diego Fernando Echeverry
 * @autor Luisa Maria Valderrama
 */
public class Voto {

    private String nombre;
    private int foto;
    private int numero;

    /**
     * Metodo Constructor
     * @param nombre
     * @param foto
     * @param numero
     */
    public Voto(String nombre, int foto, int numero) {
        this.nombre = nombre;
        this.foto = foto;
        this.numero = numero;
    }
    // metodos accesores y modificadores
    public String getNombre() {
        return nombre;
    }
    public int getFoto() {
        return foto;
    }
    public int getNumero() {
        return numero;
    }


}
