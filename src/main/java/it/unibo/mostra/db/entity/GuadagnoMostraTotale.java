package it.unibo.mostra.db.entity;

public class GuadagnoMostraTotale {
    private String nome;
    private String valore;

    public GuadagnoMostraTotale(String nome, String valore) {
        this.valore = valore;
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public String getValore() {
        return this.valore;
    }
}
