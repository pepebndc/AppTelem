package es.upv.pepelauraeloy.apptelem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Iterator;

public class Estadisticas extends AppCompatActivity {

    TextView UI_Mtot;
    TextView UI_M12;
    TextView UI_M34;
    TextView UI_M56;
    TextView UI_M78;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        UI_Mtot = (TextView) findViewById(R.id.estadisticas_mediaTotal);
        UI_M12 = (TextView) findViewById(R.id.estadisticas_S12);
        UI_M34 = (TextView) findViewById(R.id.estadisticas_S34);
        UI_M56 = (TextView) findViewById(R.id.estadisticas_S56);
        UI_M78 = (TextView) findViewById(R.id.estadisticas_S78);


        //Recogida de todos los datos

        // C-> Créditos ; N -> nota+créditos ; M-> media ponderada

        double Ctot=0;
        double C12=0;
        double C34=0;
        double C56=0;
        double C78=0;

        double Ntot=0;
        double N12=0;
        double N34=0;
        double N56=0;
        double N78=0;

        double Mtot=0;
        double M12=0;
        double M34=0;
        double M56=0;
        double M78=0;

        double Ntfg=0;
        double Ctfg = 0;
        boolean tfg=false;


        Iterator<Asignatura> it = MainActivity.getAppUser().getAsignaturas().iterator();
        while (it.hasNext()) {
            Asignatura a = it.next();

            if(a.getEstado()==2 || a.getEstado()==3) {

                System.out.println("Asignatura a analizar: "+a.getNombre() +" Semestre: " + a.getSemestre() + " nota: "+ a.getCalificacion() + " creditos: "+a.getCreditos());

                if (a.getSemestre() == 1 || a.getSemestre() == 2) {
                    N12 = N12 + (a.getCalificacion() * a.getCreditos());
                    C12 = C12 + a.getCreditos();
                }

                if (a.getSemestre() == 3 || a.getSemestre() == 4) {
                    N34 = N34 + (a.getCalificacion() * a.getCreditos());
                    C34 = C34 + a.getCreditos();
                }

                if (a.getSemestre() == 5 || a.getSemestre() == 6) {
                    N56 = N56 + (a.getCalificacion() * a.getCreditos());
                    C56 = C56 + a.getCreditos();
                }

                if (a.getSemestre() == 7 || a.getSemestre() == 8) {
                    N78 = N78 + (a.getCalificacion() * a.getCreditos());
                    C78 = C78 + a.getCreditos();
                }
                if(a.getNombre().contains("Trabajo de fin de grado")){
                    tfg=true;
                    Ntfg=a.getCalificacion()*12;
                    Ctfg = 12;
                }
            }
        }


        //prácticas
        double Npract = MainActivity.getAppUser().getCreditosPracticas()*MainActivity.getAppUser().getNotaPracticas();
        double Cpract = MainActivity.getAppUser().getCreditosPracticas();

        //Cálculo de nota media de cada periodo
        if(tfg){
            Ntot = N12 + N34 + N56 + N78 + Ntfg + Npract;
            Ctot = C12 + C34 + C56 + C78 + Ctfg + Cpract;
        }else{
            Ntot = N12 + N34 + N56 + N78 + Npract;
            Ctot = C12 + C34 + C56 + C78 + Cpract;
        }

        Mtot = Ntot / Ctot;
        M12 = N12 / C12;
        M34 = N34 / C34;
        M56 = N56 / C56;
        M78 = N78 / C78;

        System.out.println("Ctot= " +Ctot + "   Ntot = " + Ntot +  "   Mtot="+Mtot);
        System.out.println("C12 = " + C12 + "   N12= "+N12 + "   M12="+M12);
        System.out.println("C34 = " + C34 + "   N34= "+N34+ "   M34="+M34);
        System.out.println("C56 = " + C56 +    "N56= "+N56+ "   M56="+M56);
        System.out.println("C78 = " + C78 + "   N78= "+N78+ "   M78="+M78);

        UI_Mtot.setText(""+ Mtot);
        UI_M12.setText(""+ M12);
        UI_M34.setText(""+ M34);
        UI_M56.setText(""+ M56);
        UI_M78.setText(""+ M78);




    }
}
