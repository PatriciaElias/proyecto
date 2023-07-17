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

public class ActivityRutas extends AppCompatActivity {
    // Agregamos un listview y creamos una list.
    ListView ListViewRutas;
    List<Rutas> rst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutas);

        //vinculacion entre los objetos y el modo grafico mediente ID
        ListViewRutas=findViewById(R.id.ListViewRutas);
        // Creamos un customAdapter
        CustomAdapterRutas adapterRutas =new CustomAdapterRutas(this,GetData());
        ListViewRutas.setAdapter(adapterRutas);
        // creamos una opción de selección
        ListViewRutas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Creamos una variable para obtener una entidad del listado.
                Rutas r= rst.get(position);
                Toast.makeText(getBaseContext(), r.nombreruta, Toast.LENGTH_SHORT).show();

                String nlu =r.nombreruta;  //Nombre lugar
                String tabla="rutas";     //Nombre tabla
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
    private List<Rutas> GetData() {
        rst=new ArrayList<>();
        rst.add(new Rutas(1,R.mipmap.img_ruta_azul,"Ruta Azul","San Salvador"));
        rst.add(new Rutas(2,R.mipmap.img_ruta_arqueologica,"Ruta Arqueologica","Santa Ana"));
        rst.add(new Rutas(3,R.mipmap.img_ruta_del_paraiso_artesanal,"Ruta del Paraiso Artesanal","varios"));
        rst.add(new Rutas(4,R.mipmap.img_ruta_las_flores,"Ruta de las Flores","Varios"));
        rst.add(new Rutas(5,R.mipmap.img_ruta_de_la_paz,"Ruta de la Paz","Morazán"));
        rst.add(new Rutas(6,R.mipmap.img_ruta_mil_cumbres,"Ruta las Mil Cumbres","Usulután"));
        rst.add(new Rutas(7,R.mipmap.img_ruta_fresca,"Ruta Fresca","Varios"));
        rst.add(new Rutas(8,R.mipmap.img_ruta_de_monsenor_romero,"Ruta Monseñor Romero","Varios"));
        rst.add(new Rutas(9,R.mipmap.img_ruta_corredor_acuatico,"Corredor Arqueológico Subacuático","Sonsonate"));
        return rst;
    }

}