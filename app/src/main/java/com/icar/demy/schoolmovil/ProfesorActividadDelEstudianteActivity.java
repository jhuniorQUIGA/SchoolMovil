package com.icar.demy.schoolmovil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.FeatureInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.icar.demy.schoolmovil.Registros.Estudiantes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ProfesorActividadDelEstudianteActivity extends AppCompatActivity {
    Button entrevista;
    Spinner mestudiantes;

     DatabaseReference Estudiant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_profesor_actividad_del_estudiante );
        mestudiantes= findViewById(R.id.estudiantes);

        entrevista = (Button) findViewById(R.id.entrevistaProfe);
        entrevista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfesorActividadDelEstudianteActivity.this, activity_entrevista_profesor.class));
            }
        });
        Estudiant = FirebaseDatabase.getInstance().getReference("Estudiantes");
        //loadestudiantes();
    }
  /*  public void loadestudiantes(){
         final List<Estudiantes> estu =new ArrayList<>();
        Estudiant.child("nombre").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for(DataSnapshot ds: dataSnapshot.getChildren()){
                       String nombre = ds.child("nombre").getValue().toString();
                        estu.add(new Estudiantes.(nombre));
                    }
                    ArrayAdapter<Estudiantes>arrayAdapter= new ArrayAdapter<>(ProfesorActividadDelEstudianteActivity.this , android.R.layout.simple_dropdown_item_1line, "Estudiantes");
                    mestudiantes.setAdapter(arrayAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/
    }

