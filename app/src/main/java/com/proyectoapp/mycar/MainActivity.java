package com.proyectoapp.mycar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnIrLista, btnIrAlquiler, btnIrInformacion, btnSalirApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIrInformacion=(Button) findViewById(R.id.btnInformacion);
        btnIrAlquiler=(Button) findViewById(R.id.btnAlquiler);
        btnIrLista=(Button) findViewById(R.id.btnLista);
        btnSalirApp=(Button)findViewById(R.id.btnSalir);


        btnIrInformacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,InformacionActivity.class);

                startActivity(intent);

            }
        });


        btnIrLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ListaActivity.class);

                startActivity(intent);
            }
        });

        btnIrAlquiler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ListaAlquileresActivity.class);

                startActivity(intent);
            }
        });

        btnSalirApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });



    }


}