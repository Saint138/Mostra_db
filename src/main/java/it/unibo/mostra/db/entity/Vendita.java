package it.unibo.mostra.db.entity;

public class Vendita {
    private String codiceVendita;
    private String dataVendita;
    private float importo;
    private String codiceFornitore;

    public Vendita(String codiceVendita, String dataVendita, float importo, String codiceFornitore) {
        this.codiceFornitore = codiceFornitore;
        this.codiceVendita = codiceVendita;
        this.importo = importo;
        this.dataVendita = dataVendita;
    }

    public String getCodiceVendita() {
        return this.codiceVendita;
    }

    public String getCodiceFornitore() {
        return this.codiceFornitore;
    }

    public String getDataVendita() {
        return this.dataVendita;
    }
    
    public float getImporto() {
        return this.importo;
    }
}
