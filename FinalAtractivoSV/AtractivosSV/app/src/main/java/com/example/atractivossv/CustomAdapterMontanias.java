package com.example.atractivossv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapterMontanias extends BaseAdapter {
    // Creacion de variables y una lista con los valores de montañas que se creo.
    Context context;
    List<Montanias> mst;
    // Creacion del constructor.
    public CustomAdapterMontanias(Context context, List<Montanias> mst) {
        this.context = context;
        this.mst = mst;
    }
    // Adecuamos los metodos.
    @Override
    public int getCount() {
        return mst.size();
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
        ImageView ImageViewMontanias;
        TextView TextViewNombreMontania;
        TextView TextViewDepartamentoMontania;
        // Creamos una variable , para obtener de la lista una entidad para poder llenar los datos en el listview.
        Montanias m = mst.get(position);
        // Creacion de un if.
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.listviewmontanias, null);
        // Asignamos sus id correspondientes.
        ImageViewMontanias = convertView.findViewById(R.id.imageViewMontanias);
        TextViewNombreMontania = convertView.findViewById(R.id.textViewNombreMontania);
        TextViewDepartamentoMontania = convertView.findViewById(R.id.textViewDepartamentoMontania);
        // Agregamos los datos que contendran los elementos.
        ImageViewMontanias.setImageResource(m.imagenmontania);
        TextViewNombreMontania.setText(m.nombremontania);
        TextViewDepartamentoMontania.setText(m.departamentomontania);
        // retornamos
        return convertView;
    }
}
