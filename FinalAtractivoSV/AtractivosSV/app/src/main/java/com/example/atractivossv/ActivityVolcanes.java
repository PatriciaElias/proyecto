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

public class ActivityVolcanes extends AppCompatActivity {
    // Agregamos un listview y creamos una list.
    ListView ListViewVolcanes;
    List<Volcanes> vst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volcanes);

        //vinculacion entre los objetos y el modo grafico mediente ID
        ListViewVolcanes=findViewById(R.id.ListViewVolcan);
        // Creamos un customAdapter
        CustomAdapterVolcanes adapterVolcanes=new CustomAdapterVolcanes(this,GetData());
        ListViewVolcanes.setAdapter(adapterVolcanes);
        // creamos una opción de selección
        ListViewVolcanes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Creamos una variable para obtener una entidad del listado.
                Volcanes v= vst.get(position);
                Toast.makeText(getBaseContext(), v.nombrevolcan, Toast.LENGTH_SHORT).show();
                String nlu =v.nombrevolcan;  //Nombre lugar
                String tabla="volcanes";  //Nombre tabla
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
    private List<Volcanes> GetData() {
        vst=new ArrayList<>();
        vst.add(new Volcanes(1,R.mipmap.img_volcan_de_santa_ana,"Volcán de Santa Ana","Santa Ana"));
        vst.add(new Volcanes(2,R.mipmap.img_volcan_de_izalco,"Volcán de Izalco","Sonsonate"));
        vst.add(new Volcanes(3,R.mipmap.img_volcan_de_san_salvador,"Volcán de San Salvador","San Salvador"));
        vst.add(new Volcanes(4,R.mipmap.img_volcan_de_san_miguel,"Volcán de San Miguel","San Miguel"));
        vst.add(new Volcanes(5,R.mipmap.img_volcan_de_san_vicente,"Volcán de San Vicente","San Vicente"));
        vst.add(new Volcanes(6,R.mipmap.img_volcan_conchagua,"Volcán de Conchagua","La Unión"));
        vst.add(new Volcanes(7,R.mipmap.img_volcan_de_tecapa,"Volcán Tecapa","Usulután"));
        return vst;

    }

}