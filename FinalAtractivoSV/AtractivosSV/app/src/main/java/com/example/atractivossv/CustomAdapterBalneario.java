package com.example.atractivossv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapterBalneario extends BaseAdapter {
    // Creacion de variables y una lista con los valores de balneario que se creo.
    Context context;
    List<Balnearios> bst;
    // Creacion del constructor.
    public CustomAdapterBalneario(Context context, List<Balnearios> bst) {
        this.context = context;
        this.bst = bst;
    }
    // Adecuamos los metodos.
    @Override
    public int getCount() {
        return bst.size();
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
        ImageView ImageViewBalneario;
        TextView TextViewNombreBalneario;
        TextView TextViewDepartamentoBalneario;
        // Creamos una variable , para obtener de la lista una entidad para poder llenar los datos en el listview.
        Balnearios b = bst.get(position);
        // Creacion de un if.
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.listviewbalnearios, null);
        // Asignamos sus id correspondientes.
        ImageViewBalneario = convertView.findViewById(R.id.imageViewBalneario);
        TextViewNombreBalneario = convertView.findViewById(R.id.textViewNombreBalneario);
        TextViewDepartamentoBalneario = convertView.findViewById(R.id.textViewDepartamentoBalneario);
        // Agregamos los datos que contendran los elementos.
        ImageViewBalneario.setImageResource(b.imagenbalneario);
        TextViewNombreBalneario.setText(b.nombrebalneario);
        TextViewDepartamentoBalneario.setText(b.departamentobalneario);
        // retornamos
        return convertView;
    }
}
