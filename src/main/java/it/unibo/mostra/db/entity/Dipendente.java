package it.unibo.mostra.db.entity;

public class Dipendente {
    private String matricola;
    private String nome;
    private String cognome;
    private String email;
    private boolean guardia;
    private boolean commesso_souvenir;
    private boolean guida;
    private boolean magazzieniere;
    private boolean receptionist;

    public Dipendente(String matricola, String nome, String cognome, String email, boolean guardia, boolean guida,
            boolean commesso_souvenir, boolean receptionist, boolean magazzieniere) {
        this.cognome = cognome;
        this.commesso_souvenir = commesso_souvenir;
        this.email = email;
        this.magazzieniere = magazzieniere;
        this.guardia = guardia;
        this.guida = guida;
        this.nome = nome;
        this.receptionist = receptionist;
        this.matricola = matricola;
    }
    
    public String getNome() {
        return nome;
    }

    public String isMatricola() {
        return matricola;
    }

    public boolean isMagazziniere() {
        return magazzieniere;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public boolean isGuida() {
        return guida;
    }

    public boolean isGuardia() {
        return guardia;
    }

    public boolean isCommessoSouvenir() {
        return commesso_souvenir;
    }

    public boolean isReceptionist() {
        return receptionist;
    }
    
}

