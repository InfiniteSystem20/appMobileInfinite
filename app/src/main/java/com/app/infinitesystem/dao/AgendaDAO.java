package com.app.infinitesystem.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.app.infinitesystem.dominio.Conexao;
import com.app.infinitesystem.repositorio.Agenda;
import com.app.infinitesystem.repositorio.Atividade;

import java.util.ArrayList;
import java.util.List;

public class AgendaDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public AgendaDAO(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    //Incluir Agendamento
    public long inserir(Agenda agenda){
        ContentValues values = new ContentValues();
        values.put("dataAgen", agenda.getDataAgen());
        values.put("nomeAgenCli", agenda.getNomeAgenCli());
        values.put("localAgen", agenda.getLocalAgen());
        values.put("nomeAgenCons", agenda.getNomeAgenCons());
        values.put("descriAgen", agenda.getDescriAgen());
        return banco.insert("agenda", null, values);
    }

    public List<Agenda> obterTodosAgendamentos() {
        List<Agenda> agendamento = new ArrayList<>();
        Cursor cursor5 = banco.query("agenda", new String[]{"idAgen","dataAgen",
        "nomeAgenCli","localAgen","nomeAgenCons","descriAgen"}, null,null
        ,null,null,null);
        while (cursor5.moveToNext()){
            Agenda agen = new Agenda();
            agen.setIdAgen(cursor5.getInt(0));
            agen.setDataAgen(cursor5.getString(1));
            agen.setNomeAgenCli(cursor5.getString(2));
            agen.setLocalAgen(cursor5.getString(3));
            agen.setNomeAgenCons(cursor5.getString(4));
            agen.setDescriAgen(cursor5.getString(5));
            agendamento.add(agen);
        }
        return agendamento;
    }

    //Excluir Agendamento
    public void excluirAgen(Agenda agenda){
        banco.delete("agenda", "idAgen = ?", new String[] {agenda.getIdAgen().toString()});
    }

    //Atualizar Agendamento
    public void atualizarAgen(Agenda agenda){
        ContentValues values = new ContentValues();
        values.put("dataAgen", agenda.getDataAgen());
        values.put("nomeAgenCli", agenda.getNomeAgenCli());
        values.put("localAgen", agenda.getLocalAgen());
        values.put("nomeAgenCons", agenda.getNomeAgenCons());
        values.put("descriAgen", agenda.getDescriAgen());
        banco.update("agenda", values,"idAgen = ?", new String[]{agenda.getIdAgen().toString()});
    }
}
