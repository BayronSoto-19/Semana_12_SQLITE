package com.example.semana_12_sqlite.Controlador;

public class Utility {

    //constantes campos tabla de usuario

    public static final String TABLE_USUARIO="Usuario";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE="Nombre";
    public static final String CAMPO_CORREO="Correo";


    public static final String CREAR_TABLA_USUARIO="CREATE TABLE "
            +TABLE_USUARIO+" ("+CAMPO_ID+ "INTEGER, "+ CAMPO_NOMBRE+"TEXT, "+ CAMPO_CORREO+" TEXT)";

}


/*public class utility {
    public static final String TABLA_USUARIO = "usuario";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_CORREO = "correo";

    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE " + TABLA_USUARIO + " (" +
            CAMPO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            CAMPO_NOMBRE + " TEXT, " +
            CAMPO_CORREO + " TEXT)";

}*/