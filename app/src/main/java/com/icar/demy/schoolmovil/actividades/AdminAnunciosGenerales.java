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
import com.icar.demy.schoolmovil.ObservacionesProfesorActivity;
import com.icar.demy.schoolmovil.R;
import com.icar.demy.schoolmovil.Registros.Anuncios;
import com.icar.demy.schoolmovil.Registros.Estudiantes;


public class AdminAnunciosGenerales extends AppCompatActivity {
    Spinner regist;
    Button irRegistros;

    Button enviarAnun;
    EditText anuncio;
    Spinner personalAnu;

    Integer pos ;

    private DatabaseReference Anuncios;
// ...

    //String[] items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_admin_anuncios_generales );

        Anuncios = FirebaseDatabase.getInstance().getReference("Anuncios");

        irRegistros = (Button) findViewById(R.id.irRegistros) ;
        regist = (Spinner) findViewById(R.id.registros1);
        /*items = getResources().getStringArray(R.array.registros);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        regist.setAdapter(adapter);*/
        irRegistros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos = regist.getSelectedItemPosition();
                if (pos == 0){
                    startActivity(new Intent(AdminAnunciosGenerales.this, AdminRegisProfeActivity.class));
                }else if (pos==1){
                    startActivity(new Intent(AdminAnunciosGenerales.this, AdminRegisEstudianteActivity.class));
                }else if (pos==2){
                    startActivity(new Intent(AdminAnunciosGenerales.this, AdminRegisTutorActivity.class));
                }else{
                    startActivity(new Intent(AdminAnunciosGenerales.this, AdminCrearMateriaActivity.class));
                }
            }
        });

        anuncio = (EditText) findViewById(R.id.anunciosDireccion);
        personalAnu = (Spinner) findViewById(R.id.spinPersonal);
        enviarAnun = (Button) findViewById(R.id.btnEnviarAnuncio);

        enviarAnun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarAnuncios();
            }
        });
    }

    public void registrarAnuncios (){
        String anu = anuncio.getText().toString();
        String personalAnuncio = personalAnu.getSelectedItem().toString();
        if (TextUtils.isEmpty(anu)) {
            Toast.makeText(this, "Debe llenar los campos", Toast.LENGTH_LONG).show();
        }else{
            String idAnuncio = Anuncios.push().getKey();
            Anuncios anuncio = new Anuncios(idAnuncio,anu,personalAnuncio);
            Anuncios.child("Anuncios").child(idAnuncio).setValue(anuncio);
            Toast.makeText(this,"Registrado",Toast.LENGTH_LONG).show();
        }
    }
}
