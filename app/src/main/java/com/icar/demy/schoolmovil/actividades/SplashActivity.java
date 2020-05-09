package com.icar.demy.schoolmovil.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.icar.demy.schoolmovil.R;

public class SplashActivity extends AppCompatActivity {
    Button siguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        siguiente = (Button)findViewById(R.id.button2);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente = new Intent(SplashActivity.this, AdminRegisEstudianteActivity.class);
                startActivity(siguiente);
            }
        });

    }
}
