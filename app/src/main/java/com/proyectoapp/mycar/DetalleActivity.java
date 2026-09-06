package com.proyectoapp.mycar;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

public class DetalleActivity extends AppCompatActivity {

    public static String[]  nombres;
    public static String[]  descripciones;
    public static int[] precios;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detalle);

        String categoria = getIntent().getStringExtra("categoria");
        int posicionInicial = getIntent().getIntExtra("posicion", 0);

        // Elegir imágenes según categoría
        Integer[] imagenesActuales;

        switch (categoria) {
            case "Chevrolet":
                imagenesActuales = new Integer[]{R.drawable.che1, R.drawable.che2, R.drawable.che3, R.drawable.che4};
                nombres = new String[]{
                        "Chevrolet Onix",
                        "Chevrolet S10",
                        "Chevrolet Tracker",
                        "Chevrolet Cruze"
                };
                precios = new int[]{35, 65, 50, 45};
                descripciones = new String[]{
                        String.format("Año: 2024\nModelo: Onix LT\nMotor: 1.2 Turbo 101 CV\nPlazas: 5\nKilometraje: 18.000 km\nPrecio por día: $%d USD", precios[0]),
                        String.format("Año: 2023\nModelo: S10 High Country\nMotor: 2.8 Diesel 200 CV\nPlazas: 5\nTracción: 4×4\nKilometraje: 8.500 km\nPrecio por día: $%d USD", precios[1]),
                        String.format("Año: 2023\nModelo: Tracker Premier\nMotor: 1.2 Turbo 133 CV\nPlazas: 5\nKilometraje: 5.200 km\nPrecio por día: $%d USD", precios[2]),
                        String.format("Año: 2023\nModelo: Cruze LTZ\nMotor: 1.4 Turbo 153 CV\nPlazas: 5\nKilometraje: 12.000 km\nPrecio por día: $%d USD", precios[3]),
                };
                break;
            case "Ford":
                imagenesActuales = new Integer[]{R.drawable.ford1, R.drawable.ford2, R.drawable.ford3, R.drawable.ford4};
                nombres = new String[]{
                        "Ford Ranger",
                        "Ford Bronco",
                        "Ford Mustang",
                        "Ford Fiesta"
                };
                precios = new int[]{70, 90, 110, 40};

                descripciones = new String[]{
                        String.format("Año: 2023\nModelo: Ranger XLT\nMotor: 3.2 Diesel 200 CV\nPlazas: 5\nTracción: 4×4\nKilometraje: 15.000 km\nPrecio por día: $%d USD", precios[0]),
                        String.format("Año: 2023\nModelo: Bronco Wildtrak\nMotor: 2.3 EcoBoost 300 CV\nPlazas: 5\nKilometraje: 3.000 km\nPrecio por día: $%d USD", precios[1]),
                        String.format("Año: 2023\nModelo: Mustang GT\nMotor: 5.0 V8 450 CV\nPlazas: 4\nKilometraje: 6.800 km\nPrecio por día: $%d USD", precios[2]),
                        String.format("Año: 2021\nModelo: Fiesta ST-Line\nMotor: 1.0 EcoBoost 125 CV\nPlazas: 5\nKilometraje: 32.000 km\nPrecio por día: $%d USD", precios[3])
                };
                break;
            case "Volkswagen":
                imagenesActuales = new Integer[]{R.drawable.volkswagen1, R.drawable.vol2,R.drawable.vol3,R.drawable.vol4};
                nombres= new String[]{
                        "Volkswagen Polo",
                        "Volkswagen Golf",
                        "Volkswagen Passat",
                        "Volkswagen Tiguan"
                };
                precios = new int[]{35, 38, 42, 75};

                descripciones = new String[]{
                        String.format("Año: 2015\nModelo: Polo Comfortline\nMotor: 1.6 MPI 110 CV\nPlazas: 5\nTransmisión: Manual 5 velocidades\nKilometraje: 48.000 km\nPrecio por día: $%d USD", precios[0]),
                        String.format("Año: 2007\nModelo: Golf GTI Mk5\nMotor: 2.0 TSI 200 CV\nPlazas: 5\nKilometraje: 85.000 km\nPrecio por día: $%d USD", precios[1]),
                        String.format("Año: 2013\nModelo: Passat Comfortline\nMotor: 1.8 TSI 152 CV\nPlazas: 5\nKilometraje: 95.000 km\nPrecio por día: $%d USD", precios[2]),
                        String.format("Año: 2022\nModelo: Tiguan R\nMotor: 2.0 TSI 320 CV\nPlazas: 5\nTracción: 4Motion AWD\nKilometraje: 12.000 km\nPrecio por día: $%d USD", precios[3])
                };
                break;

            case "Toyota":

                imagenesActuales= new Integer[]{R.drawable.toy1,R.drawable.toy2,R.drawable.toy3,R.drawable.toy4};
                nombres=new String[]{
                        "Toyota Corolla",
                        "Toyota Aygo",
                        "Toyota C-HR Hybrid",
                        "Toyota Tacoma"

                };
                precios = new int[]{55, 25, 48, 80};

                descripciones = new String[]{
                        String.format("Año: 2022\nModelo: Corolla XEI\nMotor: 2.0 Dynamic Force 170 CV\nPlazas: 5\nTransmisión: CVT Automática\nKilometraje: 18.000 km\nPrecio por día: $%d USD", precios[0]),
                        String.format("Año: 2009\nModelo: Aygo\nMotor: 1.0 VVT-i 68 CV\nPlazas: 5\nKilometraje: 72.000 km\nPrecio por día: $%d USD", precios[1]),
                        String.format("Año: 2018\nModelo: C-HR Hybrid\nMotor: 1.8 Híbrido 122 CV\nPlazas: 5\nKilometraje: 38.000 km\nPrecio por día: $%d USD", precios[2]),
                        String.format("Año: 2019\nModelo: Tacoma TRD Off-Road\nMotor: 3.5 V6 278 CV\nPlazas: 5\nTracción: 4×4\nKilometraje: 45.000 km\nPrecio por día: $%d USD", precios[3])
                };

                break;
            default:
                imagenesActuales = new Integer[]{};
                precios = new int[]{0};
        }

        ViewPager viewPager = findViewById(R.id.viewPagerDetalle);
        viewPager.setAdapter(new DetalleAdapter(this, imagenesActuales));

        // Arrancar en el vehículo que tocó el usuario
        viewPager.setCurrentItem(posicionInicial, false);

    }
}