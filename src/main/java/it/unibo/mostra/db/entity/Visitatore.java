package it.unibo.mostra.db.entity;

public class Visitatore {
    private String CF;
    private String email;
    private String nome;
    private String cognome;

    public Visitatore(String CF, String email, String nome, String cognome) {
        this.CF = CF;
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
    }
    
    public String getCF() {
        return this.CF;
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
