package main.java.it.unibo.mostra.db.entity;

import main.java.it.unibo.mostra.db.api.Personale;

public abstract class AbstractPersonale implements Personale {
    private Integer stipendio;
    private String codiceContratto;
    private String matricola;

    public AbstractPersonale(Integer stipendio, String codContratto, String mat ){
        this.stipendio = stipendio;
        this.codiceContratto = codContratto;
        this.matricola = mat;
    }
    
    public Integer getStipendio(){
        return stipendio;
    }

    public String getMatricola(){
        return matricola;
    }

    public String getCodiceContratto(){
        return codiceContratto;
    }


}
