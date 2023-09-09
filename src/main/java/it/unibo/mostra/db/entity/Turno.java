package it.unibo.mostra.db.entity;

public class Turno {

    private String codiceTurno;
    private String oraInizio;
    private String oraFine;
    private String codiceMostra;
    private int stipendio;
    private String nomeMostra;
    private String ruolo;

    public Turno(String codiceTurno, String oraInizio, String oraFine, String codiceMostra) {
        this.codiceTurno = codiceTurno;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
        this.codiceMostra = codiceMostra;
    }

    public Turno(String codiceTurno, String oraInizio, String oraFine, String nomeMostra,String ruolo, int stipendio) {
         this.codiceTurno = codiceTurno;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
        this.nomeMostra = nomeMostra;
        this.stipendio = stipendio;
        this.ruolo = ruolo;
    }
    
    public String getCodiceTurno() {
        return this.codiceTurno;
    }

    public String getRuolo() {
        return ruolo;
    }

    public String getOraInizio() {
        return this.oraInizio;
    }

    public String getOraFine() {
        return this.oraFine;
    }

    public String getCodiceMostra() {
        return this.codiceMostra;
    }
    
    public String getNomeMostra() {
        return nomeMostra;
    }

    public int getStipendio() {
        return stipendio;
    }
}
