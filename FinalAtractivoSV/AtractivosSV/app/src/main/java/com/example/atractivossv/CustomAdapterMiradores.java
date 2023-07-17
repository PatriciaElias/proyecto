package com.example.atractivossv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapterMiradores extends BaseAdapter {
    // Creacion de variables y una lista con los valores de miradores que se creo.
    Context context;
    List<Miradores> mrs;
    // Creacion del constructor.
    public CustomAdapterMiradores(Context context, List<Miradores> mrs) {
        this.context = context;
        this.mrs = mrs;
    }
    // Adecuamos los metodos.
    @Override
    public int getCount() {
        return mrs.size();
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
        ImageView ImageViewMiradores;
        TextView TextViewNombreMiradores;
        TextView TextViewDepartamentoMiradores;
        // Creamos una variable , para obtener de la lista una entidad para poder llenar los datos en el listview.
        Miradores mr = mrs.get(position);
        // Creacion de un if.
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.listviewmiradores, null);
        // Asignamos sus id correspondientes.
        ImageViewMiradores = convertView.findViewById(R.id.imageViewMiradores);
        TextViewNombreMiradores = convertView.findViewById(R.id.textViewNombreMiradores);
        TextViewDepartamentoMiradores = convertView.findViewById(R.id.textViewDepartamentoMiradores);
        // Agregamos los datos que contendran los elementos.
        ImageViewMiradores.setImageResource(mr.imagenmirador);
        TextViewNombreMiradores.setText(mr.nombremirador);
        TextViewDepartamentoMiradores.setText(mr.departamentomirador);
        // retornamos
        return convertView;
    }
}
