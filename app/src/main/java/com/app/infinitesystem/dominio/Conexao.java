package com.app.infinitesystem.dominio;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {

    private static final String name = "infiniteMobile.db";
    private static final int version = 1;

    public Conexao(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table cliente(id integer primary key autoincrement, "
                + "nomeCliente varchar(50), emailCliente varchar(50), telefoneCliente varchar(50))");

        db.execSQL("create table servico(idServ integer primary key autoincrement, "
                +"tipoServ varchar(50), nomeServ varchar(50), descricaoServ varchar(700))");

        db.execSQL("create table consultor(idCons integer primary key autoincrement," +
                "nomeCons varchar(50), telCons varchar(50), emailCons varchar(50), " +
                "cargoCons varchar(50), senha varchar(50))");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
