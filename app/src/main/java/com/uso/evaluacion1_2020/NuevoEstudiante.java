package com.uso.evaluacion1_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class NuevoEstudiante extends AppCompatActivity {
    private EditText txbNombre;
    private EditText txbCodigo;
    private EditText txbMateria;
    private EditText txbParcial1;
    private EditText txbParcial2;
    private EditText txbParcial3;
    private Double Promedio;
    private Button btnProcesar;
    private static int contProceso = 0;
    private ProgressBar progresbar;
    private Handler manejadorProcesos;
    public static final String textoNombre = "textoNombre";
    public static final String textoCodigo = "textoCodigo";
    public static final String textoMateria = "textoMateria";
    public static final String textoPromedio = "textoPromedio";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_estudiante);
        this.btnProcesar = findViewById(R.id.btnProcesar);
        this.progresbar = findViewById(R.id.progressBar);
        this.manejadorProcesos = new Handler();
        this.txbNombre = findViewById(R.id.txbNombre);
        this.txbCodigo = findViewById(R.id.txbCodigo);
        this.txbMateria = findViewById(R.id.txbMateria);
        this.txbParcial1 = findViewById(R.id.txbPrimer);
        this.txbParcial2 = findViewById(R.id.txbSegundo);
        this.txbParcial3 = findViewById(R.id.txbFinal);
        this.progresbar.setMax(100);

        this.btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!InfoIsValid()){
                    Toast.makeText(NuevoEstudiante.this,"Campos requeridos",Toast.LENGTH_SHORT).show();
                }else{
                    new Thread(new ProcesoSecundario()).start();
                }
            }
        });
    }

    final class ProcesoSecundario implements Runnable{
        @Override
        public void run() {
            while (contProceso < 100){
                metodoEspera();
                manejadorProcesos.post(new Runnable() {
                    @Override
                    public void run() {
                        progresbar.setProgress(contProceso);
                        //Validar si el proceso ya termino
                        if(contProceso == 100){
                            String nombre = txbNombre.getText().toString();
                            String codigo = txbCodigo.getText().toString();
                            String Materia = txbMateria.getText().toString();

                            Double p1 = Double.valueOf(txbParcial1.getText().toString());
                            Double p2 = Double.valueOf(txbParcial2.getText().toString());
                            Double p3 = Double.valueOf(txbParcial3.getText().toString());
                            Promedio = ((p1*0.30)+(p2*0.30)+(p3*0.40));
                            String p  = String.valueOf(Promedio);
                            Intent msg = new Intent();
                            msg.putExtra(textoNombre,nombre);
                            msg.putExtra(textoCodigo,codigo);
                            msg.putExtra(textoMateria,Materia);
                            msg.putExtra(textoPromedio,p);
                            contProceso = 0;
                            setResult(RESULT_OK,msg);
                            finish();

                        }
                    }
                });
            }
        }

        private void metodoEspera(){
            try {
                Thread.sleep(90);
                contProceso++;
            }catch(Exception e){

            }
        }

    }
    private boolean InfoIsValid(){
        if(this.txbNombre.getText().toString().trim().length() <= 1 &&
                this.txbCodigo.getText().toString().trim().length() <= 1 &&
                this.txbMateria.getText().toString().trim().length() <= 1 &&
                this.txbParcial1.getText().toString().trim().length() <= 1 &&
                this.txbParcial2.getText().toString().trim().length() <= 1 &&
                this.txbParcial3.getText().toString().trim().length() <= 1
        ){

            return false;
        }
        return true;
    }
}