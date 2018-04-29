package es.upv.pepelauraeloy.apptelem;

public class Asignatura {
    private int ID;
    private String nombre;
    private int rama;
    private int creditos;
    private float calificacion;
    private boolean terminada;
    private int semestre;

    public Asignatura(int ID, String nombre, int rama, int creditos, float calificacion, boolean terminada, int semestre) {
        this.ID = ID;
        this.nombre = nombre;
        this.rama = rama;
        this.creditos = creditos;
        this.calificacion = calificacion;
        this.terminada = terminada;
        this.semestre = semestre;
    }

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
        return rama;
    }

    public void setRama(int rama) {
        this.rama = rama;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public boolean isTerminada() {
        return terminada;
    }

    public void setTerminada(boolean terminada) {
        this.terminada = terminada;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
}
