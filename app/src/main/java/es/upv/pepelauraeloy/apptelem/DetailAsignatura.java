package es.upv.pepelauraeloy.apptelem;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Iterator;

public class DetailAsignatura extends AppCompatActivity {

    TextView nombre;
    TextView semestre;
    TextView creditos;
    TextView rama;
    EditText nota;
    Switch cursada;
    Switch interesado;
    Button botonGuardar;

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
        nota = (EditText) findViewById(R.id.detail_nota);
        cursada = (Switch) findViewById(R.id.detail_cursada);
        interesado = (Switch) findViewById(R.id.detail_proxima_asignatura);
        botonGuardar = (Button) findViewById(R.id.detail_guardar);


        nombre.setText(getIntent().getExtras().getString("curNombre"));
        semestre.setText("Semestre: "+ getIntent().getExtras().getString("curSemestre"));
        creditos.setText("Créditos: "+ getIntent().getExtras().getString("curCreditos"));

        int intRama = getIntent().getExtras().getInt("curRama");
        switch (intRama){
            case 0: rama.setText("Rama: Troncal"); break;
            case 1: rama.setText("Rama: Sistemas de Telecomunicación");break;
            case 2: rama.setText("Rama: Sistemas Electrónicos");break;
            case 3: rama.setText("Rama: Sonido e Imagen");break;
            case 4: rama.setText("Rama: Telemática");break;
        }

        float notaf = getIntent().getExtras().getFloat("curNota");
        nota.setHint("Introduce tu nota");

        if(notaf !=0){
            nota.setText(Float.toString(notaf));
        }


        switch (getIntent().getExtras().getInt("curEstado")){
            case 0:{

                cursada.setChecked(false);
                interesado.setChecked(false);
                break;
            }
            case 1:{

                cursada.setChecked(false);
                interesado.setChecked(true);
                break;
            }
            case 2:{

                cursada.setChecked(true);
                interesado.setChecked(true);
                break;
            }
        }

        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int IDasignatura = getIntent().getExtras().getInt("curID");

                //save the data (Estado, nota)

                int saveEstado =0;
                if(interesado.isChecked()){
                    saveEstado = 1;
                }
                if(cursada.isChecked()){
                    saveEstado = 2;
                }

                float saveNota = 0;

                if(!nota.getText().toString().equals("")){
                    saveNota = Float.parseFloat(nota.getText().toString());
                }

                if(saveNota >10){
                    saveNota = 10;
                }


                //Iterator para buscar la asignatura que es
                Iterator <Asignatura> it = MainActivity.getAppUser().getAsignaturas().iterator();
                while (it.hasNext()){
                    Asignatura a = it.next();
                    if(a.getID() == IDasignatura){
                        a.setEstado(saveEstado);
                        a.setCalificacion(saveNota);
                    }
                }

                Usuario.guardar();
                finish();
            }
        });

    }








}
