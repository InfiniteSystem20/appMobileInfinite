package com.app.infinitesystem.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.infinitesystem.R;

public class MenuCadActivity extends AppCompatActivity {

    Button btnCadCli;
    Button btnCadServ;
    Button btnCadCons;
    Button btnVoltarMain;
    Button btnCadAgenda;
    Button btnCadAtvi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cadastrar);

        btnCadCli = findViewById(R.id.btnCadCli);
        btnCadCons = findViewById(R.id.btnCadCons);
        btnCadServ = findViewById(R.id.btnCadServ);
        btnVoltarMain = findViewById(R.id.btnVoltarMain);
        btnCadAgenda = findViewById(R.id.btnCadAgenda);
        btnCadAtvi = findViewById(R.id.btnCadAtvi);

        //Evento para acessar a Tela de Cad Atividade
        btnCadAtvi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cadastroAtividade= new Intent(getApplicationContext(), CadAtividadeActivity.class);
                startActivity(cadastroAtividade);
            }
        });

        //Evento para acessar a Tela de Cad Agenda
        btnCadAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cadastroAgenda = new Intent(getApplicationContext(), CadAgendaActivity.class);
                startActivity(cadastroAgenda);
            }
        });

        //Evento para voltar para a Main
        btnVoltarMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent voltarMain = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(voltarMain);
            }
        });

        //Evento para acessar a Tela de Lista Cliente
        btnCadCli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listaCliente = new Intent(getApplicationContext(), CadClienteActivity.class);
                startActivity(listaCliente);
            }
        });

        //Evento para acessar a Tela de Cad Consultor

        btnCadCons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cadastroConsultor = new Intent(getApplicationContext(), CadConsultorActivity.class);
                startActivity(cadastroConsultor);
            }
        });

        //Evento para acessar a Tela de Cad Serviço
        btnCadServ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cadastroServico = new Intent(getApplicationContext(), CadServicoActivity.class);
                startActivity(cadastroServico);
            }
        });
    }
}