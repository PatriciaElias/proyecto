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

public class ActivityCatedrales extends AppCompatActivity {
    // Agregamos un listview y creamos una list.
    ListView ListViewCatedrales;
    List<Catedrales> cst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catedrales);

        //vinculacion entre los objetos y el modo grafico mediente ID
        ListViewCatedrales=findViewById(R.id.ListViewCatedrales);
        // Creamos un customAdapter
        CustomAdapterCatedrales adapterCatedrales =new CustomAdapterCatedrales(this,GetData());
        ListViewCatedrales.setAdapter(adapterCatedrales);
        // creamos una opción de selección
        ListViewCatedrales.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Creamos una variable para obtener una entidad del listado.
                Catedrales c= cst.get(position);
                Toast.makeText(getBaseContext(), c.nombrecatedral, Toast.LENGTH_SHORT).show();

                String nlu =c.nombrecatedral;  //Nombre lugar
                String tabla="catedrales";     //Nombre tabla
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
    private List<Catedrales> GetData() {
        cst=new ArrayList<>();
        cst.add(new Catedrales(1,R.mipmap.img_cate_el_rosario,"Iglesia El Rosario","San Salvador"));
        cst.add(new Catedrales(2,R.mipmap.img_cate_ssa_santa_ana,"Catedral de Santa Ana","Santa Ana"));
        cst.add(new Catedrales(3,R.mipmap.img_cate_catedral_ss,"Catedral Metropolitana de San Salvador","San Salvador"));
        cst.add(new Catedrales(4,R.mipmap.img_cate_la_merced,"La Parroquia Nuestra Señora de la Merced"," San Salvador"));
        cst.add(new Catedrales(5,R.mipmap.img_cate_reina_san_miguel,"Catedral basílica Reina de la Paz","San Miguel"));
        return cst;
    }

}