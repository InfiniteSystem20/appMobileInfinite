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
import com.app.infinitesystem.repositorio.Cliente;
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

    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_serv, menu);

        //Procurando pela String no Botão
        SearchView searchView = (SearchView) menu.findItem(R.id.app_bar_search_serv).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }

    //Procurando Serviços
    public void procuraSerico(String nome){
        servicosFiltrados.clear();
        for(Servico servico: servicos){
            if (servico.getNomeServ().toLowerCase().contains(nome.toLowerCase())){
                servicosFiltrados.add(servico);
            }
        }
        listView2.invalidateViews();
    }


    //Menu Contexto Servico
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_cont_serv,menu);
    }

    //Excluindo Serviço
    public void excluirServico(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Servico servicoExcluir = servicosFiltrados.get(menuInfo.position);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Atenção")
                .setMessage("Realmente deseja excluir?")
                .setNegativeButton("Não",null)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        servicosFiltrados.remove(servicoExcluir);
                        servicos.remove(servicoExcluir);
                        dao.excluirServ(servicoExcluir);
                        listView2.invalidateViews();
                    }
                }).create();
        dialog.show();
    }

    //Atualizar Serviço
    public void atualizarServico(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Servico servicoAtualizar = servicosFiltrados.get(menuInfo.position);
        Intent intent = new Intent(getApplicationContext(), CadServicoActivity.class);
        intent.putExtra("servico", servicoAtualizar);
        startActivity(intent);
    }

    //Acessando Cadastro
    public void cadastrarServ(MenuItem item){
        Intent telaCadServ = new Intent(getApplicationContext(), CadServicoActivity.class);
        startActivity(telaCadServ);
    }

    @Override
    public void onResume(){
        super.onResume();
        servicos = dao.obterTodosServicos();
        servicosFiltrados.clear();
        servicosFiltrados.addAll(servicos);
        listView2.invalidateViews();
    }

}