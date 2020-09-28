package com.uso.evaluacion1_2020.Adaptadores;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uso.evaluacion1_2020.R;

// creamos los componentes de la plantilla


public class viewHolderInformacion extends RecyclerView.ViewHolder {
    private TextView lblNombre;
    private TextView lblCodigo;
    private TextView lblPromedio;
    private TextView lblMateria;
    public viewHolderInformacion(@NonNull View itemView) {
        super(itemView);

        this.lblNombre = itemView.findViewById(R.id.lblNombre);
        this.lblCodigo = itemView.findViewById(R.id.lblCodigo);
        this.lblPromedio = itemView.findViewById(R.id.lbPromedio);
        this.lblMateria = itemView.findViewById(R.id.lblMateria);
    }

    public TextView getLblNombre() {
        return lblNombre;
    }

    public TextView getLblCodigo() {
        return lblCodigo;
    }

    public TextView getLblPromedio() {
        return lblPromedio;
    }

    public TextView getLblMateria() {
        return lblMateria;
    }
}
