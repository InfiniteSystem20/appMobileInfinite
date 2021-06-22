package com.app.infinitesystem.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.infinitesystem.R;

public class MainActivity extends AppCompatActivity {

    Button buttonCadastrar;
    Button btnSobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonCadastrar = findViewById(R.id.btnCadHome);
        btnSobre = findViewById(R.id.btnSobre);

        //Evento para acessar a Tela de Sobre
        btnSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaSobre = new Intent(getApplicationContext(), SobreActivity.class);
                finish();
                startActivity(telaSobre);
            }
        });

        //Evento para acessar a Tela de Cadastrar
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaCadastrar = new Intent(getApplicationContext(), MenuCadActivity.class);
                startActivity(telaCadastrar);
            }
        });
    }
}