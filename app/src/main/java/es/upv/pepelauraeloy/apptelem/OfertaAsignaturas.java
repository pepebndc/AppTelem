package es.upv.pepelauraeloy.apptelem;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Iterator;

public class OfertaAsignaturas extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private Bundle savedBundle;

    private Button boton_todas;
    private Button boton_troncal;
    private Button boton_sistemas;
    private Button boton_electronica;
    private Button boton_sonido;
    private Button boton_telematica;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        display();
    }

    @Override
    public void onResume() {
        super.onResume();
        display();
    }

    public void display (){

        setContentView(R.layout.activity_oferta_asignaturas);

        boton_todas = (Button) findViewById(R.id.asignaturas_boton_todas);
        boton_troncal = (Button) findViewById(R.id.asignaturas_boton_troncales);
        boton_sistemas = (Button) findViewById(R.id.asignaturas_boton_sistemas);
        boton_electronica = (Button) findViewById(R.id.asignaturas_boton_electronica);
        boton_sonido = (Button) findViewById(R.id.asignaturas_boton_sonido);
        boton_telematica = (Button) findViewById(R.id.asignaturas_boton_telematica);



        //Filtros de búsqueda
        Button borrar = (Button) findViewById(R.id.oferta_borrar);
        Button buscar = (Button) findViewById(R.id.oferta_buscar);
        final EditText busqueda = (EditText) findViewById(R.id.oferta_texto);

        if(MainActivity.isBuscado()==false){
            MainActivity.filtro="";
        }

        String filtroLocal = MainActivity.filtro;
        busqueda.setText(filtroLocal);

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.filtro="";
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }
        });

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.filtro=busqueda.getText().toString();
                MainActivity.setBuscado(true);
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }
        });



        //cambio de color boton rama seleccionada
        switch (MainActivity.getControlRama()){

            case 0 : {
                boton_troncal.setBackgroundColor(Color.parseColor("#b3e5fc"));
                break;
            }
            case 1 : {
                boton_sistemas.setBackgroundColor(Color.parseColor("#b3e5fc"));
                break;
            }
            case 2 : {
                boton_electronica.setBackgroundColor(Color.parseColor("#b3e5fc"));
                break;
            }
            case 3 : {
                boton_sonido.setBackgroundColor(Color.parseColor("#b3e5fc"));
                break;
            }
            case 4 : {
                boton_telematica.setBackgroundColor(Color.parseColor("#b3e5fc"));
                break;
            }
            case 5 : {
                boton_todas.setBackgroundColor(Color.parseColor("#b3e5fc"));
                break;
            }


        }

        boton_todas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity.setControlRama(5);
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }
        });

        boton_telematica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity.setControlRama(4);
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }
        });

        boton_sonido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity.setControlRama(3);
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }
        });

        boton_electronica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity.setControlRama(2);
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }
        });

        boton_sistemas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity.setControlRama(1);
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }
        });

        boton_troncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity.setControlRama(0);
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }
        });

        //obtener recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        //Usar administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        //Pasar el arrayList que queremos mostrar

        ArrayList<Asignatura> mostrar = new ArrayList<Asignatura>();
        Iterator<Asignatura> it = MainActivity.getAppUser().getAsignaturas().iterator();
        while (it.hasNext()) {
            Asignatura a = it.next();



            //filtrado
            if(a.getNombre().toLowerCase().contains(filtroLocal.toLowerCase())) {

                //mostrar sólo troncal
                if (MainActivity.getControlRama() == 0) {
                    if (a.getRama() == 0) {
                        mostrar.add(a);
                    }
                }

                //mostrar sólo rama 1
                if (MainActivity.getControlRama() == 1) {
                    if (a.getRama() == 1) {
                        mostrar.add(a);
                    }
                }

                //mostrar sólo rama 2
                if (MainActivity.getControlRama() == 2) {
                    if (a.getRama() == 2) {
                        mostrar.add(a);
                    }
                }

                //mostrar sólo rama 3
                if (MainActivity.getControlRama() == 3) {
                    if (a.getRama() == 3) {
                        mostrar.add(a);
                    }
                }

                //mostrar sólo rama 4
                if (MainActivity.getControlRama() == 4) {
                    if (a.getRama() == 4) {
                        mostrar.add(a);
                    }
                }

                //mostrar todas
                if (MainActivity.getControlRama() == 5) {
                    if (a.getRama() != 5) {
                        mostrar.add(a);
                    }
                }
            }
        }
        adapter = new AsignaturaAdapter(mostrar);
        recycler.setAdapter(adapter);
    }

}
