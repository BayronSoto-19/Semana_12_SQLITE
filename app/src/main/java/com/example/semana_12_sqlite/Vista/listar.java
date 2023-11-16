package com.example.semana_12_sqlite.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.semana_12_sqlite.Controlador.ConexionHelper;
import com.example.semana_12_sqlite.Controlador.Utility;
import com.example.semana_12_sqlite.Modelo.Usuario;
import com.example.semana_12_sqlite.R;

import java.util.ArrayList;

public class listar extends AppCompatActivity {


    ListView listViewusuario;
    ArrayList listainformacion;
    ArrayList<Usuario> listaUsuario;
    ConexionHelper conn;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_listar);

            listViewusuario = findViewById(R.id.listViewUsuarios);

            conn = new ConexionHelper(getApplicationContext(), "bd_usuario", null, 1);
            //consultarListaUsuarios();


            // Creación de un ArrayAdapter para mostrar la lista en el ListView
            ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                    listainformacion);

            listViewusuario.setAdapter(adaptador);


            listViewusuario.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String informacion="id: " + listaUsuario.get(position).getId() +"\n";
                    informacion+="Nombres: " + listaUsuario.get(position).getNombre() +"\n";
                    informacion+="Correo: " + listaUsuario.get(position).getCorreo() +"\n";
                    Toast.makeText(getApplicationContext(), informacion,Toast.LENGTH_LONG).show();
                }
            });
    }

    private void consultarListaUsuarios() {
        SQLiteDatabase db = conn.getReadableDatabase();
        Usuario usuario=null;
        listaUsuario=new ArrayList<Usuario>();

        //La consulta se realiza mediante un objeto Cursor que ejecuta la consulta SQL:
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utility.TABLE_USUARIO, null);
        while (cursor.moveToNext()){
            usuario=new Usuario();
            usuario.setId(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setCorreo(cursor.getString(2));
            listaUsuario.add(usuario);
        }
        obtenerLista();
    }

    private void obtenerLista(){
        listainformacion=new ArrayList<String>();
        for (int i=0; i<listaUsuario.size(); i++){
            listainformacion.add(listaUsuario.get(i).getId()+ " - " + listaUsuario.get(i).getNombre());
        }
    }

}