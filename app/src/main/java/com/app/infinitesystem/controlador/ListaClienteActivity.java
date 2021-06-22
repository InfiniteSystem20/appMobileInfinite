package com.app.infinitesystem.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.app.infinitesystem.R;
import com.app.infinitesystem.controlador.CadClienteActivity;
import com.app.infinitesystem.dao.ClienteDAO;
import com.app.infinitesystem.repositorio.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ListaClienteActivity extends AppCompatActivity {

    private ListView listView;
    private ClienteDAO dao;
    private List<Cliente> clientes;
    private List<Cliente> clientesFiltrados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cliente);

        listView = findViewById(R.id.lista_cliente);
        dao = new ClienteDAO(getApplicationContext());
        clientes = dao.obterTodos();
        clientesFiltrados.addAll(clientes);
        ArrayAdapter<Cliente> adaptador = new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1, clientesFiltrados);
        listView.setAdapter(adaptador);
    }

    @Override
    public void onResume(){
        super.onResume();
        clientes = dao.obterTodos();
        clientesFiltrados.clear();
        clientesFiltrados.addAll(clientes);
        listView.invalidateViews();
    }





}