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

public class ActivityMiradores extends AppCompatActivity {
    // Agregamos un listview y creamos una list.
    ListView ListViewMiradores;
    List<Miradores> mrs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miradores);

        //vinculacion entre los objetos y el modo grafico mediente ID
        ListViewMiradores=findViewById(R.id.ListViewMirador);
        // Creamos un customAdapter
        CustomAdapterMiradores adapterMiradores=new CustomAdapterMiradores(this,GetData());
        ListViewMiradores.setAdapter(adapterMiradores);
        // creamos una opción de selección
        ListViewMiradores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Creamos una variable para obtener una entidad del listado.
                Miradores m= mrs.get(position);
                Toast.makeText(getBaseContext(), m.nombremirador, Toast.LENGTH_SHORT).show();

                String nlu =m.nombremirador;  //Nombre lugar
                String tabla="miradores";  //Nombre tabla
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
    private List<Miradores> GetData() {
        mrs=new ArrayList<>();
        mrs.add(new Miradores(1,R.mipmap.img_mirador_de_la_giralda,"Mirador de La Giralda","La Libertad"));
        mrs.add(new Miradores(2,R.mipmap.img_mirador_los_planes_de_renderos,"Mirador de los Planes de Renderos","San Salvador"));
        mrs.add(new Miradores(3,R.mipmap.img_mirador_de_las_cien_gradas,"Mirador de las Cien Gradas","Usulután"));
        mrs.add(new Miradores(4,R.mipmap.img_mirador_paradise,"Mirador Paradise","Usulután"));
        mrs.add(new Miradores(5,R.mipmap.img_mirador_el_espiritu_de_la_montana,"Mirador El Espíritu de la Montaña","La Unión"));
        mrs.add(new Miradores(6,R.mipmap.img_mirador_puerta_del_diablo,"La puerta del Diablo","San Salvador"));
        return mrs;

    }
}