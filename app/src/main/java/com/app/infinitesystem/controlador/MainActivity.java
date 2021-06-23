package com.app.infinitesystem.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.infinitesystem.R;

public class MainActivity extends AppCompatActivity {


    private Button btnSobre;
    private Button btnCadCli;
    private Button btnCadServ;
    private Button btnCadCons;
    private Button btnVoltarMain;
    private Button btnCadAgenda;
    private Button btnCadAtvi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSobre = findViewById(R.id.btnSobre);

        btnCadCli = findViewById(R.id.btnCadCli);
        btnCadCons = findViewById(R.id.btnCadCons);
        btnCadServ = findViewById(R.id.btnCadServ);
        btnVoltarMain = findViewById(R.id.btnVoltarMain);
        btnCadAgenda = findViewById(R.id.btnCadAgenda);
        btnCadAtvi = findViewById(R.id.btnCadAtvi);
    /*
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
                Intent listaCliente = new Intent(getApplicationContext(), ListaClienteActivity.class);
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

        //Evento para acessar a Tela de Sobre
        btnSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaSobre = new Intent(getApplicationContext(), SobreActivity.class);
                finish();
                startActivity(telaSobre);
            }
        });

     */






    }
}