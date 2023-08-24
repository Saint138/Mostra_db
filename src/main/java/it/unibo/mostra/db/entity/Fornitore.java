package it.unibo.mostra.db.entity;

public class Fornitore {
    private String codiceFornitore;
    private String nome;
    private String email;
    private String numeroTelefono;

    public Fornitore(String codiceFornitore, String nome, String email, String numeroTelefono) {
        this.nome = nome;
        this.codiceFornitore = codiceFornitore;
        this.email = email;
        this.numeroTelefono = numeroTelefono;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getCodiceFornitore() {
        return codiceFornitore;
    }
}
