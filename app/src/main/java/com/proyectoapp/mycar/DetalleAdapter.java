package com.proyectoapp.mycar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

public class DetalleAdapter extends PagerAdapter {

    private Context context;
    private Integer[] imagenes;

    public DetalleAdapter(Context context, Integer[] imagenes) {
        this.context = context;
        this.imagenes = imagenes;
    }
    //cuantas pantallas se van a crear
    @Override
    public int getCount() {
        return imagenes.length;
    }

    @Override
    //colection = viewPager, position= que auto selecionó
    public Object instantiateItem(ViewGroup collection, int position) {
        //convierte el diseño xml en una VIEW (objeto java)
        LayoutInflater inflater = (LayoutInflater)
                collection.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //muestra el xml como una view real
        View view = inflater.inflate(R.layout.item_detalle, null);
        ImageView imageView = view.findViewById(R.id.imgDetalle);
        imageView.setImageResource(imagenes[position]);

        TextView tvNombre = view.findViewById(R.id.tvNombreAuto);
        tvNombre.setText(DetalleActivity.nombres[position]);

        TextView tvDescripcion = view.findViewById(R.id.tvDescripcionAuto);
        tvDescripcion.setText(DetalleActivity.descripciones[position]);

        Button btnVolverInicio= view.findViewById(R.id.btn_ir_inicio);

        btnVolverInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(intent);
            }
        });

        Button btnCategorias= view.findViewById(R.id.btn_ir_categorias);

        btnCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ListaActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(intent);
            }
        });

        Button btnVolver = view.findViewById(R.id.btn_volver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) context).finish();
            }
        });

        Button btnAlquilar = view.findViewById(R.id.btn_alquilar);
        btnAlquilar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AlquilerActivity.class);
                intent.putExtra("precio_dia", String.valueOf(DetalleActivity.precios[position]));
                intent.putExtra("nombre", DetalleActivity.nombres[position]);

                context.startActivity(intent);
            }
        });

        collection.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return (view == o);
    }
}