package it.unibo.mostra.db.entity;

public class Opera {
    private String nomeArte;
    private String nomeOpera;
    private String codiceVendita;
    private String annoRealizzazione;
    private String dimensioni;
    private String tecnica;
    private String descrizione;

    public Opera(String nomeArte, String nomeOpera, String codiceVendita, String annoRealizzazione, String dimensioni, String tecnica, String descrizione ){
        this.annoRealizzazione = annoRealizzazione;
        this.codiceVendita = codiceVendita;
        this.nomeArte = nomeArte;
        this.nomeOpera = nomeOpera;
        this.dimensioni = dimensioni;
        this.tecnica = tecnica;
        this.descrizione = descrizione;
    }
       public Opera(String nomeArte, String nomeOpera, String annoRealizzazione, String dimensioni, String tecnica, String descrizione ){
        this.annoRealizzazione = annoRealizzazione;
        this.nomeArte = nomeArte;
        this.nomeOpera = nomeOpera;
        this.dimensioni = dimensioni;
        this.tecnica = tecnica;
        this.descrizione = descrizione;
    }
    
    public Opera(String nomeArte, String annoRealizzazione, String dimensioni, String tecnica, String descrizione ){
            this.annoRealizzazione = annoRealizzazione;
            this.nomeArte = nomeArte;
            this.dimensioni = dimensioni;
            this.tecnica = tecnica;
            this.descrizione = descrizione;
        }

    public String getNomeOpera(){
        return this.nomeOpera;
    }
    public String getNomeArte(){
        return this.nomeArte;
    }
    public String getCodiceVendita(){
        return this.codiceVendita;
    }
    public String getAnnoRealizzazione(){
        return this.annoRealizzazione;
    }
    public String getDimensioni(){
        return this.dimensioni;
    }
    public String getDescrizione(){
         return this.descrizione;
    }
    public String getTecnica(){
        return this.tecnica;
    }

}
