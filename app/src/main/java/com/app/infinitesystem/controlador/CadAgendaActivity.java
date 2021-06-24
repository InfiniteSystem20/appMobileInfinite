package com.app.infinitesystem.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.app.infinitesystem.R;
import com.app.infinitesystem.dao.AgendaDAO;
import com.app.infinitesystem.repositorio.Agenda;
import com.google.android.material.textfield.TextInputEditText;

public class CadAgendaActivity extends AppCompatActivity {

    private Button btnVoltarMenuCad;
    private TextInputEditText editDataAgen, editNomeAgenCli, editLocalAgen, editNomeAgenCons
            , editDescriAgen;
    private AgendaDAO dao;
    private Agenda agenda = null; //atualizar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_agenda);

        btnVoltarMenuCad = findViewById(R.id.btnVoltarMenuCad5);
        editDataAgen = findViewById(R.id.editDataAgen);
        editNomeAgenCli = findViewById(R.id.editNomeAgenCli);
        editLocalAgen = findViewById(R.id.editLocalAgen);
        editNomeAgenCons = findViewById(R.id.editNomeAgenCons);
        editDescriAgen = findViewById(R.id.editDescriAgen);
        dao = new AgendaDAO(this);

        //Atualizar
        Intent intent = getIntent();
        if(intent.hasExtra("agenda")){
            agenda = (Agenda) intent.getSerializableExtra("agenda");
            editDataAgen.setText(agenda.getDataAgen());
            editNomeAgenCli.setText(agenda.getNomeAgenCli());
            editLocalAgen.setText(agenda.getLocalAgen());
            editNomeAgenCons.setText(agenda.getNomeAgenCons());
            editDescriAgen.setText(agenda.getDescriAgen());
        }

        btnVoltarMenuCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void salverAgen(View view){
        if(agenda == null){
            Agenda agenda = new Agenda();
            agenda.setDataAgen(editDataAgen.getText().toString());
            agenda.setNomeAgenCli(editNomeAgenCli.getText().toString());
            agenda.setLocalAgen(editLocalAgen.getText().toString());
            agenda.setNomeAgenCons(editNomeAgenCons.getText().toString());
            agenda.setDescriAgen(editDescriAgen.getText().toString());
            long idAgen = dao.inserir(agenda);
            Toast.makeText(getApplicationContext(), "Agenda adicionada com sucesso", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            agenda.setDataAgen(editDataAgen.getText().toString());
            agenda.setNomeAgenCli(editNomeAgenCli.getText().toString());
            agenda.setLocalAgen(editLocalAgen.getText().toString());
            agenda.setNomeAgenCons(editNomeAgenCons.getText().toString());
            agenda.setDescriAgen(editDescriAgen.getText().toString());
            dao.atualizarAgen(agenda);
            Toast.makeText(this, "Agenda foi atualizada", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}