package it.unibo.mostra.db.entity;

public class refreshBiglietteria {
    private String nome;
    private String codice_visita;
    private Float prezzo;
    private String data_inizio;
    private String data_fine;
    
    public refreshBiglietteria(String nome, String codice_visita, String data_inizio, String data_fine, Float prezzo) {
        this.nome = nome;
        this.codice_visita = codice_visita;
        this.data_inizio = data_inizio;
        this.data_fine = data_fine;
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public String getCodiceVisita() {
        return codice_visita;
    }

    public String getDataInizio() {
        return data_inizio;
    }

    public String getDataFine() {
        return data_fine;
    }

    public Float getPrezzo() {
        return prezzo;
    }
    
}
