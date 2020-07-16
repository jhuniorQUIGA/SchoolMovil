package com.icar.demy.schoolmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfesorActividadDelEstudianteActivity extends AppCompatActivity {
    Button entrevista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_profesor_actividad_del_estudiante );

        entrevista = (Button) findViewById(R.id.entrevistaProfe);
        entrevista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfesorActividadDelEstudianteActivity.this, activity_entrevista_profesor.class));
            }
        });
    }
}
