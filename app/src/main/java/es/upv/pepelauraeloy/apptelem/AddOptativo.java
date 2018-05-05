package es.upv.pepelauraeloy.apptelem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddOptativo extends AppCompatActivity {

    Button guardar;
    EditText practicasCreditos;
    EditText practicasNota;
    EditText extraCreditos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_optativo);

        guardar = (Button) findViewById(R.id.optativo_guardar);
        practicasCreditos = (EditText) findViewById(R.id.optativo_practicas_creditos);
        practicasNota = (EditText) findViewById(R.id.optativo_practicas_nota);
        extraCreditos = (EditText) findViewById(R.id.optativo_actividades);

        practicasNota.setText(Double.toString(MainActivity.getAppUser().getNotaPracticas()));
        practicasCreditos.setText(Double.toString(MainActivity.getAppUser().getCreditosPracticas()));
        extraCreditos.setText(Double.toString(MainActivity.getAppUser().getCreditosExtra()));

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double saveCreditosExtra = Double.parseDouble(extraCreditos.getText().toString());
                if(saveCreditosExtra > 6){{
                    saveCreditosExtra=6;
                }}

                double saveCreditosPracticas = Double.parseDouble(practicasCreditos.getText().toString());
                if(saveCreditosPracticas>18){
                    saveCreditosPracticas=18;
                }

                double saveNotaPracticas = Double.parseDouble(practicasNota.getText().toString());
                if(saveNotaPracticas>10){
                    saveNotaPracticas=10;
                }

                MainActivity.getAppUser().setCreditosExtra(saveCreditosExtra);
                MainActivity.getAppUser().setCreditosPracticas(saveCreditosPracticas);
                MainActivity.getAppUser().setNotaPracticas(saveNotaPracticas);

                Usuario.guardar();
                finish();

            }
        });

    }
}
