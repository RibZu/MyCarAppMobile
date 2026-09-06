package com.proyectoapp.mycar;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

    public class ResumenActivity extends AppCompatActivity {
        String nombre, apellido, formaPago, precio, dias, auto;
        TextView Alnombre, AlformaPago, Alprecio, Aldias, Alapellido, AlprecioTotal, Alauto;
        Button btnVolverCancelar, btnGuardarDB;

        Integer cantDias;
        Double precioDia, total;




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_resumen);


            nombre = getIntent().getStringExtra("nombre");
            apellido = getIntent().getStringExtra("apellido");
            formaPago = getIntent().getStringExtra("forma_pago");
            precio = getIntent().getStringExtra("precio_dia");
            dias = getIntent().getStringExtra("dias");
            auto = getIntent().getStringExtra("auto");

            cantDias = Integer.parseInt(dias);
            precioDia = Double.parseDouble(precio);
            total = cantDias * precioDia;

            Alnombre = findViewById(R.id.tvNombre);
            Alapellido = findViewById(R.id.tvApellido);
            AlformaPago = findViewById(R.id.tvFormaPago);
            Alprecio = findViewById(R.id.tvPrecioDia);
            Aldias = findViewById(R.id.tvDias);
            AlprecioTotal = findViewById(R.id.tvTotal);
            Alauto=findViewById(R.id.tvAuto);
            btnGuardarDB = findViewById(R.id.btnConfirmar);
            btnVolverCancelar = findViewById(R.id.btnCancelar);

            Alnombre.setText(nombre);
            Alapellido.setText(apellido);
            AlformaPago.setText(formaPago);
            Alprecio.setText("$" + String.valueOf(precioDia) + " USD");
            Aldias.setText(String.valueOf(cantDias));
            AlprecioTotal.setText("$" + String.valueOf(total) + " USD");
            Alauto.setText(auto);


            btnGuardarDB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AdminSQLiteOpenHelper alquilerHelper = new AdminSQLiteOpenHelper(ResumenActivity.this, "Administracion", null, 1);
                    SQLiteDatabase baseDeDatos = alquilerHelper.getWritableDatabase();

                    ContentValues datos = new ContentValues();
                    datos.put("nombre", nombre);
                    datos.put("apellido", apellido);
                    datos.put("forma_pago", formaPago);
                    datos.put("dias", cantDias);
                    datos.put("total", total);
                    datos.put("auto", auto);

                    baseDeDatos.insert("alquileres", null, datos);
                    baseDeDatos.close();

                    Toast.makeText(ResumenActivity.this, "¡Alquiler guardado con éxito!", Toast.LENGTH_SHORT).show();

                    finish();
                }
            });

            btnVolverCancelar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    finish();
                }
            });

        }
    }