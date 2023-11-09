package com.example.semana_12_sqlite.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.semana_12_sqlite.R;

public class MainActivity extends AppCompatActivity {

    Button btRegistro, listarUsuarios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btRegistro = findViewById(R.id.button1);


        btRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), registrar.class);
                startActivity(intent);
            }
        });


        listarUsuarios = findViewById(R.id.button3);

        listarUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), listar.class);
                startActivity(intent);
            }
        });

    }
}