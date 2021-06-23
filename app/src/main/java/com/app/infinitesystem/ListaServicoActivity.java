package com.app.infinitesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.app.infinitesystem.dao.ServicoDAO;
import com.app.infinitesystem.repositorio.Servico;

import java.util.ArrayList;
import java.util.List;

public class ListaServicoActivity extends AppCompatActivity {

    private ListView listView2;
    private ServicoDAO dao;
    private List<Servico> servicos;
    private List<Servico> servicosFiltrados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_servico);

        listView2 = findViewById(R.id.lista_servico);
        dao = new ServicoDAO(getApplicationContext());
        servicos = dao.obterTodosServicos();
        servicosFiltrados.addAll(servicos);
        ArrayAdapter<Servico> adaptador = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1, servicosFiltrados);
        listView2.setAdapter(adaptador);

    }
}