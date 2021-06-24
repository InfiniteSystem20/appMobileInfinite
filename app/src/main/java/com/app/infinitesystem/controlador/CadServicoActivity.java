package com.app.infinitesystem.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.app.infinitesystem.R;
import com.app.infinitesystem.dao.ServicoDAO;
import com.app.infinitesystem.repositorio.Servico;
import com.google.android.material.textfield.TextInputEditText;

public class CadServicoActivity extends AppCompatActivity {

    private Button btnVoltarMenuCad;
    private TextInputEditText editTipoServ,editNomeServ,editDescriServ;
    private ServicoDAO dao;
    private Servico servico = null; //atualizar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_servico);

        btnVoltarMenuCad = findViewById(R.id.btnVoltarMenuCad3);

        editTipoServ = findViewById(R.id.editTipoServ);
        editNomeServ = findViewById(R.id.editNomeServ);
        editDescriServ = findViewById(R.id.editDescriServ);
        dao = new ServicoDAO(this);

        //Atualizar
        Intent intent = getIntent();
        if(intent.hasExtra("servico")){
            servico = (Servico) intent.getSerializableExtra("servico");
            editTipoServ.setText(servico.getTipoServ());
            editNomeServ.setText(servico.getNomeServ());
            editDescriServ.setText(servico.getDescricaoServ());
        }


        btnVoltarMenuCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             finish();
            }
        });
    }

    public void salvarServ (View view) {

        if (servico == null) {
            Servico servico = new Servico();
            servico.setTipoServ(editTipoServ.getText().toString());
            servico.setNomeServ(editNomeServ.getText().toString());
            servico.setDescricaoServ(editDescriServ.getText().toString());
            long idServ = dao.inserir(servico);
            Toast.makeText(getApplicationContext(), "Serviço adicionado com sucesso", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            servico.setTipoServ(editTipoServ.getText().toString());
            servico.setNomeServ(editNomeServ.getText().toString());
            servico.setDescricaoServ(editDescriServ.getText().toString());
            dao.atualizarServ(servico);
            Toast.makeText(this, "Serviço foi atualizado", Toast.LENGTH_SHORT).show();
            finish();
        }

    }

}