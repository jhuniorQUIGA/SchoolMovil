package com.icar.demy.schoolmovil;

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
import com.icar.demy.schoolmovil.Registros.Notas;
import com.icar.demy.schoolmovil.Registros.Usuarios;
import com.icar.demy.schoolmovil.actividades.AdminAnunciosGenerales;
import com.icar.demy.schoolmovil.actividades.AdminRegisProfeActivity;

public class ProfesorPlanillaDeNotasActivity extends AppCompatActivity {

    EditText nomEstuTrabajo,notaTrabajo,descripcionTrabajo;
    Spinner tipoTrabajo;
    Button btnEnviarPlanilla;
    private DatabaseReference Notas;
// ...
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_profesor_planilla_de_notas );

        Notas = FirebaseDatabase.getInstance().getReference("Notas");

        nomEstuTrabajo = (EditText) findViewById(R.id.nomEstuTrabajo);
        notaTrabajo = (EditText) findViewById(R.id.notaEstuTrabajo);
        descripcionTrabajo = (EditText) findViewById(R.id.descTrabajo);
        tipoTrabajo = (Spinner) findViewById(R.id.tipoTrabajo);

        btnEnviarPlanilla = (Button) findViewById(R.id.btnSubirTrabajo);
        btnEnviarPlanilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarNota();
            }
        });
    }
    public void registrarNota(){
        String nombreEs = nomEstuTrabajo.getText().toString();
        String notaEs = notaTrabajo.getText().toString();
        String descTrabajo = descripcionTrabajo.getText().toString();
        String tipTrab = tipoTrabajo.getSelectedItem().toString();
        if (TextUtils.isEmpty(nombreEs)) {
            Toast.makeText(this, "Debe llenar los campos", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(notaEs)){
            Toast.makeText(this, "Debe llenar los campos", Toast.LENGTH_LONG).show();
        }else if(TextUtils.isEmpty(descTrabajo)){
            Toast.makeText(this, "Debe llenar los campos", Toast.LENGTH_LONG).show();
        }else {
            String idNota = Notas.push().getKey();
            Notas nota = new Notas(idNota,tipTrab,nombreEs,notaEs,descTrabajo);
            Notas.child("Notas").child(idNota).setValue(nota);
            Toast.makeText(this,"Registrado",Toast.LENGTH_LONG).show();
        }
    }
}
