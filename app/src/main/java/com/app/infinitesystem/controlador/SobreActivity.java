package com.app.infinitesystem.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.infinitesystem.R;

public class SobreActivity extends AppCompatActivity {

    private Button btnHome;
    private Button btnLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        btnHome = findViewById(R.id.btnHome2);
        btnLocal = findViewById(R.id.btnLocal2);

        //Evento para acessar tela home
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaHome = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(telaHome);
            }
        });

        btnLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaLocal = new Intent(getApplicationContext(), LocalActivity.class);
                startActivity(telaLocal);
            }
        });
    }
}