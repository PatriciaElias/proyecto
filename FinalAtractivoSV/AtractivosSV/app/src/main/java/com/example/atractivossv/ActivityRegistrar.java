package com.example.atractivossv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityRegistrar extends AppCompatActivity {
    //Creacion de objetos a utilizar
    private EditText et_nombres;
    private EditText et_apellidos;
    private EditText et_correo;
    private EditText et_contrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        //vinculacion entre los objetos y el modo grafico mediente ID
        et_nombres=(EditText)findViewById(R.id.txt_Nombres);
        et_apellidos=(EditText)findViewById(R.id.txt_Apellidos);
        et_correo=(EditText)findViewById(R.id.txt_Correo);
        et_contrasenia=(EditText)findViewById(R.id.txt_Contra);
    }

    //METODO PARA EL BOTON GUARDAR
    public void Guardar(View view)
    {
        //Objeto de la clase de la BD
        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"BDAtractivos",null,1);
        //Abrir lectura en modo lectura y escritura
        SQLiteDatabase BaseDeDatos= admin.getWritableDatabase();

        //asignacion de los datos recuperados de los campos de textos a variables
        String nombre=et_nombres.getText().toString();
        String apellido=et_apellidos.getText().toString();
        String correo=et_correo.getText().toString();
        String contra=et_contrasenia.getText().toString();

        //VALIDACION PARA QUE LOS CAMPOS REQUERIDOS NO ESTEN VACIOS
        if(!nombre.equals("") && !apellido.equals("") && !correo.equals("") && !contra.equals(""))
        {
            //VERIFICAR SI EL CORREO A INGRESAR YA EXISTE
            Cursor fila=BaseDeDatos.rawQuery("select nombre from usuario where correo= '"+correo+"'",null);
            //Acciones a realizar de haber encontrado al usuario o no
            if(fila.moveToFirst())
            {
                //Mensaje al usuario
                Toast.makeText(this, "El correo ya se encuentra registrado", Toast.LENGTH_LONG).show();
                //Cerrado de conexion
                BaseDeDatos.close();
            }else{
                //INSERCION DE DATOS
                ContentValues registro=new ContentValues();
                registro.put("nombre",nombre);
                registro.put("apellido",apellido);
                registro.put("correo",correo);
                registro.put("contrasenia",contra);

                BaseDeDatos.insert("usuario",null,registro);
                //Cerrar conexion a la base de datos
                BaseDeDatos.close();

                //Limpiando las cajas de texto
                et_nombres.setText("");
                et_apellidos.setText("");
                et_correo.setText("");
                et_contrasenia.setText("");

                //Mensaje al usuario(ACCION CON EXITO)
                Toast.makeText(this, "Usuario ingresado con EXITO", Toast.LENGTH_LONG).show();

                //redirecciona al menu de los lugares
                Intent acceder=new Intent(this, MainActivity.class);
                //Ejecucion del cambio de pantalla
                startActivity(acceder);
                //Cerrar conexion a la base de datos
                BaseDeDatos.close();
            }
        }
        else{
            //Mensaje al usuario
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_LONG).show();
        }
    }

    //METODO BOTON RETROCEDER
    public void retroceder(View view){
        //Cambio de pantalla(RETROCEDER AL ACTIVITY ANTERIOR)
        Intent retroceder=new Intent(this, MainActivity.class);
        //Ejecucion del cambio de pantalla
        startActivity(retroceder);
    }

}