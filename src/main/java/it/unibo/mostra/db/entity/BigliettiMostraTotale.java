package it.unibo.mostra.db.entity;

public class BigliettiMostraTotale {
    private String nome;
    private Integer totale;
    
    public BigliettiMostraTotale(String nome, Integer totale) {
        this.totale = totale;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Integer getTotale() {
        return totale;
    }
}
