package com.app.infinitesystem.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.app.infinitesystem.dominio.Conexao;
import com.app.infinitesystem.repositorio.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public ClienteDAO(Context context){
        conexao =  new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    //Incluir Cliente
    public long inserir(Cliente cliente) {
        ContentValues values = new ContentValues();
        values.put("nomeCliente", cliente.getNomeCliente());
        values.put("emailCliente", cliente.getEmailCliente());
        values.put("telefoneCliente", cliente.getTelefoneCliente());
        return banco.insert("cliente", null, values);
    }

    //Array para mostrar como lista
    public List<Cliente> obterTodos(){
        List<Cliente> clientes = new ArrayList<>();
        Cursor cursor = banco.query("cliente", new String[]{"id","nomeCliente","emailCliente","telefoneCliente"},
                null,null,null,null,null);
        while (cursor.moveToNext()){
            Cliente cli = new Cliente();
            cli.setId(cursor.getInt(0));
            cli.setNomeCliente(cursor.getString(1));
            cli.setEmailCliente(cursor.getString(2));
            cli.setTelefoneCliente(cursor.getString(3));
            clientes.add(cli);
        }
        return clientes;
    }

    //Excluir Cliente
    public void excluirCli(Cliente cliente){
        banco.delete("cliente","id = ?",new String[]{cliente.getId().toString()});
    }

    //Atualizar Cliente

    public void atualizarCli(Cliente cliente){
        ContentValues values = new ContentValues();
        values.put("nomeCliente", cliente.getNomeCliente());
        values.put("emailCliente", cliente.getEmailCliente());
        values.put("telefoneCliente", cliente.getTelefoneCliente());
        banco.update("cliente",values,"id = ?", new String[]{cliente.getId().toString()});
}



}
