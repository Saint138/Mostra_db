package it.unibo.mostra.db.entity;

public class Visitatore {
    private String cf;
    private String email;
    private String nome;
    private String cognome;
    private int numeroMostre;

    public Visitatore(String cf, String nome, String cognome, String email) {
        this.cf = cf;
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
    }

    public Visitatore(String nome, String cognome, String cf, int numeroMostre) {
        this.cf = cf;
        this.cognome = cognome;
        this.numeroMostre = numeroMostre;
        this.nome = nome;
    }
    
    public String getCf() {
        return this.cf;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public String getEmail() {
        return this.email;
    }

    public int getNumeroMostre() {
        return numeroMostre;
    }
}
