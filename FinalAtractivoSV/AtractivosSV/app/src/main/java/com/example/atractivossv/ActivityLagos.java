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

public class ActivityLagos extends AppCompatActivity {

    ListView ListViewLagos;
    List<Lagos> lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lagos);

        //vinculacion entre los objetos y el modo grafico mediente ID
        ListViewLagos=findViewById(R.id.ListViewLago);

        CustomAdapterLagos adapterLagos =new CustomAdapterLagos(this,GetData());
        ListViewLagos.setAdapter(adapterLagos);

        ListViewLagos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Lagos l= lst.get(position);
                Toast.makeText(getBaseContext(), l.nombrelago, Toast.LENGTH_SHORT).show();

                String nlu =l.nombrelago;  //Nombre lugar
                String tabla="lagos";     //Nombre tabla
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

    private List<Lagos> GetData() {
        lst=new ArrayList<>();
        lst.add(new Lagos(1,R.mipmap.img_laguna_de_bijaguuuu,"Laguna El Bijahua","Ahuachapán"));
        lst.add(new Lagos(2,R.mipmap.img_lago_de_ilopango,"El lago de Ilopango","San Salvador"));
        lst.add(new Lagos(3,R.mipmap.img_lago_coatepeque,"El lago Coatepeque","Santa Ana"));
        lst.add(new Lagos(4,R.mipmap.img_lago_de_ouija,"El lago de Güija","Santa Ana"));
        lst.add(new Lagos(5,R.mipmap.img_laguna_de_apastepeque,"Laguna de Apastepeque","San Vicente"));
        lst.add(new Lagos(6,R.mipmap.img_laguna_de_alegria_usulutan,"Laguna de Alegría","Usulután"));
        lst.add(new Lagos(7,R.mipmap.img_laguna_de_metapan,"La Laguna de Metapán","Santa Ana"));
        lst.add(new Lagos(8,R.mipmap.img_laguna_ciega,"Laguna Ciega","San Vicente"));
        lst.add(new Lagos(9,R.mipmap.img_laguna_la_bruja,"Laguna La Bruja","San Vicente"));
        lst.add(new Lagos(10,R.mipmap.img_laguna_chanmico,"Laguna de Chanmico","La Libertad"));
        lst.add(new Lagos(11,R.mipmap.img_laguna_verde_apaneca,"Laguna Verde","Ahuachapán y Sonsonate"));
        lst.add(new Lagos(12,R.mipmap.img_laguna_el_jocotal,"La Laguna El Jocotal","San Miguel"));
        lst.add(new Lagos(13,R.mipmap.img_laguna_aramuaca,"Laguna de Aramuaca","San Miguel"));
        return lst;
    }

}