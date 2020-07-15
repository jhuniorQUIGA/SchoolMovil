package com.icar.demy.schoolmovil.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.icar.demy.schoolmovil.R;

public class AdminAnunciosGenerales extends AppCompatActivity {

    Spinner regist;
    String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_admin_anuncios_generales );

        regist = (Spinner) findViewById(R.id.registros1);
        items = getResources().getStringArray(R.array.registros);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        regist.setAdapter(adapter);
    }
}
