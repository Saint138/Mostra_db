package it.unibo.mostra.db.entity;

public class Visita {
    private String codice_visita;
    private float ora_inizio;
    private String data_visita;
    private int numero_partecipanti;
    private String codice_mostra;
    private String codice_contratto;

    public Visita(String codice_visita, float ora_inizio, String data_visita, int numero_partecipanti,
            String codice_mostra, String codice_contratto) {
        this.codice_contratto = codice_contratto;
        this.codice_mostra = codice_mostra;
        this.ora_inizio = ora_inizio;
        this.codice_visita = codice_visita;
        this.numero_partecipanti = numero_partecipanti;
        this.data_visita = data_visita;
    }

    public String getCodice_visita() {
        return this.codice_visita;
    }

    public float getOra_inizio() {
        return this.ora_inizio;
    }

    public String getData_visita() {
        return this.data_visita;
    }

    public int getNumero_partecipanti(){
        return this.numero_partecipanti;
    }

    public String getCodice_contratto() {
        return this.codice_contratto;
    }

    public String getCodice_mostra() {
        return this.codice_mostra;
    }
}
