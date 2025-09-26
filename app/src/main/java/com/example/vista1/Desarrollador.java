package com.example.vista1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Desarrollador extends AppCompatActivity {
    TextView lbltel, lblnom;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_desarrollador);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lblnom = findViewById(R.id.v2tvNom);
        lbltel = findViewById(R.id.v2tvTel);
        btn1 = findViewById(R.id.v2btnRetornar);
        Bundle datos = this.getIntent().getExtras();
        lblnom.setText("Nombre: "+datos.getString("nom"));
        lbltel.setText("Telefono: "+datos.getString("tel"));
        //1 FORMA DE BOTONES - ANONIMA
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });


    }
}