package com.app.infinitesystem.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

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

    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_cli, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.app_bar_search_cli).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                procuraCliente(s);
                return false;
            }
        });

        return true;
    }

    //Procurando Clientes
    public void procuraCliente(String nome){
        clientesFiltrados.clear();
        for(Cliente cliente: clientes){
            if(cliente.getNomeCliente().toLowerCase().contains(nome.toLowerCase())){
                clientesFiltrados.add(cliente);
            }
        }

        listView.invalidateViews();
    }



    //acessando tela cadastrar
    public void cadastrarCli(MenuItem item){
        Intent telaCadCli = new Intent(getApplicationContext(), CadClienteActivity.class);
        startActivity(telaCadCli);
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