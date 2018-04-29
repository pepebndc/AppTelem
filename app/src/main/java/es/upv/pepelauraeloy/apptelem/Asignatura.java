package es.upv.pepelauraeloy.apptelem;

public class Asignatura {
    private int ID;
    private String nombre;
    private int Rama;
    private int Creditos;
    private float Calificacion;
    private boolean terminada;


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

    public int getRama() {
        return Rama;
    }

    public void setRama(int rama) {
        Rama = rama;
    }

    public int getCreditos() {
        return Creditos;
    }

    public void setCreditos(int creditos) {
        Creditos = creditos;
    }

    public float getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(float calificacion) {
        Calificacion = calificacion;
    }

    public boolean isTerminada() {
        return terminada;
    }

    public void setTerminada(boolean terminada) {
        this.terminada = terminada;
    }
}
