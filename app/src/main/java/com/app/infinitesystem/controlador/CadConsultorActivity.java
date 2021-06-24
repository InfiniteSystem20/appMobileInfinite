package com.app.infinitesystem.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.app.infinitesystem.R;
import com.app.infinitesystem.dao.ConsultorDAO;
import com.app.infinitesystem.repositorio.Consultor;
import com.google.android.material.textfield.TextInputEditText;

public class CadConsultorActivity extends AppCompatActivity {

    private Button btnVoltarMenuCad;
    private TextInputEditText editNomeCons, editTelCons,editEmailCons,editCargo,
            editSenha;
    private ConsultorDAO dao;
    private Consultor consultor = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_consultor);

        btnVoltarMenuCad = findViewById(R.id.btnVoltarMenuCad2);
        editNomeCons = findViewById(R.id.editNomeCons);
        editTelCons = findViewById(R.id.editTelCons);
        editEmailCons = findViewById(R.id.editEmailCons);
        editCargo = findViewById(R.id.editCargo);
        editSenha = findViewById(R.id.editSenha);
        dao = new ConsultorDAO(this);

        //Atualizar
        Intent intent = getIntent();
        if(intent.hasExtra("consultor")){
            consultor = (Consultor) intent.getSerializableExtra("consultor");
            editNomeCons.setText(consultor.getNomeCons());
            editTelCons.setText(consultor.getTelCons());
            editEmailCons.setText(consultor.getEmailCons());
            editCargo.setText(consultor.getCargoCons());
            editSenha.setText(consultor.getSenha());
        }

        btnVoltarMenuCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void salvarCons(View view){
        if(consultor == null) {
            Consultor consultor = new Consultor();
            consultor.setNomeCons(editNomeCons.getText().toString());
            consultor.setTelCons(editTelCons.getText().toString());
            consultor.setEmailCons(editEmailCons.getText().toString());
            consultor.setCargoCons(editCargo.getText().toString());
            consultor.setSenha(editSenha.getText().toString());
            long idCons = dao.inserir(consultor);
            Toast.makeText(getApplicationContext(), "Consultor adicionado com sucesso", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            consultor.setNomeCons(editNomeCons.getText().toString());
            consultor.setTelCons(editTelCons.getText().toString());
            consultor.setEmailCons(editEmailCons.getText().toString());
            consultor.setCargoCons(editCargo.getText().toString());
            consultor.setSenha(editSenha.getText().toString());
            dao.atualizarCons(consultor);
            Toast.makeText(this, "Consultor foi atualizado", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

}