package com.uso.evaluacion1_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.uso.evaluacion1_2020.Adaptadores.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private  Button btnListaEstudiante;
    private  Button btnNuevoEstudiante;
    List<Estudiante> ListaGlobal = new ArrayList<Estudiante>();
    public static final int id=4;

    public void onActivityResult(int requestcode, int resultcode, Intent data ){
        super.onActivityResult(requestcode, resultcode, data);

        switch (requestcode){
            case id:{
                if(RESULT_OK == resultcode){
                    Estudiante n = new Estudiante();
                    n.setNombre(data.getStringExtra(NuevoEstudiante.textoNombre));
                    n.setCodigo(data.getStringExtra(NuevoEstudiante.textoCodigo));
                    n.setMateria(data.getStringExtra(NuevoEstudiante.textoMateria));
                    n.setPromedio(Double.valueOf(data.getStringExtra(NuevoEstudiante.textoPromedio)));
                    ListaGlobal.add(n);
                    Toast.makeText(this, "Enviado con Exito..", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Saliendo....", Toast.LENGTH_SHORT).show();

                }
            }
            break;
            default:
                Toast.makeText(this, "Error en el switch..", Toast.LENGTH_SHORT).show();
                break;
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNuevoEstudiante = findViewById(R.id.btnNuevoEstudiante);
        btnListaEstudiante = findViewById(R.id.btnListaEstudiantes);


        this.btnNuevoEstudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent frm = new Intent(MainActivity.this,NuevoEstudiante.class);
                startActivityForResult(frm,id);

            }
        });

        this.btnListaEstudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(ListaGlobal.size() == 0)){
                    Intent frm = new Intent(MainActivity.this,ListaEstudiantes.class);
                    Gson g = new Gson();
                    String Datos = g.toJson(ListaGlobal);
                    frm.putExtra("DatosLista",Datos);
                    startActivity(frm);
                }else{
                    Toast.makeText(MainActivity.this,"Lista Vacia..",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}