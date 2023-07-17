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

public class ActivityPlayas extends AppCompatActivity {
    // Agregamos un listview y creamos una list.
    ListView ListViewPlayas;
    List<Playas> pst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playas);

        //vinculacion entre los objetos y el modo grafico mediente ID
        ListViewPlayas=findViewById(R.id.ListViewPlayas);
        // Creamos un customAdapter
        CustomAdapterPlaya adapterPlaya =new CustomAdapterPlaya(this,GetData());
        ListViewPlayas.setAdapter(adapterPlaya);
        // Creamos una opción de selección
        ListViewPlayas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Creamos una variable para obtener una entidad del listado.
                Playas p= pst.get(position);
                Toast.makeText(getBaseContext(), p.nombreplaya, Toast.LENGTH_SHORT).show();

                String nlu =p.nombreplaya;  //Nombre lugar
                String tabla="playas";  //Nombre tabla
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
    private List<Playas> GetData() {
        pst=new ArrayList<>();
        pst.add(new Playas(1,R.mipmap.img_playa_costa_del_sol,"Costa del Sol","La Paz"));
        pst.add(new Playas(2,R.mipmap.img_playa_barra_de_santiago,"Barra de Santiago","Ahuachapán"));
        pst.add(new Playas(3,R.mipmap.img_playa_las_flores,"Las Flores","San Miguel"));
        pst.add(new Playas(4,R.mipmap.img_playa_el_tunco,"El Tunco","La Libertad"));
        pst.add(new Playas(5,R.mipmap.img_playa_el_sunzal,"El Sunzal","La Libertad"));
        pst.add(new Playas(6,R.mipmap.img_playa_el_zonte,"El Zonte","La Libertad"));
        pst.add(new Playas(7,R.mipmap.img_playa_mizata,"Mizata","Sonsonate"));
        pst.add(new Playas(8,R.mipmap.img_playa_los_cobanos,"Los Cóbanos","Sonsonate"));
        pst.add(new Playas(9,R.mipmap.img_playa_punta_san_juan_del_gozo,"Península de San Juan del Gozo","Usulután"));
        pst.add(new Playas(10,R.mipmap.img_playa_golfo_de_fonseca,"Golfo de Fonseca","La Unión"));
        return pst;
    }

}