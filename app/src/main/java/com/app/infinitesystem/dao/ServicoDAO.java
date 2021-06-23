package com.app.infinitesystem.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.app.infinitesystem.dominio.Conexao;
import com.app.infinitesystem.repositorio.Servico;

import java.util.ArrayList;
import java.util.List;

public class ServicoDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public ServicoDAO(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    //Incluir Serviços
    public long inserir(Servico servico) {
        ContentValues values = new ContentValues();
        values.put("tipoServ", servico.getTipoServ());
        values.put("nomeServ", servico.getNomeServ());
        values.put("descricaoServ", servico.getDescricaoServ());
        return banco.insert("servico", null, values);
    }

    public List<Servico> obterTodosServicos() {
        List<Servico> servicos = new ArrayList<>();
        Cursor cursor2 = banco.query("servico", new String[]{"idServ", "tipoServ", "nomeServ", "descricaoServ"},
                null, null, null, null, null);
        while (cursor2.moveToNext()) {
            Servico serv = new Servico();
            serv.setIdServ(cursor2.getInt(0));
            serv.setTipoServ(cursor2.getString(1));
            serv.setNomeServ(cursor2.getString(2));
            serv.setDescricaoServ(cursor2.getString(3));
            servicos.add(serv);

        }
        return servicos;

    }

    //Excluir Servico
    public void excluirServ(Servico servico){
        banco.delete("servico", "idServ = ?", new String[]{servico.getIdServ().toString()});
    }

    //Atualizar Servico
    public void atualizarServ(Servico servico){
        ContentValues values = new ContentValues();
        values.put("tipoServ", servico.getTipoServ());
        values.put("nomeServ", servico.getNomeServ());
        values.put("descricaoServ", servico.getDescricaoServ());
        banco.update("servico",values, "idServ = ?", new String[]{servico.getIdServ().toString()});
    }

}
