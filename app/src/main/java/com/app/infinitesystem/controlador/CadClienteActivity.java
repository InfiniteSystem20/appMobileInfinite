package com.app.infinitesystem.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.app.infinitesystem.R;
import com.app.infinitesystem.dao.ClienteDAO;
import com.app.infinitesystem.repositorio.Cliente;
import com.google.android.material.textfield.TextInputEditText;

public class CadClienteActivity extends AppCompatActivity {

    private Button btnVoltarMenuCad;
    private TextInputEditText editNomeCli, editEmailCli, editTelefoneCli;
    private ClienteDAO dao;
    private Cliente cliente = null; //atualizar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);

        btnVoltarMenuCad = findViewById(R.id.btnVoltarMenuCad2);

        editNomeCli = findViewById(R.id.editNomeCli);
        editEmailCli = findViewById(R.id.editEmailCli);
        editTelefoneCli = findViewById(R.id.editTelefoneCli);
        dao = new ClienteDAO(this);

        //Atualizar
        Intent intent = getIntent();
        if (intent.hasExtra("cliente")){
            cliente = (Cliente) intent.getSerializableExtra("cliente");
            editNomeCli.setText(cliente.getNomeCliente());
            editEmailCli.setText(cliente.getEmailCliente());
            editTelefoneCli.setText(cliente.getTelefoneCliente());
        }


        btnVoltarMenuCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    public void salvarCli (View view){

        if (cliente == null) {
            Cliente cliente = new Cliente();
            cliente.setNomeCliente(editNomeCli.getText().toString());
            cliente.setEmailCliente(editEmailCli.getText().toString());
            cliente.setTelefoneCliente(editTelefoneCli.getText().toString());
            long id = dao.inserir(cliente);
            Toast.makeText(this, "Cliente inserido com sucesso", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            cliente.setNomeCliente(editNomeCli.getText().toString());
            cliente.setEmailCliente(editEmailCli.getText().toString());
            cliente.setTelefoneCliente(editTelefoneCli.getText().toString());
            dao.atualizarCli(cliente);
            Toast.makeText(this, "Cliente foi atualizado", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}