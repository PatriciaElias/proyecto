package com.example.atractivossv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_newLugarForm extends AppCompatActivity {
    //Creacion de objetos a utilizar
    private TextView tv_titulo;
    private EditText et_name;
    private EditText et_municipio;
    private EditText et_departamento;
    private EditText et_descripcion;
    private ImageView iv_imagen;

    //CREAR VARIABLES AUXILIARES GLOBALES
    String tipoLugar="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_lugar_form);

        //vinculacion entre los objetos y el modo grafico mediente ID
        tv_titulo=(TextView) findViewById(R.id.tv_titulo);
        et_name=(EditText)findViewById(R.id.txt_name);
        et_municipio=(EditText)findViewById(R.id.txt_municipio);
        et_departamento=(EditText)findViewById(R.id.txt_departamento);
        et_descripcion=(EditText)findViewById(R.id.txt_descripcion);
        iv_imagen=(ImageView)findViewById(R.id.iv_imagen);

        //RECIBIR INFO DE ACTIVITY DE ORIGEN
        tipoLugar=getIntent().getStringExtra("lugarT");

        //switch que cambia la imagen del encabezado dependiendo el tipo de lugar a recomendar
        //(Tipo de lugar (DATO ENVIADO DESDE EL ACTIVITY ANTERIOR))
        //Muestra mensaje dependiendo el lugar anteriormente seleccionado
        switch(tipoLugar)
        {
            case "playas":
                iv_imagen.setImageResource(R.drawable.playa);
                tv_titulo.setText(R.string.tv_nuevaPlaya);
                break;
            case "lagos":
                iv_imagen.setImageResource(R.drawable.lago);
                tv_titulo.setText(R.string.tv_nuevaLago);
                break;
            case "balnearios":
                iv_imagen.setImageResource(R.drawable.parque_acuatico);
                tv_titulo.setText(R.string.tv_nuevoBalneario);
                break;
            case "catedrales":
                iv_imagen.setImageResource(R.drawable.catedral);
                tv_titulo.setText(R.string.tv_nuevaCatedral);
                break;
            case "rutas":
                iv_imagen.setImageResource(R.drawable.ruta);
                tv_titulo.setText(R.string.tv_nuevaRuta);
                break;
            case "sitios_arqueologicos":
                iv_imagen.setImageResource(R.drawable.arqueologico);
                tv_titulo.setText(R.string.tv_nuevoArqueologico);
                break;
            case "volcanes":
                iv_imagen.setImageResource(R.drawable.volcan);
                tv_titulo.setText(R.string.tv_nuevaVolcan);
                break;
            case "montanias":
                iv_imagen.setImageResource(R.drawable.montania);
                tv_titulo.setText(R.string.tv_nuevaMontania);
                break;
            case "miradores":
                iv_imagen.setImageResource(R.drawable.mirador);
                tv_titulo.setText(R.string.tv_nuevoMirador);
                break;
        }
    }

    //METODO PARA EL BOTON GUARDAR
    public void Guardar(View view) {
        //Objeto de la clase de la BD
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BDAtractivos", null, 1);
        //Abrir lectura en modo lectura y escritura
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        //asignacion de los datos recuperados de los campos de textos a variables
        String nombre = et_name.getText().toString();
        String municipio = et_municipio.getText().toString();
        String departamento = et_departamento.getText().toString();
        String descripcion = et_descripcion.getText().toString();

        //VALIDACION PARA QUE LOS CAMPOS REQUERIDOS NO ESTEN VACIOS
        if (!nombre.isEmpty() && !municipio.isEmpty() && !departamento.isEmpty() && !descripcion.isEmpty()) {
            //VERIFICAR SI EL LUGAR A INGRESAR YA EXISTE
            Cursor fila = BaseDeDatos.rawQuery("select * from recomendaciones_lugar where nombre= '" + nombre + "'", null);
            //Acciones a realizar si se necuentra una coincidencia o no
            if (fila.moveToFirst()) {
                Toast.makeText(this, "El lugar ya se encuentra sugerido", Toast.LENGTH_LONG).show();
                //Cerrar conexion a la base de datos
                BaseDeDatos.close();
            } else {
                //INSERCION DE DATOS
                ContentValues registro = new ContentValues();
                registro.put("tipoLugar", tipoLugar);
                registro.put("nombre", nombre);
                registro.put("municipio", municipio);
                registro.put("departamento", departamento);
                registro.put("descripcion", descripcion);

                BaseDeDatos.insert("recomendaciones_lugar", null, registro);
                //Cerrar conexion a la base de datos
                BaseDeDatos.close();

                //Limpiando las cajas de texto
                et_name.setText("");
                et_municipio.setText("");
                et_departamento.setText("");
                et_descripcion.setText("");

                //Mensaje al usuario
                Toast.makeText(this, "Lugar sugerido con EXITO", Toast.LENGTH_LONG).show();
            }
        } else {
            //Mensaje al usuario
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_LONG).show();
        }
    }
}