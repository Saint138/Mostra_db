package it.unibo.mostra.db.entity;

public class Turno {

    private String codice_turno;
    private String data_turno;
    private String ora_inizio;
    private String ora_fine;
    private String codice_mostra;

    public Turno(String codice_turno, String data_turno, String ora_inizio, String ora_fine, String codice_mostra) {
        this.codice_turno = codice_turno;
        this.data_turno = data_turno;
        this.ora_inizio = ora_inizio;
        this.ora_fine = ora_fine;
        this.codice_mostra = codice_mostra;
    }
    
    public String getCodiceTurno() {
        return this.codice_turno;
    }

    public String getDataTurno() {
        return this.data_turno;
    }

    public String getOraInizio() {
        return this.ora_inizio;
    }

    public String getOraFine() {
        return this.ora_fine;
    }
    public String getCodiceMostra() {
        return this.codice_mostra;
    }
}
