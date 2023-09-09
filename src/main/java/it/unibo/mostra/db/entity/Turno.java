package it.unibo.mostra.db.entity;

public class Turno {

    private String codiceTurno;
    private String oraInizio;
    private String oraFine;
    private String codiceMostra;

    public Turno(String codiceTurno, String oraInizio, String oraFine, String codiceMostra) {
        this.codiceTurno = codiceTurno;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
        this.codiceMostra = codiceMostra;
    }
    
    public String getCodiceTurno() {
        return this.codiceTurno;
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
}
