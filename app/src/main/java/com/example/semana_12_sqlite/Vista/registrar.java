package com.example.semana_12_sqlite.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.semana_12_sqlite.Controlador.ConexionHelper;
import com.example.semana_12_sqlite.Controlador.Utility;
import com.example.semana_12_sqlite.R;

public class registrar extends AppCompatActivity {

    EditText textid;
    EditText textnombre;
    EditText textcorreo;

    Button btnregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        textid = findViewById(R.id.txtId);
        textnombre =  findViewById(R.id.txtNombre);
        textcorreo =  findViewById(R.id.txtCorreo);
        btnregister =  findViewById(R.id.btnRegistrar);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            registrarUsuarios();
            }
        });
    }

    private void registrarUsuarios(){
        ConexionHelper conn = new ConexionHelper(this, "bd_usuarios", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utility.CAMPO_ID,textid.getText().toString());
        contentValues.put(Utility.CAMPO_NOMBRE,textnombre.getText().toString());
        contentValues.put(Utility.CAMPO_CORREO,textcorreo.getText().toString());

        long idResultante = db.insert(Utility.TABLE_USUARIO,Utility.CAMPO_ID, contentValues);

        Toast.makeText(getApplicationContext(), "Id ya regitrado"+ idResultante,
                Toast.LENGTH_SHORT).show();

        db.close();
    }

}