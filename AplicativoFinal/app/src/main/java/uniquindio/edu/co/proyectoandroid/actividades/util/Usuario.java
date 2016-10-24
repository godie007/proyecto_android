package uniquindio.edu.co.proyectoandroid.actividades.util;

import java.util.Date;

/**
 * Created by godie007 on 24/10/16.
 */

public class Usuario {
    private String nombre;
    private String password;
    private Date fechCreacion;

    /**
     * Metodo Constructor
     * @param nombre
     * @param password
     */
    public Usuario(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
        this.fechCreacion = new Date();
    }
    // metodos accesores y modificadores
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFechCreacion() {
        return fechCreacion;
    }

    public void setFechCreacion(Date fechCreacion) {
        this.fechCreacion = fechCreacion;
    }
}
