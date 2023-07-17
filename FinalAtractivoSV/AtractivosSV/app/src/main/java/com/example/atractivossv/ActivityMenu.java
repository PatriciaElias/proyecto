package com.example.atractivossv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ActivityMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }


    //boton agregar lugar
    public void agregandodatos(View view){
        //Cambio de pantalla(ACTIVITY)
        Intent accederagregandodatos = new Intent(this, Activity_newLugar.class);
        //Ejecucion de cambio de pantalla
        startActivity(accederagregandodatos);
    }

    //METODO BOTON RETROCEDER
    public void retroceder(View view){
        //Cambio de pantalla(ACTIVITY)
        Intent retroceder=new Intent(this, MainActivity.class);
        //Ejecucion de cambio de pantalla
        startActivity(retroceder);
    }

    //METODO ACCESOR A SUB-PANTALLAS
    public void accederLugar(View view)
    {
        //switch encargado de redireccionar a la siguiente pantalla al usuario dependiendo del tipo de lugar seleccionado
        //Mensaje al usuario que le indica a cual lugar accedio
        switch(view.getId())
        {
            case R.id.imb_playa:
                Intent accedePlaya=new Intent(this, ActivityPlayas.class);
                startActivity(accedePlaya);
                Toast.makeText(this, "Accedio a playas", Toast.LENGTH_SHORT).show();
                break;

            case R.id.imb_lago:
                Intent accedeLago=new Intent(this, ActivityLagos.class);
                startActivity(accedeLago);
                Toast.makeText(this, "Accedio a lagos", Toast.LENGTH_SHORT).show();
                break;

            case R.id.imb_balneario:
                Intent accedeBalneario=new Intent(this, ActivityBalnearios.class);
                startActivity(accedeBalneario);
                Toast.makeText(this, "Accedio a balnearios", Toast.LENGTH_SHORT).show();
                break;

            case R.id.imb_catedral:
                Intent accedeCatedral=new Intent(this, ActivityCatedrales.class);
                startActivity(accedeCatedral);
                Toast.makeText(this, "Accedio a catedrales", Toast.LENGTH_SHORT).show();
                break;

            case R.id.imb_ruta:
                Intent accedeRutas=new Intent(this, ActivityRutas.class);
                startActivity(accedeRutas);
                Toast.makeText(this, "Accedio a rutas", Toast.LENGTH_SHORT).show();
                break;

            case R.id.imb_arqueologico:
                Intent accedeArqueologico=new Intent(this, ActivityArqueologico.class);
                startActivity(accedeArqueologico);
                Toast.makeText(this, "Accedio a sitios arqueologicos", Toast.LENGTH_SHORT).show();
                break;

            case R.id.imb_volcan:
                Intent accedeVolcan=new Intent(this, ActivityVolcanes.class);
                startActivity(accedeVolcan);
                Toast.makeText(this, "Accedio a volcanes", Toast.LENGTH_SHORT).show();
                break;

            case R.id.imb_montania:
                Intent accederMontania=new Intent(this, ActivityMontanias.class);
                startActivity(accederMontania);
                Toast.makeText(this, "Accedio a montañas", Toast.LENGTH_SHORT).show();
                break;

            case R.id.imb_mirador:
                Intent accederMirador=new Intent(this, ActivityMiradores.class);
                startActivity(accederMirador);
                Toast.makeText(this, "Accedio a miradores", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}