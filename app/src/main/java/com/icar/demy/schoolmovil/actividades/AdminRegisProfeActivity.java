package com.icar.demy.schoolmovil.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.icar.demy.schoolmovil.R;
import com.icar.demy.schoolmovil.Registros.Usuarios;

public class AdminRegisProfeActivity extends AppCompatActivity {

    EditText nomProf,apellProf,apellidMaProf,ciProfe,emialProf,telfProf,contraseñaProf;
    Button btnRegistrar;
    Button btnCancelar;
    private DatabaseReference Usuarios;
// ...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_regis_profe);

        Usuarios = FirebaseDatabase.getInstance().getReference("Usuarios");
        btnCancelar = (Button) findViewById(R.id.cancelarProf);
        nomProf = (EditText) findViewById(R.id.nombrePr);
        apellProf = (EditText) findViewById(R.id.apellidPr);
        apellidMaProf = (EditText) findViewById(R.id.apellidMaPr);
        ciProfe = (EditText) findViewById(R.id.ciProf);
        emialProf = (EditText) findViewById(R.id.emailProf);
        telfProf = (EditText) findViewById(R.id.telefonoProf);
        contraseñaProf = (EditText) findViewById(R.id.contraProf);
        btnRegistrar = (Button) findViewById(R.id.registrarProf);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuario();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminRegisProfeActivity.this,AdminAnunciosGenerales.class));
            }
        });

    }
    public void registrarUsuario() {
        String nombre = nomProf.getText().toString();
        String apellido = apellProf.getText().toString();
        String apellidomaterno = apellidMaProf.getText().toString();
        String cedulaId = ciProfe.getText().toString();
        String correoelectronico = emialProf.getText().toString();
        String telefono = telfProf.getText().toString();
        String contraseña = contraseñaProf.getText().toString();
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
        }else if (TextUtils.isEmpty(contraseña)){
            Toast.makeText(this, "Debe llenar los campos", Toast.LENGTH_LONG).show();
        }else {
            String id = Usuarios.push().getKey();
            Usuarios profesor = new Usuarios(id,nombre,apellido,apellidomaterno,cedulaId,correoelectronico,telefono,contraseña);
            Usuarios.child("Profesores").child(id).setValue(profesor);
            Toast.makeText(this,"Registrado",Toast.LENGTH_LONG).show();
            startActivity(new Intent(AdminRegisProfeActivity.this,AdminAnunciosGenerales.class));
        }
    }
}
