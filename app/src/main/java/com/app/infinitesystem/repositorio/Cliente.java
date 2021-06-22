package com.app.infinitesystem.repositorio;

import java.io.Serializable;

public class Cliente implements Serializable {

    private Integer id;
    private String nomeCliente;
    private String emailCliente;
    private String telefoneCliente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }
/*
    @Override
    public String toString(){
        return nome;
    }

 */

}
