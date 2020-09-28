package com.uso.evaluacion1_2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.uso.evaluacion1_2020.Adaptadores.AdaptadorInformacion;
import com.uso.evaluacion1_2020.Adaptadores.Estudiante;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ListaEstudiantes extends AppCompatActivity {
    private List<Estudiante> ListaEstudiante = new ArrayList<Estudiante>();
    private RecyclerView Lista;
    private AdaptadorInformacion Adaptador;
    private LinearLayoutManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_estudiantes);
        //Recibimos los datos
        Intent a = getIntent();
        String DatosLista = a.getStringExtra("DatosLista");
        Gson gn = new Gson();
        Type type =  new TypeToken<ArrayList<Estudiante>>(){}.getType();
        ArrayList<Estudiante>items = gn.fromJson(DatosLista,type);
        this.ListaEstudiante = items;



        //
        this.Lista = findViewById(R.id.RCV);
        this.manager = new  LinearLayoutManager(this);
        this.Adaptador= new AdaptadorInformacion(ListaEstudiante);

        //Configurar

        this.Lista.setHasFixedSize(true);
        this.Lista.setLayoutManager(manager);
        this.Lista.setAdapter(Adaptador);

    }
}