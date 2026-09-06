package com.proyectoapp.mycar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE alquileres (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, apellido TEXT, forma_pago TEXT, dias INTEGER, total REAL, auto TEXT)");


        db.execSQL("INSERT INTO alquileres (nombre, apellido, forma_pago, dias, total, auto) VALUES ('Juan', 'Perez', 'Efectivo', 3, 15000.50, 'Toyota Corolla')");
        db.execSQL("INSERT INTO alquileres (nombre, apellido, forma_pago, dias, total, auto) VALUES ('Ana', 'Gomez', 'Tarjeta', 5, 25000.00, 'Chevrolet Tracker')");
        db.execSQL("INSERT INTO alquileres (nombre, apellido, forma_pago, dias, total, auto) VALUES ('Carlos', 'Lopez', 'Transferencia', 2, 10000.00, 'Ford Mustang')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}