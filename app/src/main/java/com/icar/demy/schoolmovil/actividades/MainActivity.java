package com.icar.demy.schoolmovil.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.icar.demy.schoolmovil.ProfesorActividadDelEstudianteActivity;
import com.icar.demy.schoolmovil.R;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

  /*  private EditText edittext2;
    private EditText edittext;
    private Button botoncito1;

    private String email= "";
    private String contraseña= "";

   */ Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

   /*
        edittext2 = (EditText) findViewById(R.id.editText2);
        edittext = (EditText) findViewById(R.id.editText);
        botoncito1 = (Button) findViewById(R.id.botoncito1);


     */  boton = (Button) findViewById(R.id.botoncito1);

        boton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, AdminAnunciosGenerales.class));
            }
        });

/*    botoncito1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            email = edittext2.getText().toString();
            contraseña = edittext.getText().toString();
            if(!email.isEmpty() && contraseña.isEmpty()){
                    loginUser();
            }else{
                String text;
                Toast.makeText(MainActivity.this,  text="complete los campos",Toast.LENGTH_SHORT).show();
            }
        }
    });
    }

private void loginUser(){}
    }
*/
        }
}
