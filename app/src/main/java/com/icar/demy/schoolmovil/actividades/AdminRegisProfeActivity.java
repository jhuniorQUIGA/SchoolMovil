package com.icar.demy.schoolmovil.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.icar.demy.schoolmovil.R;
import com.icar.demy.schoolmovil.Usuarios;

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
    }
    public void registrarUsuario() {
        String nombre = nomProf.getText().toString();
        String apellido = apellProf.getText().toString();
        String apellidomaterno = apellidMaProf.getText().toString();
        String cedulaId = ciProfe.getText().toString();
        String correoelectronico = emialProf.getText().toString();
        String telefono = telfProf.getText().toString();
        String contraseña = contraseñaProf.getText().toString();

        if (!TextUtils.isEmpty(nombre)) {
            String id = Usuarios.push().getKey();
            Usuarios profesor = new Usuarios(id,nombre,apellido,apellidomaterno,cedulaId,correoelectronico,telefono,contraseña);
            Usuarios.child("Profesores").child(id).setValue(profesor);

            Toast.makeText(this,"Registrado",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Debe introducir un Nombre",Toast.LENGTH_LONG).show();
        }
    }
}
