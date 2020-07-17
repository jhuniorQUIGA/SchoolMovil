package com.icar.demy.schoolmovil.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.icar.demy.schoolmovil.R;
import com.icar.demy.schoolmovil.Registros.Estudiantes;
import com.icar.demy.schoolmovil.Registros.Usuarios;

public class AdminRegisEstudianteActivity extends AppCompatActivity {
    Spinner comboGrado;
    EditText nomEstu,apellEstu,apellidMaEstu,ciEstu,emialEstu,telfEstu,contrasenaEstu;
    Button btnRegistrarEstu;
    Button btnCancelarEstu;
    private DatabaseReference Estudiantes;
// ...


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_regis_estudiante);

        Estudiantes = FirebaseDatabase.getInstance().getReference("Estudiantes");

        comboGrado= (Spinner) findViewById(R.id.cursos);
        nomEstu = (EditText) findViewById(R.id.nombreEs);
        apellEstu = (EditText) findViewById(R.id.apellidEs);
        apellidMaEstu = (EditText) findViewById(R.id.apellidMaEs);
        ciEstu = (EditText) findViewById(R.id.ciEstu);
        emialEstu = (EditText) findViewById(R.id.emailEstu);
        telfEstu = (EditText) findViewById(R.id.telefonoEstu);
        contrasenaEstu = (EditText) findViewById(R.id.contraEstu);


        btnRegistrarEstu = (Button) findViewById(R.id.registrarEstu);
        btnCancelarEstu = (Button) findViewById(R.id.cancelarEstu);

        btnRegistrarEstu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarEstudiante();
            }
        });

        btnCancelarEstu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminRegisEstudianteActivity.this,AdminAnunciosGenerales.class));
            }
        });
    }
    public void registrarEstudiante() {
        String nombre = nomEstu.getText().toString();
        String apellido = apellEstu.getText().toString();
        String apellidomaterno = apellidMaEstu.getText().toString();
        String cedulaId = ciEstu.getText().toString();
        String grado = comboGrado.getSelectedItem().toString();
        String correoelectronico = emialEstu.getText().toString();
        String telefono = telfEstu.getText().toString();
        String contrasena = contrasenaEstu.getText().toString();
        if (TextUtils.isEmpty(nombre)) {
            Toast.makeText(this, "Debe llenar los campos", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(apellido)){
            Toast.makeText(this, "Debe llenar los campos", Toast.LENGTH_LONG).show();
        }else if(TextUtils.isEmpty(apellidomaterno)){
            Toast.makeText(this, "Debe llenar los campos", Toast.LENGTH_LONG).show();
        }else if (TextUtils.isEmpty(cedulaId)){
            Toast.makeText(this, "Debe llenar los campos", Toast.LENGTH_LONG).show();
        }else if (TextUtils.isEmpty(correoelectronico)){
            Toast.makeText(this, "Debe llenar los campos", Toast.LENGTH_LONG).show();
        }else if (TextUtils.isEmpty(telefono)){
            Toast.makeText(this, "Debe llenar los campos", Toast.LENGTH_LONG).show();
        }else if (TextUtils.isEmpty(contrasena)){
            Toast.makeText(this, "Debe llenar los campos", Toast.LENGTH_LONG).show();
        }else {
   String idEstu = Estudiantes.push().getKey();
            Estudiantes estudiantes = new Estudiantes(idEstu,nombre,apellido,apellidomaterno,cedulaId,grado,correoelectronico,telefono,contrasena);
            Estudiantes.child("Estudiantes").child(idEstu).setValue(estudiantes);
            Toast.makeText(this,"Registrado",Toast.LENGTH_LONG).show();
            startActivity(new Intent(AdminRegisEstudianteActivity.this,AdminAnunciosGenerales.class));
        }
    }
}
