package com.app.infinitesystem.controlador;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.app.infinitesystem.R;
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