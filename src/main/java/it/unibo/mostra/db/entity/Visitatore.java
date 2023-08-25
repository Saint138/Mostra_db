package it.unibo.mostra.db.entity;

public class Visitatore {
    private String cf;
    private String email;
    private String nome;
    private String cognome;

    public Visitatore(String cf, String nome, String cognome, String email) {
        this.cf = cf;
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
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
}
