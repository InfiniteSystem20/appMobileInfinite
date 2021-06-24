package com.app.infinitesystem.repositorio;

import java.io.Serializable;

public class Agenda implements Serializable {

    private Integer idAgen;
    private String dataAgen;
    private String nomeAgenCli;
    private  String localAgen;
    private String nomeAgenCons;
    private String descriAgen;

    public Integer getIdAgen() {
        return idAgen;
    }

    public void setIdAgen(Integer idAgen) {
        this.idAgen = idAgen;
    }

    public String getDataAgen() {
        return dataAgen;
    }

    public void setDataAgen(String dataAgen) {
        this.dataAgen = dataAgen;
    }

    public String getNomeAgenCli() {
        return nomeAgenCli;
    }

    public void setNomeAgenCli(String nomeAgenCli) {
        this.nomeAgenCli = nomeAgenCli;
    }

    public String getLocalAgen() {
        return localAgen;
    }

    public void setLocalAgen(String localAgen) {
        this.localAgen = localAgen;
    }

    public String getNomeAgenCons() {
        return nomeAgenCons;
    }

    public void setNomeAgenCons(String nomeAgenCons) {
        this.nomeAgenCons = nomeAgenCons;
    }

    public String getDescriAgen() {
        return descriAgen;
    }

    public void setDescriAgen(String descriAgen) {
        this.descriAgen = descriAgen;
    }

    @Override
    public String toString() { return dataAgen;}

}
