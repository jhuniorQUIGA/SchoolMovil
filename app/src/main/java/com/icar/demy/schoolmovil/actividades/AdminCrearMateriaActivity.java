package com.icar.demy.schoolmovil.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.icar.demy.schoolmovil.R;
import com.icar.demy.schoolmovil.Registros.Estudiantes;
import com.icar.demy.schoolmovil.Registros.Materias;

public class AdminCrearMateriaActivity extends AppCompatActivity {

    EditText nomMateria,nomProfesor;
    Spinner cursoDeLaMateria;
    Button btnRegistrar;

    private DatabaseReference Materias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_admin_crear_materia );

        Materias = FirebaseDatabase.getInstance().getReference("Materias");

        nomMateria = (EditText) findViewById(R.id.nombreMateria);
        nomProfesor = (EditText) findViewById(R.id.nombreProfesorMater);
        cursoDeLaMateria = (Spinner) findViewById(R.id.cursosMateria);

        btnRegistrar = (Button) findViewById(R.id.btnRegistrarMateria);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarMateria();
            }
        });
    }
    public void registrarMateria(){

        String nombre = nomMateria.getText().toString();
        String nombreProfesor = nomProfesor.getText().toString();
        String cursos = cursoDeLaMateria.getSelectedItem().toString();

        if (TextUtils.isEmpty(nombre)) {
            Toast.makeText(this, "Debe llenar los campos", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(nombreProfesor)){
            Toast.makeText(this, "Debe llenar los campos", Toast.LENGTH_LONG).show();
        }else{
            String idMateria = Materias.push().getKey();
            Materias materia = new Materias(idMateria,nombre,nombreProfesor,cursos);
            Materias.child("Materias").child(idMateria).setValue(materia);
            Toast.makeText(this,"Registrado",Toast.LENGTH_LONG).show();
            startActivity(new Intent(AdminCrearMateriaActivity.this,AdminAnunciosGenerales.class));
        }
    }
}
