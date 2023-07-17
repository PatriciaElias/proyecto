package com.example.atractivossv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapterArqueologico extends BaseAdapter {
    // Creacion de variables y una lista con los valores de arqueologicos que se creo.
    Context context;
    List<Arqueologico> ast;
    // Creacion del constructor.
    public CustomAdapterArqueologico(Context context, List<Arqueologico> ast) {
        this.context = context;
        this.ast = ast;
    }
    // Adecuamos los metodos.
    @Override
    public int getCount() {
        return ast.size();
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
        ImageView ImageViewArqueologico;
        TextView TextViewNombreArqueologico;
        TextView TextViewDepartamentoArqueologico;
        // Creamos una variable , para obtener de la lista una entidad para poder llenar los datos en el listview.
        Arqueologico a = ast.get(position);
        // Creacion de un if.
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.listviewarqueologico, null);
        // Asignamos sus id correspondientes.
        ImageViewArqueologico = convertView.findViewById(R.id.imageViewArqueologico);
        TextViewNombreArqueologico = convertView.findViewById(R.id.textViewNombreArqueologico);
        TextViewDepartamentoArqueologico = convertView.findViewById(R.id.textViewDepartamentoArqueologico);
        // Agregamos los datos que contendran los elementos.
        ImageViewArqueologico.setImageResource(a.imagenarqueologico);
        TextViewNombreArqueologico.setText(a.nombrearqueologico);
        TextViewDepartamentoArqueologico.setText(a.departamentoarqueologico);
        // retornamos
        return convertView;
    }
}
