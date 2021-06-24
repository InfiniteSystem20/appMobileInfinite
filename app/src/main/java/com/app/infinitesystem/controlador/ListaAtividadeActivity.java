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
import com.app.infinitesystem.dao.AtividadeDAO;
import com.app.infinitesystem.repositorio.Atividade;

import java.util.ArrayList;
import java.util.List;

public class ListaAtividadeActivity extends AppCompatActivity {

    private ListView listView4;
    private AtividadeDAO dao;
    private List<Atividade> atividades;
    private List<Atividade> atividadesFiltradas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_atividade);

        listView4 = findViewById(R.id.lista_atividade);
        dao = new AtividadeDAO(getApplicationContext());
        atividades = dao.obterTodasAtividades();
        atividadesFiltradas.addAll(atividades);
        ArrayAdapter<Atividade> adaptador = new ArrayAdapter<>(getApplicationContext()
        ,android.R.layout.simple_list_item_1, atividadesFiltradas);
        listView4.setAdapter(adaptador);

        registerForContextMenu(listView4); //para menu contexto

    }

    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_ativ, menu);

        //Procurando pela String no botão
        SearchView searchView = (SearchView) menu.findItem(R.id.app_bar_search_ativ).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                procuraAtividade(s);
                return false;
            }
        });
        return true;
    }

    //Procurando Atividade
    public void procuraAtividade(String data){
        atividadesFiltradas.clear();
        for(Atividade atividade: atividades){
            if(atividade.getDataIni().toLowerCase().contains(data.toLowerCase())){
                atividadesFiltradas.add(atividade);
            }
        }
        listView4.invalidateViews();
    }

    //Menu Contexto Atividade
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_cont_ativ, menu);
    }

    //Excluindo Atividade
    public void excluirAtividade(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Atividade atividadeExcluir = atividadesFiltradas.get(menuInfo.position);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Atenção")
                .setMessage("Realmente deseja excluir?")
                .setNegativeButton("Não",null)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        atividadesFiltradas.remove(atividadeExcluir);
                        atividades.remove(atividadeExcluir);
                        dao.excluirAtiv(atividadeExcluir);
                        listView4.invalidateViews();
                    }
                }).create();
        dialog.show();
    }

    //Atualizar Atividade
    public void atualizarAtividade(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Atividade atividadeAtualizar = atividadesFiltradas.get(menuInfo.position);
        Intent intent = new Intent(getApplicationContext(), CadAtividadeActivity.class);
        intent.putExtra("atividade", atividadeAtualizar);
        startActivity(intent);
    }

    //Acessando Cadastro
    public void cadastrarAtivi(MenuItem item){
        Intent telaCadAtiv = new Intent(getApplicationContext(), CadAtividadeActivity.class);
        startActivity(telaCadAtiv);
    }

    @Override
    public void onResume(){
        super.onResume();
        atividades = dao.obterTodasAtividades();
        atividadesFiltradas.clear();
        atividadesFiltradas.addAll(atividades);
        listView4.invalidateViews();
    }

}