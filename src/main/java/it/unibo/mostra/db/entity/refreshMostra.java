package it.unibo.mostra.db.entity;

public class RefreshMostra {
    private String nome;
    private String codiceMostra;
    private String città;
    private String dataInizio;
    private String dataFine;
    

    public RefreshMostra(String nome, String codiceMostra,String città,String dataInizio, String dataFine) {
        this.nome = nome;
        this.codiceMostra = codiceMostra;
        this.città = città;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public String getNome() {
        return nome;
    }

    public String getCodiceMostra() {
        return codiceMostra;
    }

    public String getCittà() {
        return città;
    }
    
    public String getDataInizio() {
        return dataInizio;
    }

    public String getDataFine() {
        return dataFine;
    }
}
