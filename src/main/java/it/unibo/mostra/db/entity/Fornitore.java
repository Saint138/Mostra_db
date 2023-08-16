package it.unibo.mostra.db.entity;

public class Fornitore {
    private String codice_fornitore;
    private String nome;
    private String cognome;
    private String email;
    private String numero_telefono;

    public Fornitore(String codice_fornitore, String nome, String cognome, String email, String numero_telefono) {
        this.nome = nome;
        this.codice_fornitore = codice_fornitore;
        this.cognome = cognome;
        this.email = email;
        this.numero_telefono = numero_telefono;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public String getCodice_fornitore() {
        return codice_fornitore;
    }
}
