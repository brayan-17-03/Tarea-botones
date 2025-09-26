package com.example.vista1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Adivina extends AppCompatActivity implements View.OnClickListener {
    EditText txtnum;
    Button btn1, btn2,btn3;
    TextView lblint;
    int L,ng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adivina);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtnum = findViewById(R.id.v3etNum);
        lblint = findViewById(R.id.v3tvIn);
        btn1 = findViewById(R.id.v3btnAnali);
        btn2 = findViewById(R.id.v3btnRetor);
        btn3 = findViewById(R.id.v3btnVolver);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

        iniciarJuego();

    }

    public void iniciarJuego(){
        btn1.setEnabled(true);
        btn3.setEnabled(false);
        txtnum.setEnabled(true);
        btn3.setVisibility(View.GONE);

        txtnum.setText("");
        txtnum.requestFocus();



        L=1;
        ng = (int) (Math.random() * 10) + 1;
        lblint.setText(L+ " intento de 5, " + ng);
        lblint.requestFocus();
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.v3btnVolver) {
            iniciarJuego();
            return;
        }

        if(view.getId()==R.id.v3btnRetor) {
            finish();
            return;
        }
            if(view.getId()==R.id.v3btnAnali){
                if(txtnum.getText().toString().isEmpty()){
                    Toast.makeText(this, "falta núnero", Toast.LENGTH_SHORT).show();
                    txtnum.requestFocus();
                }else{
                    if(Integer.parseInt(txtnum.getText().toString())<1 || Integer.parseInt(txtnum.getText().toString())>10) {
                        Toast.makeText(this, "Número inválido, digite entre 1 y 10", Toast.LENGTH_SHORT).show();
                        txtnum.setText("");
                        txtnum.requestFocus();
                }else{
                        if (Integer.parseInt(txtnum.getText().toString())==ng){
                            Toast.makeText(this, "Gano", Toast.LENGTH_LONG).show();
                            finjuego();

                        }else {
                            Toast.makeText(this, "no es el numero", Toast.LENGTH_SHORT).show();
                            L++;
                            if(L<=5){
                                lblint.setText(L+ " intento");
                                txtnum.setText("");
                                txtnum.requestFocus();
                            }else{
                                Toast.makeText(this, "¡Perdió! El número era " + ng, Toast.LENGTH_LONG).show();
                                finjuego();
                            }

                        }
                    }
                }
            }
    }
    public void finjuego(){
        txtnum.setEnabled(false);
        btn1.setEnabled(false);
        btn3.setEnabled(true);
        btn3.setVisibility(View.VISIBLE);

    }
}