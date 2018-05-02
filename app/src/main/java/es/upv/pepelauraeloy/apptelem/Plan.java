package es.upv.pepelauraeloy.apptelem;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

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

    private TextView creditosTroncal;
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
        botonTFG =(Button) findViewById(R.id.plan_tfg_Boton);

        percentajeTotal = (TextView) findViewById(R.id.plan_percentaje_total);
        percentajeTroncal = (TextView) findViewById(R.id.plan_percentaje_troncal);
        percentajeEspecialidad = (TextView) findViewById(R.id.plan_porcentaje_especialidad);
        percentajeOptativo = (TextView) findViewById(R.id.plan_percentaje_optativo);

        creditosTroncal = (TextView) findViewById(R.id.plan_creditos_troncal);
        creditosEspecialidad = (TextView) findViewById(R.id.plan_creditos_especialidad);
        creditosOptativos = (TextView) findViewById(R.id.plan_creditos_optativos_total);
        creditosOptativosAsignatura = (TextView) findViewById(R.id.plan_creditos_optativos_asignatura);
        creditosOptativosEmpresa = (TextView) findViewById(R.id.plan_creditos_optativos_empresa);
        creditosOptativosExtra = (TextView) findViewById(R.id.plan_creditos_optativos_extra);

        estadoTFG = (TextView) findViewById(R.id.plan_tfg_Estado);

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

    public TextView getCreditosTroncal() {
        return creditosTroncal;
    }

    public void setCreditosTroncal(TextView creditosTroncal) {
        this.creditosTroncal = creditosTroncal;
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
