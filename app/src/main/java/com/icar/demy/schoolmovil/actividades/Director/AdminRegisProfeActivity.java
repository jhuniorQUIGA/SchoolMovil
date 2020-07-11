package com.icar.demy.schoolmovil.actividades.Director;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.icar.demy.schoolmovil.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class AdminRegisProfeActivity extends AppCompatActivity {
    EditText editNombre, editPater, editMater, editCi, editCorreo, editTelf, editContra;
    Button boton_registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_regis_profe);

        editNombre =(EditText) findViewById(R.id.editNombre);
        editPater = (EditText)findViewById(R.id.editPater);
        editMater =(EditText) findViewById(R.id.editMater);
        editCi = (EditText)findViewById(R.id.editCi);
        editCorreo=(EditText) findViewById(R.id.editCorreo);
        editTelf = (EditText)findViewById(R.id.editTelef);
        editContra= (EditText)findViewById(R.id.editContra);
        boton_registrar =( Button) findViewById(R.id.buttonRegister);

        boton_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutarServicio("http://192.168.1.102:80/phpMovil/personas.php");
            }
        });
    }

    private void ejecutarServicio(String URL){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "OPERATION EXITOSA", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String,String> params=new HashMap<String, String>();
                params.put("nombre", editNombre.getText().toString());
                params.put("paterno", editPater.getText().toString());
                params.put("materno", editMater.getText().toString());
                params.put("ci", editCi.getText().toString());
                params.put("correo", editCorreo.getText().toString());
                params.put("telefono", editTelf.getText().toString());
                params.put("contrasena", editContra.getText().toString());

                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}


