package es.upv.pepelauraeloy.apptelem;

import java.io.Serializable;

public class Rama implements Serializable {
    private static final long serialVersionUID = 5950169519310163575L;
    int ID;
    private String nombre;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
