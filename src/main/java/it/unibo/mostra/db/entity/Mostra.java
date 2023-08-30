package it.unibo.mostra.db.entity;

public class Mostra {
    private String nome;
    private String città;
    private Integer numeroOpere;
    private String codiceMostra;
    private int valore;
    private String dataInizio;
    private String dataFine;
    private String nomeArte;
    private Float media;

    public Mostra(String nome, String città, int numeroOpere, String dataInizio, String codiceMostra,
            int valore, String dataFine) {
        this.città = città;
        this.nome = nome;
        this.numeroOpere = numeroOpere;
        this.codiceMostra = codiceMostra;
        this.valore = valore;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public Mostra(String nome,String città, String dataInizio, String dataFine, String codiceMostra, int valore,
            int numeroOpere,String nome_arte) {
        this.città = città;
        this.nome = nome;
        this.numeroOpere = numeroOpere;
        this.codiceMostra = codiceMostra;
        this.valore = valore;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.nomeArte = nome_arte;
    }

    public Mostra(String nome, int valore) {
        this.valore = valore;
        this.nome = nome;

    }

    
    public Mostra(String nome, Float media) {
        this.nome = nome;
        this.media = media;
    }
    
    public String getNomeArte() {
        return nomeArte;
    }
    public String getNome(){
        return nome;
    }
    public String getCittà(){
        return città;
    }

    public String getDataInizio() {
        return dataInizio;
    }
    public String getDataFine(){
        return dataFine;
    }
    public Integer getNumeroOpere (){
        return numeroOpere;
    }
    public String getCodiceMostra(){
        return codiceMostra;
    }
    public Integer getValore(){
        return valore;
    }
    
    
    public Float getMedia() {
        return media;
    }
}
