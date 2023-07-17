package com.example.atractivossv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Activity_newLugar extends AppCompatActivity {

    //Variable global auxiliar
    //(Valor asignar NOMBRE DE LA TABLA)
    String lugar="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_lugar);
    }

    //METODO BOTON AGREGAR LUGAR
    public void agregarLugar(View view)
    {
        //switch que ejecuta la accion dependiendo de la imagen seleccionada
        switch(view.getId())
        {
            case R.id.img_agregar_playa:
                //Mensaje al usuario
                Toast.makeText(this, "Registrar nueva playa", Toast.LENGTH_SHORT).show();
                //Asignacion del nombre de la tabla
                lugar="playas";
                break;

            case R.id.img_agregar_lago:
                //Mensaje al usuario
                Toast.makeText(this, "Registrar nuevo lago", Toast.LENGTH_SHORT).show();
                //Asignacion del nombre de la tabla
                lugar="lagos";
                break;

            case R.id.img_agregar_balneario:
                //Mensaje al usuario
                Toast.makeText(this, "Registrar nuevo balneario", Toast.LENGTH_SHORT).show();
                //Asignacion del nombre de la tabla
                lugar="balnearios";
                break;

            case R.id.imb_agregar_catedral:
                //Mensaje al usuario
                Toast.makeText(this, "Registrar nueva catedral", Toast.LENGTH_SHORT).show();
                //Asignacion del nombre de la tabla
                lugar="catedrales";
                break;

            case R.id.img_agregar_ruta:
                //Mensaje al usuario
                Toast.makeText(this, "Registrar nueva ruta", Toast.LENGTH_SHORT).show();
                //Asignacion del nombre de la tabla
                lugar="rutas";
                break;

            case R.id.img_agregar_arqueologico:
                //Mensaje al usuario
                Toast.makeText(this, "Registrar nuevo sitio arqueologico", Toast.LENGTH_SHORT).show();
                //Asignacion del nombre de la tabla
                lugar="sitios_arqueologicos";
                break;

            case R.id.img_agregar_volcan:
                //Mensaje al usuario
                Toast.makeText(this, "Registrar nuevo volcan", Toast.LENGTH_SHORT).show();
                //Asignacion del nombre de la tabla
                lugar="volcanes";
                break;

            case R.id.img_agregar_montania:
                //Mensaje al usuario
                Toast.makeText(this, "Registrar nueva montaña", Toast.LENGTH_SHORT).show();
                //Asignacion del nombre de la tabla
                lugar="montanias";
                break;

            case R.id.img_agregar_mirador :
                //Mensaje al usuario
                Toast.makeText(this, "Registrar nuevo mirador", Toast.LENGTH_SHORT).show();
                //Asignacion del nombre de la tabla
                lugar="miradores";
                break;
        }
        //Cambio de pantalla(ACTIVITY)
        Intent newLugar=new Intent(this, Activity_newLugarForm.class);
        //Envio de informacion del nombre de la tabla
        newLugar.putExtra("lugarT",lugar);
        //Ejecucion de cambio de pantalla
        startActivity(newLugar);
    }
}