package com.example.semana_12_sqlite.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.semana_12_sqlite.Controlador.ConexionHelper;
import com.example.semana_12_sqlite.Controlador.Utility;
import com.example.semana_12_sqlite.R;

public class mantener extends AppCompatActivity {


    EditText textId;
    EditText textNombre;
    EditText textCorreo;
    Button btnconsultar, btnupdate, btndelete;

    ConexionHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mantener);

        conn = new ConexionHelper(getApplicationContext(), "bd_usuarios", null, 1);

        textId= findViewById(R.id.txtid);
        textNombre= findViewById(R.id.txtnombre);
        textCorreo = findViewById(R.id.txtcorreo);

        btnconsultar= findViewById(R.id.btnSearh);
        btnupdate= findViewById(R.id.btnUpdate);
        btndelete= findViewById(R.id.btnDelete);


        btnconsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = conn.getWritableDatabase();
                String[] parametros = {textId.getText().toString()};

                try {
                    Cursor cursor = db.rawQuery("SELECT " + Utility.CAMPO_NOMBRE + "," + Utility.CAMPO_CORREO + " FROM " + Utility.TABLE_USUARIO + " WHERE "+ Utility.CAMPO_ID + "=?", parametros);
                    cursor.moveToFirst();
                    textNombre.setText(cursor.getString(0));
                    textCorreo.setText(cursor.getString(1));
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Atención usuario no existe", Toast.LENGTH_SHORT).show();
                }



            }
        });

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = conn.getWritableDatabase();
                String[] parametros = {textId.getText().toString()};

                ContentValues values = new ContentValues();
                values.put(Utility.CAMPO_NOMBRE, textNombre.getText().toString());
                values.put(Utility.CAMPO_CORREO, textCorreo.getText().toString());

                db.update(Utility.TABLE_USUARIO, values, Utility.CAMPO_ID + "=?", parametros);
                Toast.makeText(getApplicationContext(), "Atencion, Se actualiaao el usuario", Toast.LENGTH_SHORT).show();


                db.close();
                limpiar();
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = conn.getWritableDatabase();
                String[] parametros = {textId.getText().toString()};

                db.delete(Utility.TABLE_USUARIO,Utility.CAMPO_ID + "=?", parametros);
                Toast.makeText(getApplicationContext(), "Atencion, Se elimino el usuario", Toast.LENGTH_SHORT).show();
            textId.setText("");
            limpiar();
            db.close();

            }
        });
    }

    private void consultarSql() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={textId.getText().toString()};

        try {
            //select nombre,telefono from usuario where codigo=?
            Cursor cursor=db.rawQuery("SELECT "+Utility.CAMPO_NOMBRE+","+Utility.CAMPO_CORREO+
                    " FROM "+Utility.TABLE_USUARIO+" WHERE "+Utility.CAMPO_ID+"=? ",parametros);

            cursor.moveToFirst();
            textNombre.setText(cursor.getString(0));
            textCorreo.setText(cursor.getString(1));

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El documento no existe",Toast.LENGTH_LONG).show();
            limpiar();
        }
    }

    private void limpiar(){
        textNombre.setText("");
        textCorreo.setText("");
    }
}