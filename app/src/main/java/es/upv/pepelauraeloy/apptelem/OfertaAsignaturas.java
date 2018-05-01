package es.upv.pepelauraeloy.apptelem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

        adapter = new AsignaturaAdapter(MainActivity.getAppUser().getAsignaturas());
        recycler.setAdapter(adapter);


    }

    @Override
    public void onResume(){
        super.onResume();

        setContentView(R.layout.activity_oferta_asignaturas);

        //obtener recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        //Usar administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        adapter = new AsignaturaAdapter(MainActivity.getAppUser().getAsignaturas());
        recycler.setAdapter(adapter);
    }
}
