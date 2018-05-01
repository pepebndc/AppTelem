package es.upv.pepelauraeloy.apptelem;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DetailAsignatura extends AppCompatActivity {

    TextView nombre;
    TextView semestre;
    TextView creditos;
    TextView rama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_asignatura);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre = (TextView) findViewById(R.id.detail_asignatura_Nombre);
        semestre = (TextView) findViewById(R.id.detail_asignatura_Semestre);
        creditos = (TextView) findViewById(R.id.detail_asignatura_Creditos);
        rama = (TextView) findViewById(R.id.detail_asignatura_Rama);

        nombre.setText(getIntent().getExtras().getString("curNombre"));
        semestre.setText("Semestre: "+ getIntent().getExtras().getString("curSemestre"));
        creditos.setText("Créditos: "+ getIntent().getExtras().getString("curCreditos"));
        rama.setText(("Rama: "+ getIntent().getExtras().getInt("curRama")));
    }


}
