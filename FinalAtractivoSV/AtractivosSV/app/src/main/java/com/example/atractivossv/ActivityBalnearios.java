package com.example.atractivossv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityBalnearios extends AppCompatActivity {
    // Agregamos un listview y creamos una list.
    ListView ListViewBalnearios;
    List<Balnearios> bst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balnearios);

        //vinculacion entre los objetos y el modo grafico mediente ID
        ListViewBalnearios=findViewById(R.id.ListViewBalnearios);
        // Creamos un customAdapter
        CustomAdapterBalneario adapterBalneario =new CustomAdapterBalneario(this,GetData());
        ListViewBalnearios.setAdapter(adapterBalneario);
        // creamos una opción de selección
        ListViewBalnearios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Creamos una variable para obtener una entidad del listado.
                Balnearios b= bst.get(position);
                Toast.makeText(getBaseContext(), b.nombrebalneario, Toast.LENGTH_SHORT).show();

                String nlu =b.nombrebalneario;  //Nombre lugar
                String tabla="balnearios";      //Nombre tabla

                //Implementacion del metodo Info
                info(nlu,tabla);
            }
        });
    }

    //METODO QUE ENVIA INFORMACION AL ACTIVITY SECUNDARIO
    public void info(String lugar, String tabla)
    {
        //Cambio de pantalla(ACTIVITY)
        Intent mostrarInfo=new Intent(this, Activity_informacionLugar.class);
        //Envio de informacion al siguiente Activity(PANTALLA)
        mostrarInfo.putExtra("datoL",lugar);    //Dato del lugar a ver
        mostrarInfo.putExtra("datoT",tabla);    //Dato de la tabla al que pertenece
        //Ejecucion de cambio de pantalla
        startActivity(mostrarInfo);
    }
    // Generamos los datos del listado.
    private List<Balnearios> GetData() {
        bst=new ArrayList<>();
        bst.add(new Balnearios(1,R.mipmap.img_balneario_termos,"Termos del río parque acuático","Carretera Santa Ana"));
        bst.add(new Balnearios(2,R.mipmap.img_balneario_agape,"Parque acuático Agape","Sonsonate"));
        bst.add(new Balnearios(3,R.mipmap.img_balneario_ichanmichen,"Ichanmichen, Parque acuatico","San Salvador"));
        bst.add(new Balnearios(4,R.mipmap.img_balneario_la_toma,"La Toma de Quezaltepeque","La Libertad"));
        bst.add(new Balnearios(5,R.mipmap.img_balneario_apulo,"Turicentro Apulo","San Salvador"));
        bst.add(new Balnearios(6,R.mipmap.img_balneario_apuzunga,"Amapulapa","San Salvador"));
        bst.add(new Balnearios(7,R.mipmap.img_balneario_santa_teresa,"Termales de Santa Teresa","Ahuachapán"));
        return bst;

    }

}