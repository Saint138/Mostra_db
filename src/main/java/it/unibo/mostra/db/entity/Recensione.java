package it.unibo.mostra.db.entity;

public class Recensione {
    private String cod;
    private String nome;
    private String cognome;
    private String cf;
    private int valutazione;
    private String commento;
    private String codiceMostra;
    private String nomeMostra;
    private String dataRecensione;
    private String email;

    public Recensione (String nome,String cognome, String cod, int val, String commento  ,String dataRecensione,String nomeMostra){
        this.cod = cod;
        this.nomeMostra = nomeMostra;
        this.valutazione = val;
        this.commento = commento;
        this.nome = nome;
        this.cognome = cognome;
        this.dataRecensione = dataRecensione;
    }

    public Recensione (String nome,String cognome, String cod,  String commento, int val,  String dataRecensione){
        this.nome = nome ;
        this.cognome = cognome;
        this.cod = cod;
        this.commento = commento; 
        this.valutazione = val ;
        this.dataRecensione = dataRecensione;
    }

    public Recensione(String nome, String cognome, String nomeMostra, String cod, int val, String commento,
            String dataRecensione) {
        this.nome = nome;
        this.cognome = cognome;
        this.nomeMostra = nomeMostra;
        this.cod = cod;
        this.valutazione = val;
        this.commento = commento;
        this.dataRecensione = dataRecensione;
    }

    public Recensione(String email, String nomeMostra, int valutazione, String commento) {
        this.email = email;
        this.nomeMostra = nomeMostra;
        this.valutazione = valutazione;
        this.commento = commento;

    }

    public String getCodiceRecensione(){
        return cod;
    }
    public String getCf(){
        return cf;
    }
    public int getValutazione(){
        return valutazione;
    }
    public String getCommento(){
        return commento;
    }
    public String getCodiceMostra(){
        return codiceMostra;
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
   
    public String getData() {
        return dataRecensione;
    }
    
    public String getEmail() {
        return email;
    }
}
