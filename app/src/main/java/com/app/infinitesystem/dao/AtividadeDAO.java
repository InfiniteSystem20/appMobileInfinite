package com.app.infinitesystem.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.app.infinitesystem.dominio.Conexao;
import com.app.infinitesystem.repositorio.Atividade;

import java.util.ArrayList;
import java.util.List;

public class AtividadeDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public AtividadeDAO(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    //Incluir Atividades
    public long inserir(Atividade atividade){
        ContentValues values = new ContentValues();
        values.put("dataIni", atividade.getDataIni());
        values.put("dataFim", atividade.getDataFim());
        values.put("nomeAtivCons", atividade.getNomeAtivCons());
        values.put("nomeAtivCli", atividade.getNomeAtivCli());
        values.put("descriAtiv", atividade.getDescriAtiv());
        return banco.insert("atividade", null,values);
    }

    public List<Atividade> obterTodasAtividades(){
        List<Atividade> atividades = new ArrayList<>();
        Cursor cursor4 = banco.query("atividade", new String[]{"idAtiv","dataIni"
        ,"dataFim","nomeAtivCons","nomeAtivCli","descriAtiv"}, null,null,
                null,null,null);
        while (cursor4.moveToNext()){
            Atividade ativ = new Atividade();
            ativ.setIdAtiv(cursor4.getInt(0));
            ativ.setDataIni(cursor4.getString(1));
            ativ.setDataFim(cursor4.getString(2));
            ativ.setNomeAtivCons(cursor4.getString(3));
            ativ.setNomeAtivCli(cursor4.getString(4));
            ativ.setDescriAtiv(cursor4.getString(5));
            atividades.add(ativ);
        }
        return atividades;
    }

    //Excluir Atividade
    public void excluirAtiv(Atividade atividade){
        banco.delete("atividade","idAtiv = ?", new String[]{atividade.getIdAtiv().toString()});
    }

    //Atualizar Atividade
    public void atualizarAtiv(Atividade atividade){
        ContentValues values = new ContentValues();
        values.put("dataIni", atividade.getDataIni());
        values.put("dataFim", atividade.getDataFim());
        values.put("nomeAtivCons", atividade.getNomeAtivCons());
        values.put("nomeAtivCli", atividade.getNomeAtivCli());
        values.put("descriAtiv", atividade.getDescriAtiv());
        banco.update("atividade", values, "idAtiv = ?", new String[]{atividade.getIdAtiv().toString()});
    }

}
