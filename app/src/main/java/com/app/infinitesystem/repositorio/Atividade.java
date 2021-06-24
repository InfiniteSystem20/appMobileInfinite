package com.app.infinitesystem.repositorio;

public class Atividade {

    private Integer idAtiv;
    private String dataIni;
    private String dataFim;
    private String nomeAtivCons;
    private String nomeAtivCli;
    private String descriAtiv;

    public Integer getIdAtiv() {
        return idAtiv;
    }

    public void setIdAtiv(Integer idAtiv) {
        this.idAtiv = idAtiv;
    }

    public String getDataIni() {
        return dataIni;
    }

    public void setDataIni(String dataIni) {
        this.dataIni = dataIni;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getNomeAtivCons() {
        return nomeAtivCons;
    }

    public void setNomeAtivCons(String nomeAtivCons) {
        this.nomeAtivCons = nomeAtivCons;
    }

    public String getNomeAtivCli() {
        return nomeAtivCli;
    }

    public void setNomeAtivCli(String nomeAtivCli) {
        this.nomeAtivCli = nomeAtivCli;
    }

    public String getDescriAtiv() {
        return descriAtiv;
    }

    public void setDescriAtiv(String descriAtiv) {
        this.descriAtiv = descriAtiv;
    }

    @Override
    public String toString() { return dataIni;}

}
