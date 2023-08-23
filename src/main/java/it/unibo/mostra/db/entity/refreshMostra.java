package it.unibo.mostra.db.entity;

public class RefreshMostra {
    private String nome;
    private String codice_mostra;
    private String città;
    private String data_inizio;
    private String data_fine;
    

    public RefreshMostra(String nome, String codice_mostra,String città,String data_inizio, String data_fine) {
        this.nome = nome;
        this.codice_mostra = codice_mostra;
        this.città = città;
        this.data_inizio = data_inizio;
        this.data_fine = data_fine;
    }

    public String getNome() {
        return nome;
    }

    public String getCodiceMostra() {
        return codice_mostra;
    }

    public String getCittà() {
        return città;
    }
    
    public String getDataInizio() {
        return data_inizio;
    }

    public String getDataFine() {
        return data_fine;
    }
}
