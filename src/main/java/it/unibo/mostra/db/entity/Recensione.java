package it.unibo.mostra.db.entity;

public class Recensione {
    private String cod;
    private String CF;
    private Integer valutazione;
    private String commento;
    private String codMostra;

    public Recensione (String cod, String Cf, String commento, String codMostra, Integer val){
        this.CF = Cf;
        this.cod = cod;
        this.codMostra = codMostra;
        this.valutazione = val;
        this.commento = commento;
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
   
}
