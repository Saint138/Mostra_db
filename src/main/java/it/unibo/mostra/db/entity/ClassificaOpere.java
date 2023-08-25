package it.unibo.mostra.db.entity;

public class ClassificaOpere {
    private int valore;
    private String nome;
    
    public ClassificaOpere(String nome, int valore) {
        this.nome = nome;
        this.valore = valore;
    }

    public String getNome() {
        return nome;
    }

    public int getValore() {
        return valore;
    }
}
