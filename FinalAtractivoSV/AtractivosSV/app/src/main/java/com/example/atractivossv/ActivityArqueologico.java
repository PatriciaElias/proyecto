package com.example.atractivossv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityArqueologico extends AppCompatActivity {
    // Agregamos un listview y creamos una list.
    ListView ListViewArqueologico;
    List<Arqueologico> ast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arqueologico);

        //vinculacion entre los objetos y el modo grafico mediente ID
        ListViewArqueologico=findViewById(R.id.ListViewArqueologico);
        // Creamos un customAdapter
        CustomAdapterArqueologico adapterArqueologico =new CustomAdapterArqueologico(this,GetData());
        ListViewArqueologico.setAdapter(adapterArqueologico);
        // creamos una opción de selección
        ListViewArqueologico.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Creamos una variable para obtener una entidad del listado.
                Arqueologico a= ast.get(position);
                Toast.makeText(getBaseContext(), a.nombrearqueologico, Toast.LENGTH_SHORT).show();

                String nlu =a.nombrearqueologico;       //Nombre lugar
                String tabla="sitios_arqueologicos";    //Nombre tabla
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
    private List<Arqueologico> GetData() {
        ast=new ArrayList<>();
        ast.add(new Arqueologico(1,R.mipmap.img_arque_joya_ceren,"Joya de Cerén","La Libertad"));
        ast.add(new Arqueologico(2,R.mipmap.img_arque_casa_blanca,"Casa Blanca","Santa Ana"));
        ast.add(new Arqueologico(3,R.mipmap.img_arque_san_andres,"San Andrés","La Libertad"));
        ast.add(new Arqueologico(4,R.mipmap.img_arque_tazumal,"Ruinas del Tazumal","Santa Ana"));
        ast.add(new Arqueologico(5,R.mipmap.img_arque_cihuatan,"Cihuatan","San Salvador"));
        ast.add(new Arqueologico(6,R.mipmap.img_arque_ciudad_vieja,"Ciudad Vieja","Morazán"));
        ast.add(new Arqueologico(7,R.mipmap.img_arque_santa_leticia,"Santa Leticia","Ahuachapán"));

        return ast;
    }
}