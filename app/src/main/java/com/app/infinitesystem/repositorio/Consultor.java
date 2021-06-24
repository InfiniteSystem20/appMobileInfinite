package com.app.infinitesystem.repositorio;

import java.io.Serializable;

public class Consultor implements Serializable {

    private Integer idCons;
    private String nomeCons;
    private String telCons;
    private String emailCons;
    private String cargoCons;
    private String senha;

    public Integer getIdCons() {
        return idCons;
    }

    public void setIdCons(Integer idCons) {
        this.idCons = idCons;
    }

    public String getNomeCons() {
        return nomeCons;
    }

    public void setNomeCons(String nomeCons) {
        this.nomeCons = nomeCons;
    }

    public String getTelCons() {
        return telCons;
    }

    public void setTelCons(String telCons) {
        this.telCons = telCons;
    }

    public String getEmailCons() {
        return emailCons;
    }

    public void setEmailCons(String emailCons) {
        this.emailCons = emailCons;
    }

    public String getCargoCons() {
        return cargoCons;
    }

    public void setCargoCons(String cargoCons) {
        this.cargoCons = cargoCons;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() { return nomeCons; }

}
