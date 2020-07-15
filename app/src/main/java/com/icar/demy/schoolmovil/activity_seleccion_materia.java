package com.icar.demy.schoolmovil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class activity_seleccion_materia extends AppCompatActivity {

    Button obs;
    Button planNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_materia);

        obs = (Button) findViewById(R.id.observaciones) ;
        obs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_seleccion_materia.this,ObservacionesProfesorActivity.class));
            }
        });

        planNotas = (Button) findViewById(R.id.planillaNotas) ;
        planNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_seleccion_materia.this,ProfesorPlanillaDeNotasActivity.class));
            }
        });
    }
}
