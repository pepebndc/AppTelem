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

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getAppUser().setCreditosExtra(Double.parseDouble(extraCreditos.getText().toString()));
                MainActivity.getAppUser().setCreditosPracticas(Double.parseDouble(practicasCreditos.getText().toString()));
                MainActivity.getAppUser().setNotaPracticas(Double.parseDouble(practicasNota.getText().toString()));

                Usuario.guardar();
                finish();

            }
        });

    }
}
