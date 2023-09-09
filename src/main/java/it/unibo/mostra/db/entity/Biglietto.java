package it.unibo.mostra.db.entity;

public class Biglietto {
    private String data_biglietto;
    private String codice_biglietto;
    private String CF;
    private String codice_visita;

    public Biglietto(String data_biglietto, String codice_biglietto , String CF, String codice_visita) {
        this.data_biglietto = data_biglietto;
        this.codice_biglietto = codice_biglietto;
        this.CF = CF;
        this.codice_visita = codice_visita;
    }

    
    public String getData_biglietto() {
        return data_biglietto;
    }
    
    public String getCodice_biglietto() {
        return codice_biglietto;
    }

    public String getCF() {
        return CF;
    }

    public String getCodice_visita() {
        return codice_visita;
    }
}
