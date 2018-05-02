package es.upv.pepelauraeloy.apptelem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

            if (a.getRama() == 0) {
                creditosTroncal = creditosTroncal + a.getCreditos();
                if(a.getEstado()==2 && a.getCalificacion()>=5){
                    creditosTroncalsuperados = creditosTroncalsuperados + a.getCreditos();
                }
            }

            if (a.getRama() == 1) {
                creditosSistemas = creditosSistemas + a.getCreditos();
                if(a.getEstado()==2 && a.getCalificacion()>=5){
                    creditosSistemassuperados = creditosSistemassuperados + a.getCreditos();
                }
            }

            if (a.getRama() == 2) {
                creditosElectronica = creditosElectronica + a.getCreditos();
                if(a.getEstado()==2 && a.getCalificacion()>=5){
                    creditosElectronicasuperados = creditosElectronicasuperados + a.getCreditos();
                }
            }

            if (a.getRama() == 3) {
                creditosSonido = creditosSonido + a.getCreditos();
                if(a.getEstado()==2 && a.getCalificacion()>=5){
                    creditosSonidosuperados = creditosSonidosuperados + a.getCreditos();
                }
            }

            if (a.getRama() == 4) {
                creditosTelematica = creditosTelematica + a.getCreditos();
                if(a.getEstado()==2 && a.getCalificacion()>=5){
                    creditosTelematicasuperados = creditosTelematicasuperados + a.getCreditos();
                }
            }

            if (a.getRama() == 5) {
                creditosTotal = creditosTotal + a.getCreditos();
                if(a.getEstado()==2 && a.getCalificacion()>=5){
                    creditosTotalsuperados = creditosTotalsuperados + a.getCreditos();
                }
            }

        }

        //Gestión de créditos

        //Créditos totales

        creditosTotal = creditosTotal + creditosElectronica + creditosSistemas + creditosSonido + creditosTelematica + creditosTroncal;
        creditosTotalsuperados = creditosTotalsuperados + creditosTelematicasuperados + creditosSonidosuperados + creditosElectronicasuperados + creditosSistemassuperados + creditosTroncalsuperados;
        System.out.println("Total superados: " + creditosTotalsuperados);
        double ratioTotal = 100 * creditosTotalsuperados / 240.0;
        System.out.println("Ratio: " + ratioTotal);
        progressTotal.setProgress((int)ratioTotal);
        percentajeTotal.setText(Double.toString(ratioTotal).substring(0,1)+ "%");


        //Creditos troncales
        double ratioTroncal = 100 * creditosTroncalsuperados/creditosTroncal;
        progressTroncal.setProgress((int)ratioTroncal);
        percentajeTroncal.setText(Double.toString(ratioTroncal).substring(0,1) + "%");
        creditosTroncalText.setText("Créditos : "+Double.toString(creditosTroncalsuperados)+"/"+creditosTroncal);





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
