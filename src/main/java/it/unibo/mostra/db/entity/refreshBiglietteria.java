package it.unibo.mostra.db.entity;

public class RefreshBiglietteria {
    private String nome;
    private String codiceVisita;
    private String dataInizio;
    private String dataFine;
    
    public RefreshBiglietteria(String nome, String codiceVisita, String dataInizio, String dataFine) {
        this.nome = nome;
        this.codiceVisita = codiceVisita;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public String getNome() {
        return nome;
    }

    public String getCodiceVisita() {
        return codiceVisita;
    }

    public String getDataInizio() {
        return dataInizio;
    }

    public String getDataFine() {
        return dataFine;
    }
    
}
