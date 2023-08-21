package it.unibo.mostra.db.entity;

public class Recensione {
    private String cod;
    private String nome;
    private String cognome;
    private String CF;
    private Integer valutazione;
    private String commento;
    private String codMostra;
    private String nomeMostra;
    private String dataRecensione;

    public Recensione (String cod, String Cf, String commento, String codMostra, Integer val, String dataRecensione){
        this.CF = Cf;
        this.cod = cod;
        this.codMostra = codMostra;
        this.valutazione = val;
        this.commento = commento;
        this.dataRecensione = dataRecensione;
    }
    public Recensione (String nome,String cognome, String Cod, String commento, Integer val,  String dataRecensione){
        this.cod = cod;
        this.codMostra = codMostra;
        this.valutazione = val;
        this.commento = commento;
        this.nome = nome;
        this.cognome = cognome;
        this.dataRecensione = dataRecensione;
    }
    public Recensione (String nome,String cognome, String Cod,String nomeMostra, String commento, Integer val,  String dataRecensione){
        this.cod = cod;
        this.codMostra = codMostra;
        this.valutazione = val;
        this.commento = commento;
        this.nome = nome;
        this.cognome = cognome;
        this.dataRecensione = dataRecensione;
    }
    public Recensione (String nome,String cognome, String Cod,String nomeMostra, String commento, Integer val){
        this.cod = cod;
        this.codMostra = codMostra;
        this.valutazione = val;
        this.commento = commento;
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getCodRecensione(){
        return cod;
    }
    public String getCF(){
        return CF;
    }
    public Integer getValutazione(){
        return valutazione;
    }
    public String getCommento(){
        return commento;
    }
    public String getCodMostra(){
        return codMostra;
    }
    public String getNome(){
        return nome;
    }
    public String getCognome(){
        return cognome;
    }
    public String getNomeMostra(){
        return nomeMostra;
    }
   
    public String getData(){
        return dataRecensione;
    }
}
