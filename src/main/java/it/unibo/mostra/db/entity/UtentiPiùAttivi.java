package it.unibo.mostra.db.entity;

public class UtentiPiùAttivi {
    private String nome;
    private String cognome;
    private Integer conteggioRecensioni;

    public UtentiPiùAttivi(String nome, String cognome, Integer rec){
        this.nome = nome;
        this.cognome = cognome;
        this.conteggioRecensioni = rec;
    }

    public String getNome() {
        return this.cognome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public Integer getNumeroRecensioni(){
        return this.conteggioRecensioni;
    }
}
