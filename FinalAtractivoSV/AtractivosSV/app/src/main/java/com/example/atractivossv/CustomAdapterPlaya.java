package com.example.atractivossv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapterPlaya extends BaseAdapter {
    // Creacion de variables y una lista con los valores de playas que se creo.
    Context context;
    List<Playas> pst;
    // Creacion del constructor.
    public CustomAdapterPlaya(Context context, List<Playas> pst) {
        this.context = context;
        this.pst = pst;
    }
    // Adecuamos los metodos.
    @Override
    public int getCount() {
        return pst.size();
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
        ImageView ImageViewPlayas;
        TextView TextViewNombrePlaya;
        TextView TextViewDepartamentoPlaya;
        // Creamos una variable , para obtener de la lista una entidad para poder llenar los datos en el listview.
        Playas p = pst.get(position);
        // Creacion de un if.
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.listviewplayas, null);
        // Asignamos sus id correspondientes.
        ImageViewPlayas = convertView.findViewById(R.id.imageViewPlayas);
        TextViewNombrePlaya = convertView.findViewById(R.id.textViewNombrePlaya);
        TextViewDepartamentoPlaya = convertView.findViewById(R.id.textViewDepartamentoPlaya);
        // Agregamos los datos que contendran los elementos.
        ImageViewPlayas.setImageResource(p.imagenplaya);
        TextViewNombrePlaya.setText(p.nombreplaya);
        TextViewDepartamentoPlaya.setText(p.departamentoplaya);
        // retornamos
        return convertView;
    }
}
