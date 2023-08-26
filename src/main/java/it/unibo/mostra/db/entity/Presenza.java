package it.unibo.mostra.db.entity;

public class Presenza {
    private String nomeArte;
    private String nomeOpera;
    private String codiceMostra;
    private String nomeMostra;

    public Presenza(String artista, String opera, String mostra) {
      this.codiceMostra = mostra;
      this.nomeArte = artista;
      this.nomeOpera = opera;
    }

    public Presenza(String artista, String opera, String nomeMostra,String codiceMostra) {
      this.codiceMostra = codiceMostra;
      this.nomeArte = artista;
      this.nomeOpera = opera;
      this.nomeMostra = nomeMostra;
    }

    public String getNomeMostra() {
      return nomeMostra;
    }

    public String getNomeArte(){
        return nomeArte;
    }
      public String getNomeOpera(){
        return nomeOpera;
    }
      public String getCodiceMostra(){
        return codiceMostra;
    }
}
