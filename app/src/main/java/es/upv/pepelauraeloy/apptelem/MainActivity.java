package es.upv.pepelauraeloy.apptelem;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MainActivity extends AppCompatActivity {

    private Button boton_Estadisticas;
    private Button boton_Asignaturas;
    private Button boton_Plan;
    private Button nuevoUsuario;
    private static Usuario appUser;
    private static String PathToSave;
    private static int controlRama;

    public static String getPathToSave() {
        return PathToSave;
    }

    public static void setPathToSave(String pathToSave) {
        PathToSave = pathToSave;
    }

    public static int getControlRama() {
        return controlRama;
    }

    public static void setControlRama(int controlRama) {
        MainActivity.controlRama = controlRama;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //COMPROBAR SI EXISTE EL OBJETO DEL USUARIO, O CREARLO

        File file = new File(getApplicationContext().getFilesDir(), "APPtelemUser");
        PathToSave = file.getAbsolutePath().toString();

        // si existe, loadear el usuario
        if(file.exists()) {
            System.out.println("El usuario existe, cargando");
            Usuario newUser = null;
            FileInputStream inStream = null;
            try {
                inStream = new FileInputStream(file);
                ObjectInputStream objectInStream = new ObjectInputStream(inStream);
                newUser = ((Usuario) objectInStream.readObject());
                objectInStream.close();
                appUser = newUser;
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }




        }
        //Do something
        else{
            System.out.println("El usuario no existe, creando y guardando uno nuevo");
            //si no existe, crear un usuario nuevo y guardarlo
            appUser = new Usuario ();
            Usuario.guardar();
        }
        // Do something else.


        boton_Estadisticas = (Button) findViewById(R.id.main_boton_estadisticas);
        boton_Estadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEstadisticas();
            }
        });

        boton_Asignaturas = (Button) findViewById(R.id.main_boton_asignaturas);
        boton_Asignaturas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAsignaturas();
            }
        });

        boton_Plan = (Button) findViewById(R.id.main_boton_plan);
        boton_Plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlan();
            }
        });

        nuevoUsuario = (Button) findViewById(R.id.main_newUser);
        nuevoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDlg = new AlertDialog.Builder(MainActivity.this);
                alertDlg.setMessage("¿Seguro que quieres borrar el usuario?\n\nESTA ACCIÓN ES IRREVERSIBLE");
                alertDlg.setCancelable(false);

                alertDlg.setPositiveButton("Sí, ya no quiero mis notas", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Crear un usuario nuevo y guardarlo
                        appUser = new Usuario ();
                        Usuario.guardar();

                        Toast toast1 = Toast.makeText(getApplicationContext(), "Usuario borrado", Toast.LENGTH_SHORT);
                        toast1.show();
                    }
                });

                alertDlg.setNegativeButton("No, me he acojonado", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast1 = Toast.makeText(getApplicationContext(), "Ya decía yo...", Toast.LENGTH_SHORT);
                        toast1.show();
                    }
                });

                alertDlg.create().show();




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

    public void openPlan(){
        Intent intent = new Intent(this, Plan.class);
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

    public Button getNuevoUsuario() {
        return nuevoUsuario;
    }

    public void setNuevoUsuario(Button nuevoUsuario) {
        this.nuevoUsuario = nuevoUsuario;
    }
}
