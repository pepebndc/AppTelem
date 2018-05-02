package es.upv.pepelauraeloy.apptelem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Iterator;

public class OfertaAsignaturas extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private Bundle savedBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        savedBundle = savedInstanceState;
        setContentView(R.layout.activity_oferta_asignaturas);

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
                mostrar.add(a);
            }
        }
        adapter = new AsignaturaAdapter(mostrar);
        recycler.setAdapter(adapter);


    }

    @Override
    public void onResume() {
        super.onResume();

        setContentView(R.layout.activity_oferta_asignaturas);

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
                mostrar.add(a);
            }
        }
        adapter = new AsignaturaAdapter(mostrar);
        recycler.setAdapter(adapter);
    }
}
