package com.app.infinitesystem.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.app.infinitesystem.dominio.Conexao;
import com.app.infinitesystem.repositorio.Consultor;

import java.util.ArrayList;
import java.util.List;

public class ConsultorDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public ConsultorDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    //Incluir Consultores
    public long inserir(Consultor consultor){
        ContentValues values = new ContentValues();
        values.put("nomeCons", consultor.getNomeCons());
        values.put("telCons", consultor.getTelCons());
        values.put("emailCons", consultor.getEmailCons());
        values.put("cargoCons", consultor.getCargoCons());
        values.put("senha", consultor.getSenha());
        return banco.insert("consultor", null, values);
    }

    public List<Consultor> obterTodosConsultores(){
        List<Consultor> consultores = new ArrayList<>();
        Cursor cursor3 = banco.query("consultor", new String[]{"idCons","nomeCons",
        "telCons", "emailCons", "cargoCons", "senha"}, null,null,null,
                null,null);
        while (cursor3.moveToNext()){
            Consultor consultor = new Consultor();
            consultor.setIdCons(cursor3.getInt(0));
            consultor.setNomeCons(cursor3.getString(1));
            consultor.setTelCons(cursor3.getString(2));
            consultor.setEmailCons(cursor3.getString(3));
            consultor.setCargoCons(cursor3.getString(4));
            consultor.setSenha(cursor3.getString(5));
            consultores.add(consultor);
        }
        return consultores;
    }

    //Excluir Consultor
    public void excluirCons(Consultor consultor){
        banco.delete("consultor", "idCons = ?", new String[]{consultor.getIdCons().toString()});
    }

    //Atualizar Servico
    public void atualizarCons(Consultor consultor){
        ContentValues values = new ContentValues();
        values.put("nomeCons", consultor.getNomeCons());
        values.put("telCons", consultor.getTelCons());
        values.put("emailCons", consultor.getEmailCons());
        values.put("cargoCons", consultor.getCargoCons());
        values.put("senha", consultor.getSenha());
        banco.update("consultor",values,"idCons = ?", new String[]{consultor.getIdCons().toString()});
    }

}
