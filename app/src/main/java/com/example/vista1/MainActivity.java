package com.example.vista1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText txtnom, txttel;

    TextView lblnom, lbltel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtnom = findViewById(R.id.v1etNom);
        txttel = findViewById(R.id.v1etTel);
        lblnom = findViewById(R.id.v1tvNom);
        lbltel = findViewById(R.id.v1tvTel);
    }

    public int validar(){
        int b=0;
        if (!txtnom.getText().toString().isEmpty() && !txttel.getText().toString().isEmpty()){
            b=1;

        } else if (txtnom.getText().toString().isEmpty()) {
            Toast.makeText(this, "falta nombre", Toast.LENGTH_SHORT).show();
            txtnom.requestFocus();

        }else{
            Toast.makeText(this, "falta telefono", Toast.LENGTH_SHORT).show();
            txttel.requestFocus();
        }
        return b;
    }
    public void borrar (){
        txtnom.setText("");
        txttel.setText("");
        txtnom.requestFocus();


    }

    public void onClick(View view) {
        Intent abrir = null;
        if (view.getId()==R.id.v1btnCargar){
            if (validar()==1){
                lblnom.setText("Nombre: "+txtnom.getText().toString());
                lbltel.setText("Telefono:"+txttel.getText().toString());
            }

        }
        if (view.getId()==R.id.v1btnEnviar){
            if (validar()==1){
                abrir = new Intent(MainActivity.this, Desarrollador.class);
                Bundle datos = new Bundle();
                datos.putString("nom",txtnom.getText().toString());
                datos.putString("tel",txttel.getText().toString());
                abrir.putExtras(datos);
                startActivity(abrir);
                borrar();
            }
        }
        if (view.getId()==R.id.v1btnAdivinar){
            abrir = new Intent(MainActivity.this, Adivina.class);
            startActivity(abrir);



        }
    }
}