package it.unibo.mostra.db.entity;

public class Mostra {
    private String nome;
    private String città;
    private Integer numeroOpere;
    private final String codiceMostra;
    private Integer valore;
    private String data_inizio;
    private String data_fine;

    public Mostra(String nome, String città, Integer numeroOpere, String data_inizio, String codiceMostra, Integer valore,String data_fine ){
        this.città = città;
        this.nome = nome;
        this.numeroOpere = numeroOpere;
        this.codiceMostra = codiceMostra;
        this.valore = valore;
        this.data_inizio = data_inizio;
        this.data_fine = data_fine;
    }

    public String getNome(){
        return nome;
    }
    public String getCitta(){
        return città;
    }

    public String getDataInizio() {
        return data_inizio;
    }
    public String getDataFine(){
        return data_fine;
    }
    public Integer getNumeroOpere (){
        return numeroOpere;
    }
    public String getCodiceMostra(){
        return codiceMostra;
    }
    public Integer getVal(){
        return valore;
    }

    

}
