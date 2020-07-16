package com.icar.demy.schoolmovil.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.icar.demy.schoolmovil.ObservacionesProfesorActivity;
import com.icar.demy.schoolmovil.R;


public class AdminAnunciosGenerales extends AppCompatActivity {
    Spinner regist;
    Button irRegistros;
    Integer pos ;
    //String[] items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_admin_anuncios_generales );

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
    }
}
