package com.app.infinitesystem.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.infinitesystem.R;

public class MainActivity extends AppCompatActivity {


    private Button btnSobre;
    private Button btnCliente;
    private Button btnServico;
    private Button btnConsultor;
    private Button btnAgenda;
    private Button btnAtivi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSobre = findViewById(R.id.btnSobre);

        btnCliente = findViewById(R.id.btnCliente);
        btnConsultor = findViewById(R.id.btnConsultor);
        btnServico = findViewById(R.id.btnServico);
        btnAgenda = findViewById(R.id.btnAgenda);
        btnAtivi = findViewById(R.id.btnAtivi);

        //Evento para acessar Tela de Consultor
        btnConsultor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaConsultor = new Intent(getApplicationContext(), ListaConsultorActivity.class);
                startActivity(telaConsultor);
            }
        });

        //Evento para acessar Tela de Serviço
        btnServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaServico = new Intent(getApplicationContext(), ListaServicoActivity.class);
                startActivity(telaServico);
            }
        });

        //Evento para acessar Tela de Cliente
        btnCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaCliente = new Intent(getApplicationContext(), ListaClienteActivity.class);
                startActivity(telaCliente);
            }
        });

        //Evento para acessar a Tela Sobre
        btnSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaSobre = new Intent(getApplicationContext(), SobreActivity.class);
                startActivity(telaSobre);
            }
        });








    }
}