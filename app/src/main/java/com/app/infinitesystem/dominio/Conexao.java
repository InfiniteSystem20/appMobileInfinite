package com.app.infinitesystem.dominio;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {

    private static final String name = "infiniteMobile.db";
    private static final int version = 3;

    public Conexao(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table cliente(id integer primary key autoincrement, "
                + "nomeCliente varchar(100), emailCliente varchar(50), telefoneCliente varchar(50))");

        db.execSQL("create table servico(idServ integer primary key autoincrement, "
                +"tipoServ varchar(50), nomeServ varchar(100), descricaoServ varchar(700))");

        db.execSQL("create table consultor(idCons integer primary key autoincrement, " +
                "nomeCons varchar(100), telCons varchar(50), emailCons varchar(50), cargoCons varchar(50), senha varchar(50))");

        db.execSQL("create table agenda(idAgen integer primary key autoincrement, " +
                "dataAgen varchar(11), nomeAgenCli varchar(100), localAgen varchar(100), " +
                "nomeAgenCons varchar(100), descriAgen varchar(700))");

        db.execSQL("create table atividade(idAtiv integer primary key autoincrement, " +
                "dataIni varchar(11), dataFim varchar(11), nomeAtivCons varchar(100), " +
                "nomeAtivCli varchar(100), descriAtiv varchar(700))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL("Drop table if exists cliente");
    db.execSQL("Drop table if exists servico");
    db.execSQL("Drop table if exists consultor");
    db.execSQL("Drop table if exists agenda");
    db.execSQL("Drop table if exists atividade");

    onCreate(db);

    }

}
