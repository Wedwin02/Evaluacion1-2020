package com.uso.evaluacion1_2020.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uso.evaluacion1_2020.R;

import java.util.List;

public class AdaptadorInformacion extends RecyclerView.Adapter<viewHolderInformacion> {
   private List<Estudiante> ListaEstudiante;

   public AdaptadorInformacion(List<Estudiante> data){
       this.ListaEstudiante = data;
   }

    @NonNull
    @Override
    public viewHolderInformacion onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.plantilla_lista,parent,false);
       viewHolderInformacion vhi = new viewHolderInformacion(vista);
        return vhi;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderInformacion holder, int position) {
       holder.getLblNombre().setText(this.ListaEstudiante.get(position).getNombre());
       holder.getLblCodigo().setText(this.ListaEstudiante.get(position).getCodigo());
       holder.getLblMateria().setText(this.ListaEstudiante.get(position).getMateria());
       holder.getLblPromedio().setText(String.valueOf(this.ListaEstudiante.get(position).getPromedio()));

    }

    @Override
    public int getItemCount() {
        return this.ListaEstudiante.size();
    }
}
