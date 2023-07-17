package com.example.atractivossv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapterCatedrales extends BaseAdapter {
    // Creacion de variables y una lista con los valores de catedrales que se creo.
    Context context;
    List<Catedrales> cst;
    // Creacion del constructor.
    public CustomAdapterCatedrales(Context context, List<Catedrales> cst) {
        this.context = context;
        this.cst = cst;
    }
    // Adecuamos los metodos.
    @Override
    public int getCount() {
        return cst.size();
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
        ImageView ImageViewCatedrales;
        TextView TextViewNombreCatedral;
        TextView TextViewDepartamentoCatedral;
        // Creamos una variable , para obtener de la lista una entidad para poder llenar los datos en el listview.
        Catedrales c = cst.get(position);
        // Creacion de un if.
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.listviewcatedrales, null);
        // Asignamos sus id correspondientes.
        ImageViewCatedrales = convertView.findViewById(R.id.imageViewCatedrales);
        TextViewNombreCatedral = convertView.findViewById(R.id.textViewNombreCatedral);
        TextViewDepartamentoCatedral = convertView.findViewById(R.id.textViewDepartamentoCatedral);
        // Agregamos los datos que contendran los elementos.
        ImageViewCatedrales.setImageResource(c.imagencatedral);
        TextViewNombreCatedral.setText(c.nombrecatedral);
        TextViewDepartamentoCatedral.setText(c.departamentocatedral);
        // retornamos
        return convertView;
    }
}
