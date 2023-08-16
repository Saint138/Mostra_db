package it.unibo.mostra.db.entity;

public class Presenza {
    private String nomeArte;
    private String nomeOpera;
    private String codiceMostra;

    public Presenza(String artista, String opera, String mostra){
        this.codiceMostra = mostra;
        this.nomeArte = artista;
        this.nomeOpera = opera;
    }

    public String getArtista(){
        return nomeArte;
    }
      public String getOpera(){
        return nomeOpera;
    }
      public String getCodiceMostra(){
        return codiceMostra;
    }
}
