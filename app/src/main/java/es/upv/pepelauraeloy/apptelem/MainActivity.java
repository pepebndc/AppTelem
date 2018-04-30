package es.upv.pepelauraeloy.apptelem;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MainActivity extends AppCompatActivity {

    private Button boton1;
    private Button boton2;
    private  static Usuario appUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //COMPROBAR SI EXISTE EL OBJETO DEL USUARIO, O CREARLO
        File file = new File("APPtelemUsuario");

        // si existe, loadear el usuario
        if(file.exists()) {
            try {
                FileInputStream fis = openFileInput("APPtelemUsuario");
                ObjectInputStream ois = new ObjectInputStream(fis);
                appUser = (Usuario) ois.readObject();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        //Do something
        else{
            //si no existe, crear un usuario nuevo y guardarlo
            appUser = new Usuario ();
            Usuario.guardar();
        }
        // Do something else.


        boton1 = (Button) findViewById(R.id.boton1);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEstadisticas();
            }
        });

        boton2 = (Button) findViewById(R.id.boton2);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAsignaturas();
            }
        });


    }

    public void openEstadisticas(){
        Intent intent = new Intent(this, Estadisticas.class);
        startActivity(intent);
    }

    public void openAsignaturas(){
        Intent intent = new Intent(this, OfertaAsignaturas.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public static Usuario getAppUser() {
        return appUser;
    }

    public static void setAppUser(Usuario appUser1) {
        appUser = appUser1;
    }
}
