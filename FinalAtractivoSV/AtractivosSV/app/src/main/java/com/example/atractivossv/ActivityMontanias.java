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

public class ActivityMontanias extends AppCompatActivity {
    // Agregamos un listview y creamos una list.
    ListView ListViewMontanias;
    List<Montanias> mst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_montanias);

        //vinculacion entre los objetos y el modo grafico mediente ID
        ListViewMontanias=findViewById(R.id.ListViewMontania);
        // Creamos un customAdapter
        CustomAdapterMontanias adapterMontanias=new CustomAdapterMontanias(this,GetData());
        ListViewMontanias.setAdapter(adapterMontanias);
        // Creamos una opción de selección
        ListViewMontanias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Creamos una variable para obtener una entidad del listado.
                Montanias q= mst.get(position);
                Toast.makeText(getBaseContext(), q.nombremontania, Toast.LENGTH_SHORT).show();

                String nlu =q.nombremontania;  //Nombre lugar
                String tabla="montanias";  //Nombre tabla
                //Implementacion del metodo Info
                info(nlu,tabla);
            }
        });
    }

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
    private List<Montanias> GetData() {
        mst=new ArrayList<>();
        mst.add(new Montanias(1,R.mipmap.img_mon_el_pital,"El Pital","Chalatenango"));
        mst.add(new Montanias(2,R.mipmap.img_mon_montecristo,"Montecristo","Santa Ana"));
        mst.add(new Montanias(3,R.mipmap.img_mon_el_boqueron,"El Boquerón","San Salvador"));
        mst.add(new Montanias(4,R.mipmap.img_mon_parque_nacional_los_volcanes,"Parque Nacional Los Volcanes","Santa Ana y Sonsonate"));
        mst.add(new Montanias(5,R.mipmap.img_mon_el_cerro_borronoso,"El Cerro Borroñoso","Morazán"));
        mst.add(new Montanias(6,R.mipmap.img_mon_el_cerro_san_jacinto,"El cerro San Jacinto","San Salvador"));
        mst.add(new Montanias(7,R.mipmap.img_mon_cerro_verde,"El Cerro Verde o Cuntetepeque","Santa Ana"));
        return mst;

    }

}