package com.example.atractivossv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapterVolcanes extends BaseAdapter {
// Creacion de variables y una lista con los valores de volcanes que se creo.
    Context context;
    List<Volcanes> vst;
// Creacion del constructor.
    public CustomAdapterVolcanes(Context context, List<Volcanes> vst) {
        this.context = context;
        this.vst = vst;
    }
// Adecuamos los metodos.
    @Override
    public int getCount() {
        return vst.size();
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
        ImageView ImageViewVolcanes;
        TextView  TextViewNombreVolcanes;
        TextView  TextViewDepartamentoVolcanes;
// Creamos una variable , para obtener de la lista una entidad para poder llenar los datos en el listview.
        Volcanes v=vst.get(position);
// Creacion de un if.
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.listviewvolcanes, null);
// Asignamos sus id correspondientes.
        ImageViewVolcanes=convertView.findViewById(R.id.imageViewVolcanes);
        TextViewNombreVolcanes=convertView.findViewById(R.id.textViewNombreVolcanes);
        TextViewDepartamentoVolcanes=convertView.findViewById(R.id.textViewDepartamentoVolcanes);
// Agregamos los datos que contendran los elementos.
        ImageViewVolcanes.setImageResource(v.imagenvolcan);
        TextViewNombreVolcanes.setText(v.nombrevolcan);
        TextViewDepartamentoVolcanes.setText(v.departamentovolcan);
// retornamos
        return convertView;
    }
}
