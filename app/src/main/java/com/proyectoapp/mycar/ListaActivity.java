package com.proyectoapp.mycar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ListaActivity extends AppCompatActivity {

    ListView lvCategorias;

    // Nombres de las categorías
    String[] categorias = {"Chevrolet", "Ford", "Toyota", "Volkswagen"};

    Button volver;

    // Imágenes de las catetgorias de los vehiculos
    int[] imagenes = {
            R.drawable.chevrolet,
            R.drawable.ford,
            R.drawable.toyota,
            R.drawable.volkswagen
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);


        lvCategorias = findViewById(R.id.lvCategorias);

        // Adapter personalizado, el "intermediario" que toma tus datos y los pone dentro del ListView.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.item_categoria,
                R.id.tvNombreCategoria,
                categorias) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) { // Se ejecuta por cada fila de la lista ,pone la imagen correspondiente en cada categoría.
                View vista = super.getView(position, convertView, parent);
                ImageView img = vista.findViewById(R.id.imgCategoria);
                img.setImageResource(imagenes[position]);
                return vista;
            }
        };

        lvCategorias.setAdapter(adapter);
        volver=(Button)findViewById(R.id.btn_volver_principal);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Click en cada categoría
        lvCategorias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(ListaActivity.this, VehiculosActivity.class);
                    intent.putExtra("categoria", categorias[position]); // se le pasa la posicionde la catetgoria seleecionada
                    startActivity(intent);

            }
        });

    }



    }
