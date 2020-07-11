package com.icar.demy.schoolmovil.actividades.Director;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.icar.demy.schoolmovil.R;

public class AdminRegisEstudianteActivity extends AppCompatActivity {
    Spinner comboGrado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_regis_estudiante);
        comboGrado= (Spinner)findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.grados,android.R.layout.simple_spinner_item);
        comboGrado.setAdapter(adapter);
    }
}
