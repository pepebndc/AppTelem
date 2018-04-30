package es.upv.pepelauraeloy.apptelem;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 5950169519310163575L;

    private ArrayList<Asignatura> asignaturas;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    private String Nombre;

    public Usuario() {
        //Creación de un usuario por defecto
        Asignatura MATI = new Asignatura (12396, "MAT I - Matemáticas I", 0, 7.5 , 0, 0, 1);
        Asignatura MATII = new Asignatura (12397, "MAT II - Matemáticas II", 0, 7.5 , 0, 0, 2);
        Asignatura FISICAI = new Asignatura (12399, "FISICA I - Física I", 0, 6 , 0, 0, 1);
        Asignatura FISICAII = new Asignatura (12398, "FISICA II - Física II", 0, 6 , 0, 0, 2);
        Asignatura PROGRAM = new Asignatura (12400, "PROGRAM - Programación", 0, 6 , 0, 0, 1);
        Asignatura EMP = new Asignatura (12401, "EMP - Fundamentos de organización y gestión de empresas", 0, 6 , 0, 0, 2);
        Asignatura TEOCIR = new Asignatura (12404, "TEOCIR - Teoría de circuitos", 0, 6 , 0, 0, 1);
        Asignatura DELEC = new Asignatura (12402, "DELEC - Dispositivos electrónicos", 0, 6 , 0, 0, 2);
        Asignatura CELEC = new Asignatura (12403, "CELEC - Circuitos electrónicos", 0, 6 , 0, 0, 3);
        Asignatura SYS = new Asignatura (12405, "SYS - Señales y sistemas", 0, 6 , 0, 0, 3);
        Asignatura FTELEM = new Asignatura (12416, "FTELEM - Fundamentos de telemática", 0, 4.5 , 0, 0, 2);
        Asignatura ARQTEL = new Asignatura (12414, "ARQTEL - Arquitecturas telemáticas", 0, 4.5 , 0, 0, 3);
        Asignatura REDTEL = new Asignatura (12415, "REDTEL - Redes telemáticas", 0, 4.5 , 0, 0, 4);
        Asignatura DST = new Asignatura (12413, "DST - Diseño de servicios telemáticos", 0, 4.5 , 0, 0, 5);
        Asignatura FSD = new Asignatura (12411, "FSD - Fundamentos de sistemas digitales", 0, 4.5 , 0, 0, 3);
        Asignatura SDP = new Asignatura (12412, "SDP - Sistemas digitales programables", 0, 4.5 , 0, 0, 4);
        Asignatura SMICRO = new Asignatura (12410, "SMICRO - Sistemas microprocesadores", 0, 4.5 , 0, 0, 4);
        Asignatura ENERGIA = new Asignatura (12409, "ENERGIA - Conversión y procesado de energía", 0, 4.5 , 0, 0, 5);
        Asignatura ACUST = new Asignatura (12417, "ACUST - Acústica", 0, 4.5 , 0, 0, 4);
        Asignatura TCOM = new Asignatura (12407, "TCOM - Teoría de la comunicación", 0, 6 , 0, 0, 4);
        Asignatura ONDAS = new Asignatura (12406, "ONDAS - Radiación y propagación de ondas", 0, 6 , 0, 0, 4);
        Asignatura FTRANS = new Asignatura (12408, "FTRANS - Fundamentos de transmisión", 0, 7.5 , 0, 0, 5);
        Asignatura FCO = new Asignatura (12419, "FCO - Fundamentos de computadores", 0, 4.5 , 0, 0, 1);
        Asignatura MATIII = new Asignatura (12418, "MAT III - Matemáticas III", 0, 4.5 , 0, 0, 3);
        Asignatura PYSA = new Asignatura (12420, "PYSA - Probabilidad y señales aleatorias", 0, 4.5 , 0, 0, 3);
        Asignatura INGLES = new Asignatura (12424, "INGLES - Inglés para fines académicos y profesionales (nivel B2)", 0, 4.5 , 0, 0, 5);
        Asignatura FRANCES = new Asignatura (13773, "FRANCES - Francés - B2", 0, 4.5 , 0, 0, 5);
        Asignatura ALEMAN = new Asignatura (13765, "ALEMAN - Alemán - B2", 0, 4.5 , 0, 0, 5);
        Asignatura POLITICA = new Asignatura (12421, "POLITICA - Política y normativa de telecomunicación", 0, 4.5 , 0, 0, 6);

        Asignatura VALEN = new Asignatura (13787, "VALEN - Valenciano técnico aplicado a la informática y telecomunicaciones - C1", 0, 4.5 , 0, 0, 7);

        Asignatura TDSI = new Asignatura (12428, "TDS I - Tratamiento digital de señales en comunicaciones I", 1, 4.5 , 0, 0, 5);
        Asignatura TDSII = new Asignatura (12430, "TDS II - Tratamiento digital de señales en comunicaciones II", 1, 4.5 , 0, 0, 6);
        Asignatura COMDIG = new Asignatura (12429, "COMDIG - Comunicaciones digitales", 1, 4.5 , 0, 0, 7);
        Asignatura ANTENAS = new Asignatura (13172, "ANTENAS - Antenas", 1, 4.5 , 0, 0, 5);
        Asignatura RADIO = new Asignatura (12433, "RADIO - Radiocomunicaciones", 1, 4.5 , 0, 0, 6);
        Asignatura MICROO = new Asignatura (13173, "MICROO - Microondas", 1, 4.5 , 0, 0, 7);
        Asignatura LINEAS = new Asignatura (12434, "LINEAS - Líneas de transmisión", 1, 4.5 , 0, 0, 6);
        Asignatura SCOMOP = new Asignatura (12431, "SCOMOP - Sistemas de comunicaciones ópticas", 1, 4.5 , 0, 0, 7);
        Asignatura ACCESO = new Asignatura (12432, "ACCESO - Tecnologías y sistemas en redes de acceso", 1, 4.5 , 0, 0, 8);
        Asignatura FCOPTI = new Asignatura (12426, "FCOPTI - Fundamentos de comunicaciones ópticas", 1, 4.5 , 0, 0, 6);
        Asignatura COMMOV = new Asignatura (13174, "COMMOV - Comunicaciones móviles e inalámbricas", 1, 4.5 , 0, 0, 7);
        Asignatura COMESP = new Asignatura (13175, "COMESP - Comunicaciones espaciales", 1, 4.5 , 0, 0, 7);
        Asignatura RDETER = new Asignatura (12425, "RDETER - Radiodeterminación", 1, 4.5 , 0, 0, 8);
        Asignatura ANALOG = new Asignatura (12456, "ANALOG - Electrónica analógica integrada", 2, 4.5 , 0, 0, 5);
        Asignatura INSTRU = new Asignatura (12449, "INSTRU - Instrumentación y calidad", 2, 6 , 0, 0, 5);
        Asignatura SEC = new Asignatura (12455, "SEC - Sistemas electrónicos de comunicaciones", 2, 6 , 0, 0, 6);
        Asignatura SENSORES = new Asignatura (12448, "SENSORES - Sensores", 2, 4.5 , 0, 0, 6);
        Asignatura VLSI = new Asignatura (12452, "VLSI - Fundamentos de VLSI", 2, 4.5 , 0, 0, 6);
        Asignatura APMICRO = new Asignatura (12453, "APMICRO - Aplicaciones de los microcontroladores", 2, 4.5 , 0, 0, 6);
        Asignatura ANAMIX = new Asignatura (12454, "ANAMIX - Microelectrónica analógica y mixta", 2, 4.5 , 0, 0, 7);
        Asignatura DSP = new Asignatura (12451, "DSP - Procesadores digitales de señal", 2, 4.5 , 0, 0, 7);
        Asignatura ISDIGI = new Asignatura (12450, "ISDIGI - Integración de sistemas digitales", 2, 6 , 0, 0, 7);
        Asignatura DSELEC = new Asignatura (12462, "DSELEC - Desarrollo de sistemas electrónicos", 2, 4.5 , 0, 0, 7);
        Asignatura INSBIO = new Asignatura (12461, "INSBIO - Instrumentación biomédica", 2, 4.5 , 0, 0, 8);
        Asignatura SCBIO = new Asignatura (12457, "SCBIO - Sistemas complejos bioinspirados", 2, 4.5 , 0, 0, 8);
        Asignatura AMBIEN = new Asignatura (12466, "AMBIEN - Acústica ambiental", 3, 6 , 0, 0, 5);
        Asignatura ARQUIT = new Asignatura (12465, "ARQUIT - Acústica arquitectónica", 3, 6 , 0, 0, 6);
        Asignatura TDS = new Asignatura (12464, "TDS - Tratamiento digital de señales", 3, 6 , 0, 0, 5);
        Asignatura TDI = new Asignatura (12463, "TDI - Tratamiento de imágenes", 3, 4.5 , 0, 0, 6);
        Asignatura AUDIO = new Asignatura (12471, "AUDIO - Equipos y sistemas de audio", 3, 6 , 0, 0, 6);
        Asignatura VIDEO = new Asignatura (12473, "VIDEO - Sistemas de vídeo", 3, 6 , 0, 0, 7);
        Asignatura TDA = new Asignatura (12472, "TDA - Tratamiento digital de audio", 3, 6 , 0, 0, 7);
        Asignatura PRODAU = new Asignatura (12470, "PRODAU - Producción audiovisual", 3, 4.5 , 0, 0, 8);
        Asignatura MULTIM = new Asignatura (12469, "MULTIM - Difusión telemática de contenidos multimedia", 3, 4.5 , 0, 0, 7);
        Asignatura AUDIOV = new Asignatura (12468, "AUDIOV - Distribución de señales audiovisuales", 3, 4.5 , 0, 0, 7);
        Asignatura PROYIA = new Asignatura (12467, "PROYIA - Proyectos e instalaciones audiovisuales", 3, 4.5 , 0, 0, 8);
        Asignatura CONMUT = new Asignatura (12438, "CONMUT - Conmutación", 4, 4.5 , 0, 0, 5);
        Asignatura RAL = new Asignatura (12439, "RAL - Redes de área local", 4, 6 , 0, 0, 6);
        Asignatura RCORPO = new Asignatura (12437, "RCORPO - Redes corporativas", 4, 6 , 0, 0, 7);
        Asignatura RPA = new Asignatura (12441, "RPA - Redes públicas de acceso", 4, 6 , 0, 0, 6);
        Asignatura RPTRAN = new Asignatura (12440, "RPTRAN - Redes públicas de transporte", 4, 4.5 , 0, 0, 7);
        Asignatura STGI = new Asignatura (12443, "STGI - Sistemas telemáticos para la gestión de la información", 4, 6 , 0, 0, 6);
        Asignatura IST = new Asignatura (12445, "IST - Ingeniería de sistemas telemáticos", 4, 4.5 , 0, 0, 7);
        Asignatura ATELEM = new Asignatura (12444, "ATELEM - Aplicaciones telemáticas", 4, 4.5 , 0, 0, 8);
        Asignatura SMULTI = new Asignatura (12442, "SMULTI - Sistemas multimedia", 4, 4.5 , 0, 0, 8);
        Asignatura COMDAT = new Asignatura (12447, "COMDAT - Comunicación de datos", 4, 6 , 0, 0, 5);
        Asignatura SEGURI = new Asignatura (12446, "SEGURI - Seguridad", 4, 6 , 0, 0, 7);
        Asignatura TFG = new Asignatura (12483, "TFG - Trabajo de fin de grado", 0, 12 , 0, 0, 8);


    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public static void guardar (){
        Usuario usuarioGuardar = MainActivity.getAppUser();
        try {
            FileOutputStream fileOut = new FileOutputStream("APPtelemUsuario");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(usuarioGuardar);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
