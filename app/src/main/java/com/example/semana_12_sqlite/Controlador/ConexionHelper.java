package com.example.semana_12_sqlite.Controlador;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionHelper extends SQLiteOpenHelper{


    public ConexionHelper( Context context, String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {db.execSQL(Utility.CREAR_TABLA_USUARIO);}

    @Override
    public void onUpgrade(SQLiteDatabase db, int olVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ Utility.TABLE_USUARIO);
        onCreate(db);
    }
}
