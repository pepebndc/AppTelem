package es.upv.pepelauraeloy.apptelem;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Iterator;

public class Plan extends AppCompatActivity {

    private ProgressBar progressTotal;
    private ProgressBar progressTroncal;
    private ProgressBar progressEspecialidad;
    private ProgressBar progressOptativo;

    private Button botonTFG;
    private Button botonAddOptativo;

    private TextView percentajeTotal;
    private TextView percentajeTroncal;
    private TextView percentajeEspecialidad;
    private TextView percentajeOptativo;

    private TextView creditosTroncalText;
    private TextView creditosEspecialidad;
    private TextView creditosOptativos;
    private TextView creditosOptativosAsignatura;
    private TextView creditosOptativosExtra;
    private TextView creditosOptativosEmpresa;

    private TextView estadoTFG;
    private TextView textoEspecialidad;
    private TextView nombreTFG;
    Asignatura aTFG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ejecutar();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ejecutar();
    }

    public void ejecutar(){
        setContentView(R.layout.activity_plan);

        //Identificar los objetos con ID
        progressTotal = (ProgressBar) findViewById(R.id.plan_progress_total);
        progressTroncal = (ProgressBar) findViewById(R.id.plan_progress_troncal);
        progressEspecialidad = (ProgressBar) findViewById(R.id.plan_progress_especialidad);
        progressOptativo = (ProgressBar) findViewById(R.id.plan_progress_optativo);

        botonAddOptativo = (Button) findViewById(R.id.plan_boton_addCreditos);
        botonTFG = (Button) findViewById(R.id.plan_tfg_Boton);

        percentajeTotal = (TextView) findViewById(R.id.plan_percentaje_total);
        percentajeTroncal = (TextView) findViewById(R.id.plan_percentaje_troncal);
        percentajeEspecialidad = (TextView) findViewById(R.id.plan_porcentaje_especialidad);
        percentajeOptativo = (TextView) findViewById(R.id.plan_percentaje_optativo);

        creditosTroncalText = (TextView) findViewById(R.id.plan_creditos_troncal);
        creditosEspecialidad = (TextView) findViewById(R.id.plan_creditos_especialidad);
        creditosOptativos = (TextView) findViewById(R.id.plan_creditos_optativos_total);
        creditosOptativosAsignatura = (TextView) findViewById(R.id.plan_creditos_optativos_asignatura);
        creditosOptativosEmpresa = (TextView) findViewById(R.id.plan_creditos_optativos_empresa);
        creditosOptativosExtra = (TextView) findViewById(R.id.plan_creditos_optativos_extra);

        estadoTFG = (TextView) findViewById(R.id.plan_tfg_Estado);
        nombreTFG = (TextView) findViewById(R.id.plan_tfg_nombre);
        textoEspecialidad = (TextView) findViewById(R.id.plan_nombre_especialidad);



        //Hacer cosas



        //Cálculo de creditos superados

        double creditosTotal=0;
        double creditosTroncal=0;
        double creditosSistemas=0;
        double creditosElectronica=0;
        double creditosTelematica=0;
        double creditosSonido=0;

        double creditosTotalsuperados=0;
        double creditosTroncalsuperados=0;
        double creditosSistemassuperados=0;
        double creditosElectronicasuperados=0;
        double creditosTelematicasuperados=0;
        double creditosSonidosuperados=0;

        Iterator<Asignatura> it = MainActivity.getAppUser().getAsignaturas().iterator();
        while (it.hasNext()) {
            Asignatura a = it.next();

            if (a.getNombre().contains("Trabajo de fin de grado")){
                aTFG = a;
            }
            if (a.getRama() == 0) {
                creditosTroncal = creditosTroncal + a.getCreditos();
                if(a.getEstado()==3){
                    creditosTroncalsuperados = creditosTroncalsuperados + a.getCreditos();
                }
            }

            if (a.getRama() == 1) {
                creditosSistemas = creditosSistemas + a.getCreditos();
                if(a.getEstado()==3){
                    creditosSistemassuperados = creditosSistemassuperados + a.getCreditos();
                }
            }

            if (a.getRama() == 2) {
                creditosElectronica = creditosElectronica + a.getCreditos();
                if(a.getEstado()==3){
                    creditosElectronicasuperados = creditosElectronicasuperados + a.getCreditos();
                }
            }

            if (a.getRama() == 3) {
                creditosSonido = creditosSonido + a.getCreditos();
                if(a.getEstado()==3){
                    creditosSonidosuperados = creditosSonidosuperados + a.getCreditos();
                }
            }

            if (a.getRama() == 4) {
                creditosTelematica = creditosTelematica + a.getCreditos();
                if(a.getEstado()==3){
                    creditosTelematicasuperados = creditosTelematicasuperados + a.getCreditos();
                }
            }

            if (a.getRama() == 5) {
                creditosTotal = creditosTotal + a.getCreditos();
                if(a.getEstado()==3){
                    creditosTotalsuperados = creditosTotalsuperados + a.getCreditos();
                }
            }

        }

        //Gestión de créditos

        //Creditos troncales
        double ratioTroncal = 100 * creditosTroncalsuperados/creditosTroncal;
        progressTroncal.setProgress((int)ratioTroncal);
        percentajeTroncal.setText(String.valueOf((int)ratioTroncal) + "%");
        creditosTroncalText.setText("Créditos : "+Double.toString(creditosTroncalsuperados)+"/"+creditosTroncal);

        //Créditos de especialidad

        double [] ramasCreditos = new double [4];
        ramasCreditos[0] = creditosSistemassuperados;
        ramasCreditos[1] = creditosElectronicasuperados;
        ramasCreditos[2] = creditosSonidosuperados;
        ramasCreditos[3] = creditosTelematicasuperados;

        double max =0;
        int RamaEspecialidad = -1;

        for ( int i=0; i<ramasCreditos.length; i++){
            if(ramasCreditos[i]>max){
                RamaEspecialidad = i;
                max = ramasCreditos[i];
            }
        }

        double Cespecialidad=0;


        if(RamaEspecialidad==-1){
            textoEspecialidad.setText("Especialidad : -Sin definir-");
            creditosEspecialidad.setText("Créditos: 0.0/ 58.5");
            progressEspecialidad.setProgress(0);
            percentajeEspecialidad.setText("0%");
            Cespecialidad = 0;
        }
        if(RamaEspecialidad==0){
            textoEspecialidad.setText("Especialidad : Sistemas de Telecomunicaciones");
            creditosEspecialidad.setText("Créditos: "+creditosSistemassuperados+"/ 58.5");
            progressEspecialidad.setProgress((int)(100*creditosSistemassuperados/58.5));
            percentajeEspecialidad.setText((int)(100*creditosSistemassuperados/58.5)+"%");
            Cespecialidad =creditosSistemassuperados;
        }
        if(RamaEspecialidad ==1){
            textoEspecialidad.setText("Especialidad : Electrónica");
            creditosEspecialidad.setText("Créditos: "+creditosElectronicasuperados+"/ 58.5");
            progressEspecialidad.setProgress((int)(100*creditosElectronicasuperados/58.5));
            percentajeEspecialidad.setText((int)(100*creditosElectronicasuperados/58.5)+"%");
            Cespecialidad = creditosElectronicasuperados;

        }
        if(RamaEspecialidad==2){
            textoEspecialidad.setText("Especialidad : Sonido e Imagen");
            creditosEspecialidad.setText("Créditos: "+creditosSonidosuperados+"/ 58.5");
            progressEspecialidad.setProgress((int)(100*creditosSonidosuperados/58.5));
            percentajeEspecialidad.setText((int)(100*creditosSonidosuperados/58.5)+"%");
            Cespecialidad = creditosSonidosuperados;
        }
        if(RamaEspecialidad==3){
            textoEspecialidad.setText("Especialidad : Telemática");
            creditosEspecialidad.setText("Créditos: "+creditosTelematicasuperados+"/ 58.5");
            progressEspecialidad.setProgress((int)(100*creditosTelematicasuperados/58.5));
            percentajeEspecialidad.setText((int)(100*creditosTelematicasuperados/58.5)+"%");
            Cespecialidad = creditosTelematicasuperados;
        }




        //Créditos optativos


        //asignaturas optativas (no son de rama)
        double Casignatura = 0;
        if(RamaEspecialidad==-1){
            creditosOptativosAsignatura.setText("0.0 Créditos");
        }
        if(RamaEspecialidad!= 0){
            Casignatura = Casignatura + creditosSistemassuperados;
        }
        if(RamaEspecialidad!= 1){
            Casignatura = Casignatura + creditosElectronicasuperados;
        }
        if(RamaEspecialidad!= 2){
            Casignatura = Casignatura + creditosSonidosuperados;
        }
        if(RamaEspecialidad!= 3){
            Casignatura = Casignatura + creditosTelematicasuperados;
        }

        creditosOptativosAsignatura.setText(Casignatura + " Créditos");


        //Créditos Extracurriculares
        double Copt = MainActivity.getAppUser().getCreditosExtra();
        if(Copt>6){
            Copt = 6;
        }
        creditosOptativosExtra.setText(Copt + " Créditos");


        //Créditos Prácticas en empresa
        double Cemp = MainActivity.getAppUser().getCreditosPracticas();
        if(Copt>18){
            Copt = 18;
        }
        creditosOptativosEmpresa.setText(Cemp + " Créditos");

        //Creditos totales optativos
        double Ctot = Casignatura + Cemp + Copt;
        int Cratio = (int) (100*Ctot/24);
        double CtotControl = Ctot;

        if(Cratio>100){
            Cratio = 100;
            CtotControl = 24;
        }

        creditosOptativos.setText("Créditos: "+ CtotControl + "/24.0");
        progressOptativo.setProgress(Cratio);
        percentajeOptativo.setText(Cratio + "%");


        //Créditos totales

        creditosTotalsuperados = CtotControl + creditosTroncalsuperados + Cespecialidad;
        if(aTFG.getEstado()==3){
            creditosTotalsuperados = creditosTotalsuperados + aTFG.getCreditos();
        }
        System.out.println("Total superados: " + creditosTotalsuperados);
        double ratioTotal = 100 * creditosTotalsuperados / 240.0;


        System.out.println("Ratio: " + ratioTotal);
        progressTotal.setProgress((int)ratioTotal);
        percentajeTotal.setText(String.valueOf((int)ratioTotal)+ "%");


        if(creditosTotalsuperados<228){
            nombreTFG.setText("Trabajo de Fin de Grado: (necesario tener el resto de créditos superados)");
            botonTFG.setEnabled(false);
        }

        //Estado del TFG

        if(aTFG.getEstado()==0 || aTFG.getEstado()==1 ){
            estadoTFG.setText("PENDIENTE");
            estadoTFG.setTextColor(Color.parseColor("#2196F3"));
        }
        if(aTFG.getEstado()==3 ){
            estadoTFG.setText("¡¡APROBADO!!");
            estadoTFG.setTextColor(Color.parseColor("#4caf50"));
        }
        if(aTFG.getEstado()==2 ){
            estadoTFG.setText("SUSPENDIDO");
            estadoTFG.setTextColor(Color.parseColor("#f44336"));
        }


        botonTFG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString ("curNombre", aTFG.getNombre());
                bundle.putString ("curSemestre", ""+aTFG.getSemestre());
                bundle.putString ("curCreditos", ""+ aTFG.getCreditos());
                bundle.putInt ("curRama", aTFG.getRama());
                bundle.putInt ("curEstado", aTFG.getEstado());
                System.out.println("EStado: "+aTFG.getEstado());
                bundle.putFloat("curNota", aTFG.getCalificacion());
                bundle.putInt("curID", aTFG.getID());

                Intent iconIntent = new Intent(v.getContext(), DetailAsignatura.class);
                iconIntent.putExtras(bundle);
                v.getContext().startActivity(iconIntent);

            }
        });

        botonAddOptativo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(v.getContext(), AddOptativo.class);
                v.getContext().startActivity(newIntent);

            }
        });
    }

    public ProgressBar getProgressTotal() {
        return progressTotal;
    }

    public void setProgressTotal(ProgressBar progressTotal) {
        this.progressTotal = progressTotal;
    }

    public ProgressBar getProgressTroncal() {
        return progressTroncal;
    }

    public void setProgressTroncal(ProgressBar progressTroncal) {
        this.progressTroncal = progressTroncal;
    }

    public ProgressBar getProgressEspecialidad() {
        return progressEspecialidad;
    }

    public void setProgressEspecialidad(ProgressBar progressEspecialidad) {
        this.progressEspecialidad = progressEspecialidad;
    }

    public ProgressBar getProgressOptativo() {
        return progressOptativo;
    }

    public void setProgressOptativo(ProgressBar progressOptativo) {
        this.progressOptativo = progressOptativo;
    }

    public Button getBotonTFG() {
        return botonTFG;
    }

    public void setBotonTFG(Button botonTFG) {
        this.botonTFG = botonTFG;
    }

    public Button getBotonAddOptativo() {
        return botonAddOptativo;
    }

    public void setBotonAddOptativo(Button botonAddOptativo) {
        this.botonAddOptativo = botonAddOptativo;
    }

    public TextView getPercentajeTotal() {
        return percentajeTotal;
    }

    public void setPercentajeTotal(TextView percentajeTotal) {
        this.percentajeTotal = percentajeTotal;
    }

    public TextView getPercentajeTroncal() {
        return percentajeTroncal;
    }

    public void setPercentajeTroncal(TextView percentajeTroncal) {
        this.percentajeTroncal = percentajeTroncal;
    }

    public TextView getPercentajeEspecialidad() {
        return percentajeEspecialidad;
    }

    public void setPercentajeEspecialidad(TextView percentajeEspecialidad) {
        percentajeEspecialidad = percentajeEspecialidad;
    }

    public TextView getPercentajeOptativo() {
        return percentajeOptativo;
    }

    public void setPercentajeOptativo(TextView percentajeOptativo) {
        this.percentajeOptativo = percentajeOptativo;
    }

    public TextView getCreditosTroncalText() {
        return creditosTroncalText;
    }

    public void setCreditosTroncalText(TextView creditosTroncal) {
        this.creditosTroncalText = creditosTroncal;
    }

    public TextView getCreditosEspecialidad() {
        return creditosEspecialidad;
    }

    public void setCreditosEspecialidad(TextView creditosEspecialidad) {
        this.creditosEspecialidad = creditosEspecialidad;
    }

    public TextView getCreditosOptativos() {
        return creditosOptativos;
    }

    public void setCreditosOptativos(TextView creditosOptativos) {
        this.creditosOptativos = creditosOptativos;
    }

    public TextView getCreditosOptativosAsignatura() {
        return creditosOptativosAsignatura;
    }

    public void setCreditosOptativosAsignatura(TextView creditosOptativosAsignatura) {
        this.creditosOptativosAsignatura = creditosOptativosAsignatura;
    }

    public TextView getCreditosOptativosExtra() {
        return creditosOptativosExtra;
    }

    public void setCreditosOptativosExtra(TextView creditosOptativosExtra) {
        this.creditosOptativosExtra = creditosOptativosExtra;
    }

    public TextView getCreditosOptativosEmpresa() {
        return creditosOptativosEmpresa;
    }

    public void setCreditosOptativosEmpresa(TextView creditosOptativosEmpresa) {
        this.creditosOptativosEmpresa = creditosOptativosEmpresa;
    }

    public TextView getEstadoTFG() {
        return estadoTFG;
    }

    public void setEstadoTFG(TextView estadoTFG) {
        this.estadoTFG = estadoTFG;
    }
}
