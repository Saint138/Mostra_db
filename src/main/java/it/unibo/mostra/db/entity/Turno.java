package it.unibo.mostra.db.entity;

public class Turno {

    private String codiceTurno;
    private String dataTurno;
    private String oraInizio;
    private String oraFine;
    private String codiceMostra;

    public Turno(String codiceTurno, String dataTurno, String oraInizio, String oraFine, String codiceMostra) {
        this.codiceTurno = codiceTurno;
        this.dataTurno = dataTurno;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
        this.codiceMostra = codiceMostra;
    }
    
    public String getCodiceTurno() {
        return this.codiceTurno;
    }

    public String getDataTurno() {
        return this.dataTurno;
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
