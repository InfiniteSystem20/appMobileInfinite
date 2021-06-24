package com.app.infinitesystem.controlador;

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
import com.app.infinitesystem.dao.ConsultorDAO;
import com.app.infinitesystem.repositorio.Consultor;
import com.app.infinitesystem.repositorio.Servico;

import java.util.ArrayList;
import java.util.List;

public class ListaConsultorActivity extends AppCompatActivity {

    private ListView listView3;
    private ConsultorDAO dao;
    private List<Consultor> consultores;
    private List<Consultor> consultoresFiltrados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_consultor);

        listView3 = findViewById(R.id.lista_consultor);
        dao = new ConsultorDAO(getApplicationContext());
        consultores = dao.obterTodosConsultores();
        consultoresFiltrados.addAll(consultores);
        ArrayAdapter<Consultor> adaptador = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, consultoresFiltrados);
        listView3.setAdapter(adaptador);

        registerForContextMenu(listView3); //para menu contexto

    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_cons, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.app_bar_search_cons).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                procuraConsultor(s);
                return false;
            }
        });
        return true;

    }
    //Procurando Consultor
    public void procuraConsultor(String nome){
        consultoresFiltrados.clear();
        for(Consultor consultor: consultores){
            if(consultor.getNomeCons().toLowerCase().contains(nome.toLowerCase())){
                consultoresFiltrados.add(consultor);
            }
        }
        listView3.invalidateViews();
    }

    //Menu Contexto Consultor
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_context_cons,menu);
    }

    //Excluindo Serviço
    public void excluirConsultor(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Consultor consultorExcluir = consultoresFiltrados.get(menuInfo.position);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Atenção")
                .setMessage("Realmente deseja excluir?")
                .setNegativeButton("Não",null)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        consultoresFiltrados.remove(consultorExcluir);
                        consultores.remove(consultorExcluir);
                        dao.excluirCons(consultorExcluir);
                        listView3.invalidateViews();
                    }
                }).create();
        dialog.show();
    }

    //Atualizar Consultor
    public void atualizarConsultor(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Consultor consultorAtualizar = consultoresFiltrados.get(menuInfo.position);
        Intent intent = new Intent(getApplicationContext(), CadConsultorActivity.class);
        intent.putExtra("consultor", consultorAtualizar);
        startActivity(intent);
    }

    //Acessando Cadastro
    public void cadastrarCons(MenuItem item){
        Intent telaCadCons = new Intent(getApplicationContext(), CadConsultorActivity.class);
        startActivity(telaCadCons);
    }

    @Override
    public void onResume() {
        super.onResume();
        consultores = dao.obterTodosConsultores();
        consultoresFiltrados.clear();
        consultoresFiltrados.addAll(consultores);
        listView3.invalidateViews();
    }

}