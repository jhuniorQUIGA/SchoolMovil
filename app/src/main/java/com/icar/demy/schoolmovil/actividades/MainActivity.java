package com.icar.demy.schoolmovil.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.icar.demy.schoolmovil.R;

public class MainActivity extends AppCompatActivity {

    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = (Button) findViewById(R.id.botoncito1);

        boton.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,AdminAnunciosGenerales.class));
            }
        });
    }


}
