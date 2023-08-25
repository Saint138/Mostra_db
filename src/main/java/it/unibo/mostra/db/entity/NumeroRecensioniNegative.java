package it.unibo.mostra.db.entity;

public class NumeroRecensioniNegative {
    private String nome;
    private int totale;

    public NumeroRecensioniNegative(String nome, int totale) {
        this.nome = nome;
        this.totale = totale;
    }

    public String getNome() {
        return nome;
    }

    public int getTotale() {
        return totale;
    }

}
