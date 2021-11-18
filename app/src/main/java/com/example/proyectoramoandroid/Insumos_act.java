package com.example.proyectoramoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import Objetos.Insumos;

public class Insumos_act extends AppCompatActivity {

    private Insumos in = new Insumos();
    private Spinner insumos;
    private TextView result;
    private RatingBar estrella;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);

        insumos = findViewById(R.id.spinnerInsumos);
        result = findViewById(R.id.result);
        estrella = findViewById(R.id.ratingBar);

        Bundle bun = getIntent().getExtras();
        String[]listado = bun.getStringArray("insumos");

        ArrayAdapter adapInsumos = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        insumos.setAdapter(adapInsumos);
    }

    public void  Calcular(View view)
    {
        String opcion = insumos.getSelectedItem().toString();
        int precio = 0;
        for (int i = 0; i < opcion.length(); i++)
        {
            if (opcion.equals(in.getInsumos()[i]))
            {
                //precio = in.getPrecios()[i];
                precio = in.anadirAdicional(in.getPrecios()[i],350);
                estrella.setRating(i+1);
                break;
            }
        }
        result.setText("La opcion es: " + opcion + "\nEl Precio es: " + precio);
    }
}