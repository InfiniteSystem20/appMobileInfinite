package com.app.infinitesystem.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.app.infinitesystem.R;
import com.app.infinitesystem.dao.AtividadeDAO;
import com.app.infinitesystem.repositorio.Atividade;
import com.google.android.material.textfield.TextInputEditText;

public class CadAtividadeActivity extends AppCompatActivity {

    private Button btnVoltarMenuCad;
    private TextInputEditText editDataIni, editDataFim, editNomeAtivCons,
            editNomeAtivCli,editDescriAtiv;
    private AtividadeDAO dao;
    private Atividade atividade = null; //atualizar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_atividade);

        btnVoltarMenuCad = findViewById(R.id.btnVoltarMenuCad4);

        editDataIni = findViewById(R.id.editDataIni);
        editDataFim = findViewById(R.id.editDataFim);
        editNomeAtivCons = findViewById(R.id.editNomeAtivCons);
        editNomeAtivCli = findViewById(R.id.editNomeAtivCli);
        editDescriAtiv = findViewById(R.id.editDescriAtiv);
        dao = new AtividadeDAO(this);

        //Atualizar
        Intent intent = getIntent();
        if (intent.hasExtra("atividade")){
            atividade = (Atividade) intent.getSerializableExtra("atividade");
            editDataIni.setText(atividade.getDataIni());
            editDataFim.setText(atividade.getDataFim());
            editNomeAtivCons.setText(atividade.getNomeAtivCons());
            editNomeAtivCli.setText(atividade.getNomeAtivCli());
            editDescriAtiv.setText(atividade.getDescriAtiv());
        }

        btnVoltarMenuCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void salvarAtiv (View view) {
        if (atividade == null) {
            Atividade atividade = new Atividade();
            atividade.setDataIni(editDataIni.getText().toString());
            atividade.setDataFim(editDataFim.getText().toString());
            atividade.setNomeAtivCons(editNomeAtivCons.getText().toString());
            atividade.setNomeAtivCli(editNomeAtivCli.getText().toString());
            atividade.setDescriAtiv(editDescriAtiv.getText().toString());
            long idAtiv = dao.inserir(atividade);
            Toast.makeText(this, "Atividade inserida com sucesso", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            atividade.setDataIni(editDataIni.getText().toString());
            atividade.setDataFim(editDataFim.getText().toString());
            atividade.setNomeAtivCons(editNomeAtivCons.getText().toString());
            atividade.setNomeAtivCli(editNomeAtivCli.getText().toString());
            atividade.setDescriAtiv(editDescriAtiv.getText().toString());
            dao.atualizarAtiv(atividade);
            Toast.makeText(this, "Atividade foi atualizada", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}