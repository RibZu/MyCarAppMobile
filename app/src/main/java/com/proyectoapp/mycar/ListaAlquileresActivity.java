package com.proyectoapp.mycar;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ListaAlquileresActivity extends AppCompatActivity {

    private ListView lista;
    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alquileres);

        lista = (ListView) findViewById(R.id.lista);
        btnVolver = (Button) findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mostrarLista();
    }

    public void mostrarLista(){
        String [] arreglo;
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Administracion",null,1);
        SQLiteDatabase baseDeDatos = admin.getReadableDatabase();

        Cursor fila = baseDeDatos.rawQuery("select * from alquileres", null);

        if(fila.moveToFirst()){
            arreglo = new String[fila.getCount()];
            int i=0;

            int idxNombre = fila.getColumnIndex("nombre");
            int idxApellido = fila.getColumnIndex("apellido");
            int indexDias      = fila.getColumnIndex("dias");
            int idxTotal = fila.getColumnIndex("total");
            int idxAuto = fila.getColumnIndex("auto");

            do {
                String cliente = fila.getString(idxApellido) + ", " + fila.getString(idxNombre);
                String vehiculo = (idxAuto != -1) ? fila.getString(idxAuto) : "Vehículo N/A";
                String montoTotal = fila.getString(idxTotal);
                int vDias        = fila.getInt(indexDias);

                arreglo[i++] = cliente + " - " + vehiculo + " - " + vDias + " días - Total: $" + montoTotal;

            } while (fila.moveToNext());

            ArrayAdapter<String> adaptador = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arreglo);
            lista.setAdapter(adaptador);
        }else{
            Toast.makeText(this, "No existen registros.", Toast.LENGTH_SHORT).show();
        }
        baseDeDatos.close();
    }
}