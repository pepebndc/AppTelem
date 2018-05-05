package es.upv.pepelauraeloy.apptelem;

import java.io.Serializable;

public class Asignatura implements Serializable {
    private static final long serialVersionUID = 5950169519310163575L;
    private int ID;
    private String nombre;
    private int rama;
    private double creditos;
    private float calificacion;
    private int estado;
    private int semestre;

    //Estado: 0=Nada ; 1=quiero hacerla; 2= suspensa; 3=aprobada

    public Asignatura(int ID, String nombre, int rama, double creditos, float calificacion, int estado, int semestre) {
        this.ID = ID;
        this.nombre = nombre;
        this.rama = rama;
        this.creditos = creditos;
        this.calificacion = calificacion;
        this.estado = estado;
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

    public double getCreditos() {
        return creditos;
    }

    public void setCreditos(double creditos) {
        this.creditos = creditos;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
}
