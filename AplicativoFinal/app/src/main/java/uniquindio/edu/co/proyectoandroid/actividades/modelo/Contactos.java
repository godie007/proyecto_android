package uniquindio.edu.co.proyectoandroid.actividades.modelo;

/**
 * @autor Diego Fernando Echeverry
 * @autor Luisa Maria Valderrama
 */
public class Contactos {

    private int id;
    private String nick;
    private String password;

    /**
     * Metodo Constructor
     * @param id
     * @param nick
     * @param password
     */
    public Contactos(int id, String nick, String password) {
        this.id = id;
        this.nick = nick;
        this.password = password;
    }
    // METODOS ACCESORES Y MODIFICADORES


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
