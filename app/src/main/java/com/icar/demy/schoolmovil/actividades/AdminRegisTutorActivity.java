package com.icar.demy.schoolmovil.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.icar.demy.schoolmovil.R;
import com.icar.demy.schoolmovil.Registros.Padres;
import com.icar.demy.schoolmovil.Registros.Usuarios;

public class AdminRegisTutorActivity extends AppCompatActivity {

    EditText nomHijoPa,nomPadre,ciPadre,emialPadre,telfPadre,contraseñaPadre;
    Button btnRegistrarPa;
    Button btnCancelarPa;
    private DatabaseReference Padres;
    private DatabaseReference Consulta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_regis_tutor);

        Padres = FirebaseDatabase.getInstance().getReference("Padres");
        //Consulta = FirebaseDatabase.getInstance().getReference("Consulta");

        nomHijoPa = (EditText) findViewById(R.id.nombreHijoPadre);
        nomPadre = (EditText) findViewById(R.id.nombrePadre);
        ciPadre = (EditText) findViewById(R.id.ciPadre);
        emialPadre = (EditText) findViewById(R.id.emailPadre);
        telfPadre = (EditText) findViewById(R.id.telefPadre);
        contraseñaPadre = (EditText) findViewById(R.id.contraPadre);

        btnRegistrarPa = (Button) findViewById(R.id.btnRegistraPadre);
        btnCancelarPa = (Button) findViewById(R.id.btnCancelarPadre);

        btnRegistrarPa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarPadre();
            }
        });
        btnCancelarPa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminRegisTutorActivity.this,AdminAnunciosGenerales.class);
                startActivity(intent);
            }
        });
    }
    public void registrarPadre(){

        String nombre = nomHijoPa.getText().toString();
        String nombrePadre = nomPadre.getText().toString();
        String cedulaId = ciPadre.getText().toString();
        String correoelectronico = emialPadre.getText().toString();
        String telefono = telfPadre.getText().toString();
        String contraseña = contraseñaPadre.getText().toString();

        //Consulta.getRef().child("Estudiantes").orderByChild("nombre").equalTo("nombre");
        if (TextUtils.isEmpty(nombre)) {
            Toast.makeText(this, "Debe llenar los campos", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(nombrePadre)){
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
            String idpadre = Padres.push().getKey();
            Padres padre = new Padres(idpadre,nombre,nombrePadre,cedulaId,correoelectronico,telefono,contraseña);
            Padres.child("Padres").child(idpadre).setValue(padre);
            Toast.makeText(this,"Registrado",Toast.LENGTH_LONG).show();
            startActivity(new Intent(AdminRegisTutorActivity.this,AdminAnunciosGenerales.class));
        }

    }
}
