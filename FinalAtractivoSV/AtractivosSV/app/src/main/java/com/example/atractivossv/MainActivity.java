package com.example.atractivossv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Creacion de variables globales auxiliares
    private EditText et_mail;
    private EditText et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //vinculacion entre los objetos y el modo grafico mediente ID
        et_mail=(EditText)findViewById(R.id.txt_Email);
        et_password=(EditText)findViewById(R.id.txt_password);
    }

    //METODO BOTON ACCEDER
    public void acceder(View view)
    {
        ///Objeto de la clase de la BD
        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"BDAtractivos",null,1);
        //Abrir lectura en modo lectura y escritura
        SQLiteDatabase BaseDeDatos= admin.getWritableDatabase();

        //asignacion de los datos recuperados de los campos de textos a variables
        String mail=et_mail.getText().toString();
        String contra=et_password.getText().toString();

        //VALIDACION PARA QUE LOS CAMPOS REQUERIDOS NO ESTEN VACIOS
        if(!mail.equals("") && !contra.equals(""))
        {
            //VALIDACION DE INICIO DE SECION CON CREDENCIALES DEL USUARIO
            Cursor fila=BaseDeDatos.rawQuery("select nombre from usuario where correo= '"+mail+"' and contrasenia='"+contra+"'",null);
            //Acciones a realizar si se necuentra una coincidencia o no
            if(fila.moveToFirst())
            {
                //Cambio de pantalla(ACTIVITY)
                Intent siguiente = new Intent(this, ActivityMenu.class);
                //Ejecucion de cambio de pantalla
                startActivity(siguiente);
                //Mensaje al usuario
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_LONG).show();
                //Cerrar conexion a la base de dados
                BaseDeDatos.close();
            }else{
                //Mensaje al usuario
                Toast.makeText(this, "Datos del usuario no encontrados", Toast.LENGTH_LONG).show();
                //Cerrar conexion a la base de dados
                BaseDeDatos.close();
            }

        }else{
            //Mensaje al usuario
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_LONG).show();
        }
    }

    //METODO BOTON REGISTRAR
    public void Registrar(View view)
    {
        //Retroceder pantalla
        Intent ingresar = new Intent(this, ActivityRegistrar.class);
        //Ejecutar cambio de pantalla
        startActivity(ingresar);
    }


}