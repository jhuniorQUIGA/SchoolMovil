package com.icar.demy.schoolmovil;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class activity_entrevista_profesor extends AppCompatActivity implements View.OnClickListener {
    Button bfecha, bhora;
    EditText tfecha, thora;
    private int dia, mes, ano, hora, minutos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrevista_profesor3);

        bfecha=(Button)findViewById(R.id.bfecha);
        bhora=(Button)findViewById(R.id.bhora);
        tfecha=(EditText) findViewById(R.id.tfecha);
        thora=(EditText) findViewById(R.id.thora);
        bfecha.setOnClickListener(this);
        bhora.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==bfecha){
            final Calendar c= Calendar.getInstance();
            ano= c.get(Calendar.YEAR);
            mes= c.get(Calendar.MONTH);
            dia= c.get(Calendar.DAY_OF_MONTH);



            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    tfecha.setText(dayOfMonth+"/"+(monthOfYear +1)+"/"+year);
                }
            },ano, mes, dia);
            datePickerDialog.show();
        }if(v==bhora){
            final Calendar c= Calendar.getInstance();
            hora= c.get(Calendar.HOUR_OF_DAY);
            minutos= c.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    thora.setText(hourOfDay+":"+minute);
                }
            },hora,minutos,false);
            timePickerDialog.show();
        }
    }
}
