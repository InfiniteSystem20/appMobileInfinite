package com.app.infinitesystem.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.app.infinitesystem.dominio.Conexao;
import com.app.infinitesystem.repositorio.Cliente;

public class ClienteDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public ClienteDAO(Context context){
        conexao =  new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Cliente cliente) {
        ContentValues values = new ContentValues();
        values.put("nomeCliente", cliente.getNomeCliente());
        values.put("emailCliente", cliente.getEmailCliente());
        values.put("telefoneCliente", cliente.getTelefoneCliente());
        return banco.insert("cliente", null, values);
    }





}
