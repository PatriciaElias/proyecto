package com.example.atractivossv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapterLagos extends BaseAdapter {
    // Creacion de variables y una lista con los valores de lagos que se creo.
    Context context;
    List<Lagos> lst;
    // Creacion del constructor.
    public CustomAdapterLagos(Context context, List<Lagos> lst) {
        this.context = context;
        this.lst = lst;
    }
    // Adecuamos los metodos.
    @Override
    public int getCount() {
        return lst.size();
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
        ImageView ImageViewLagos;
        TextView TextViewNombreLago;
        TextView TextViewDepartamentoLago;
        // Creamos una variable , para obtener de la lista una entidad para poder llenar los datos en el listview.
        Lagos l = lst.get(position);
        // Creacion de un if.
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.listviewlagos, null);
        // Asignamos sus id correspondientes.
        ImageViewLagos = convertView.findViewById(R.id.imageViewLagos);
        TextViewNombreLago = convertView.findViewById(R.id.textViewNombreLago);
        TextViewDepartamentoLago = convertView.findViewById(R.id.textViewDepartamentoLago);
        // Agregamos los datos que contendran los elementos.
        ImageViewLagos.setImageResource(l.imagenlago);
        TextViewNombreLago.setText(l.nombrelago);
        TextViewDepartamentoLago.setText(l.departamentolago);
        // retornamos
        return convertView;
    }
}
