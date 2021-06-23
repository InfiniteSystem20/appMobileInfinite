package com.app.infinitesystem.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.infinitesystem.ListaServicoActivity;
import com.app.infinitesystem.R;

public class MenuConsActivity extends AppCompatActivity {

    private Button btnConsCli;
    private Button btnConsServ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cons);


        btnConsCli = findViewById(R.id.btnConsCli);
        btnConsServ = findViewById(R.id.btnConsServ);

        //Evento para Consulta Cliente
        btnConsCli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent consultarCliente = new Intent(getApplicationContext(), ListaClienteActivity.class);
                startActivity(consultarCliente);
            }
        });

        //Evento para Consulta Servico
        btnConsServ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent consultarServico = new Intent(getApplicationContext(), ListaServicoActivity.class);
                startActivity(consultarServico);
            }
        });

    }
}