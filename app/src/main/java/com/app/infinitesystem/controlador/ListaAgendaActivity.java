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
import com.app.infinitesystem.dao.AgendaDAO;
import com.app.infinitesystem.repositorio.Agenda;
import com.app.infinitesystem.repositorio.Servico;

import java.util.ArrayList;
import java.util.List;

public class ListaAgendaActivity extends AppCompatActivity {

    private ListView listView5;
    private AgendaDAO dao;
    private List<Agenda> agendamentos;
    private List<Agenda> agendaFiltrada = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_agenda);

        listView5 = findViewById(R.id.lista_agenda);
        dao = new AgendaDAO(getApplicationContext());
        agendamentos = dao.obterTodosAgendamentos();
        agendaFiltrada.addAll(agendamentos);
        ArrayAdapter<Agenda> adaptador = new ArrayAdapter<>(getApplication(),android.R.layout.simple_list_item_1, agendaFiltrada);
        listView5.setAdapter(adaptador);

        registerForContextMenu(listView5);// para menu contexto

    }

    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_agen, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.app_bar_search_ativ).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                procuraAgendamento(s);
                return false;
            }
        });
        return true;
    }

    //Procurando Agendamento
    public void procuraAgendamento(String data){
        agendaFiltrada.clear();
        for (Agenda agenda: agendamentos){
            if(agenda.getDataAgen().toLowerCase().contains(data.toLowerCase())){
                agendaFiltrada.add(agenda);
            }
        }
        listView5.invalidateViews();
    }

    //Menu Contexto Agendamento
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_cont_agen, menu);
    }

    public void excluirAgendamento(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Agenda agendamentoExcluir = agendaFiltrada.get(menuInfo.position);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Atenção")
                .setMessage("Realmente deseja excluir?")
                .setNegativeButton("Não",null)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        agendaFiltrada.remove(agendamentoExcluir);
                        agendamentos.remove(agendamentoExcluir);
                        dao.excluirAgen(agendamentoExcluir);
                        listView5.invalidateViews();
                    }
                }).create();
        dialog.show();
    }

    //Atualizar Agendamento
    public void atualizarAgendamento(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Agenda agendaAtualizar = agendaFiltrada.get(menuInfo.position);
        Intent intent = new Intent(getApplicationContext(), CadAgendaActivity.class);
        intent.putExtra("agenda", agendaAtualizar);
        startActivity(intent);
    }

    //Acessando Cadastro
    public void cadastrarAgen(MenuItem item){
        Intent telaCadAgen = new Intent(getApplicationContext(), CadAgendaActivity.class);
        startActivity(telaCadAgen);
    }

    @Override
    public void onResume(){
        super.onResume();
        agendamentos = dao.obterTodosAgendamentos();
        agendaFiltrada.clear();
        agendaFiltrada.addAll(agendamentos);
        listView5.invalidateViews();
    }
}