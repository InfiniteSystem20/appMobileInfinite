package com.app.infinitesystem.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.infinitesystem.R;

public class cadastro_consultor extends AppCompatActivity {

    Button btnVoltarMenuCad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_consultor);

        btnVoltarMenuCad = findViewById(R.id.btnVoltarMenuCad2);

        btnVoltarMenuCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent voltarMenu = new Intent( getApplicationContext(),Menu_Cadastrar.class);
                startActivity(voltarMenu);
            }
        });
    }
}