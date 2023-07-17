package com.example.atractivossv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_informacionLugar extends AppCompatActivity {

    //Creacion de objetos a utilizar
    private TextView tv_nombre;
    private TextView tv_municipio;
    private TextView tv_departamento;
    private TextView tv_descripcion;
    private ImageView iv_lugar;

    //CREAR VARIABLES AUXILIARES GLOBALES
    String nameLugar="";
    String nameTabla="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_lugar);

        //vinculacion entre los objetos y el modo grafico mediente ID
        tv_nombre=(TextView) findViewById(R.id.tv_nombreL);
        tv_municipio=(TextView) findViewById(R.id.tv_municipioL);
        tv_departamento=(TextView) findViewById(R.id.tv_departamentoL);
        tv_descripcion=(TextView) findViewById(R.id.tv_descripcionL);
        iv_lugar=(ImageView)findViewById(R.id.iv_fotoLugar);

        //RECIBIR INFO DE ACTIVITY DE ORIGEN
        nameLugar=getIntent().getStringExtra("datoL");
        nameTabla=getIntent().getStringExtra("datoT");

        //Mostar nombre el txt
        tv_nombre.setText(nameLugar);

        //Objeto de la clase de la BD
        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"BDAtractivos",null,1);
        //Abrir lectura en modo lectura y escritura
        SQLiteDatabase BaseDeDatos= admin.getWritableDatabase();

        //Consultar sobre le lugar desedo
        Cursor fila=BaseDeDatos.rawQuery("select * from '"+ nameTabla +"' where nombre= '"+nameLugar+"'",null);
        //Acciones a realizar si los datos se encuentran o no
        if(fila.moveToFirst())
        {
            //MOSTRAR LOS DATOS OBTENIDOS EN LAS CAJAS DE TEXTO
            tv_nombre.setText(fila.getString(1));
            tv_municipio.setText(fila.getString(2));
            tv_departamento.setText(fila.getString(3));
            tv_descripcion.setText(fila.getString(4));
            //et_descripcion.setText(fila.getString(4));
            BaseDeDatos.close();
        }else{
            //Cerrar conexion a la base de datos
            BaseDeDatos.close();
            //Mensaje al usuario
            Toast.makeText(this, "Dato no encontrado", Toast.LENGTH_SHORT).show();
        }
    }

}