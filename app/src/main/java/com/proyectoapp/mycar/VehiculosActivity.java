package com.proyectoapp.mycar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class VehiculosActivity extends AppCompatActivity {

    private GridView gridView;
    String categoria;

    Integer[] imagenesChevrolet = {R.drawable.che1, R.drawable.che2, R.drawable.che3, R.drawable.che4};
    Integer[] imagenesFord      = {R.drawable.ford1, R.drawable.ford2, R.drawable.ford3, R.drawable.ford4};

    Integer [] imagenesVolkswagen = {R.drawable.volkswagen1, R.drawable.vol2,R.drawable.vol3, R.drawable.vol4};

    Integer [] imagenesToyota = {R.drawable.toy1,R.drawable.toy2,R.drawable.toy3,R.drawable.toy4};


    Integer[] imagenesActuales;

    Button btnVolver;
    Button btnVolverInicio;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_vechiculos);

        categoria = getIntent().getStringExtra("categoria");

        // Según la categoría elijo qué imágenes mostrar
        switch (categoria) {
            case "Chevrolet":
                imagenesActuales = imagenesChevrolet;
                break;
            case "Ford":
                imagenesActuales = imagenesFord;
                break;

            case "Volkswagen":
                imagenesActuales= imagenesVolkswagen;
                break;
            case "Toyota":
                imagenesActuales=imagenesToyota;
                break;


        }

        gridView = findViewById(R.id.gridViewVehiculos);
        gridView.setAdapter(new ImageAdapter(this, imagenesActuales));

        // Click en un vehículo → ir al detalle

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(VehiculosActivity.this, DetalleActivity.class);
                intent.putExtra("categoria", categoria);
                intent.putExtra("posicion", position);
                startActivity(intent);
            }
        });

        //volver atras
        btnVolver =(Button) findViewById(R.id.btn_volver_galeria);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //vovler al incio

        btnVolverInicio=(Button) findViewById(R.id.btn_ir_inicio);

        btnVolverInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent=new Intent(VehiculosActivity.this,MainActivity.class);
                    startActivity(intent);
            }
        });


    }
}