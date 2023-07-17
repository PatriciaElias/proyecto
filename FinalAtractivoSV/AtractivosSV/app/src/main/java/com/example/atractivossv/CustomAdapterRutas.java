package com.example.atractivossv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapterRutas extends BaseAdapter {
    // Creacion de variables y una lista con los valores de rutas que se creo.
    Context context;
    List<Rutas> rst;
    // Creacion del constructor.
    public CustomAdapterRutas(Context context, List<Rutas> rst) {
        this.context = context;
        this.rst = rst;
    }
    // Adecuamos los metodos.
    @Override
    public int getCount() {
        return rst.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // Asignaremos la parte del interfaz es decir los elementos del listview correspondiente.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView ImageViewRutas;
        TextView TextViewNombreRuta;
        TextView TextViewDepartamentoRuta;
        // Creamos una variable , para obtener de la lista una entidad para poder llenar los datos en el listview.
        Rutas r = rst.get(position);
        // Creacion de un if.
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.listviewrutas, null);
        // Asignamos sus id correspondientes.
        ImageViewRutas = convertView.findViewById(R.id.imageViewRutas);
        TextViewNombreRuta = convertView.findViewById(R.id.textViewNombreRuta);
        TextViewDepartamentoRuta = convertView.findViewById(R.id.textViewDepartamentoRuta);
        // Agregamos los datos que contendran los elementos.
        ImageViewRutas.setImageResource(r.imagenruta);
        TextViewNombreRuta.setText(r.nombreruta);
        TextViewDepartamentoRuta.setText(r.departamentoruta);
        // retornamos
        return convertView;
    }
}
