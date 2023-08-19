package it.unibo.mostra.db.entity;

public class Mostra {
    private String nome;
    private String città;
    private Integer numeroOpere;
    private final String codiceMostra;
    private Integer valore;
    private String dataInizio;

    public Mostra(String nome, String città, Integer numeroOpere, String data, String codiceMostra, Integer valore ){
        this.città = città;
        this.nome = nome;
        this.numeroOpere = numeroOpere;
        this.codiceMostra = codiceMostra;
        this.valore = valore;
        this.dataInizio = data;
    }

    public String getNome(){
        return nome;
    }
    public String getCitta(){
        return città;
    }
    public String getData(){
        return dataInizio;
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
