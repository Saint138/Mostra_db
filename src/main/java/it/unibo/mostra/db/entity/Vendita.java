package it.unibo.mostra.db.entity;

public class Vendita {
    private String codice_vendita;
    private String data_vendita;
    private float importo;
    private String fornitore;

    public Vendita(String codice_vendita, String data_vendita, float importo, String fornitore) {
        this.fornitore = fornitore;
        this.codice_vendita = codice_vendita;
        this.importo = importo;
        this.data_vendita = data_vendita;
    }

    public String getCodice_vendita() {
        return this.codice_vendita;
    }

    public String getfornitore() {
        return this.fornitore;
    }

    public String getData_vendita() {
        return this.data_vendita;
    }
    
    public float getImporto() {
        return this.importo;
    }
}
