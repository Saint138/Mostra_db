package it.unibo.mostra.db.entity;

public class Artista {
    private String nomeArte;
    private String nome;
    private String cognome;
    private String dataNascita;
    private String dataDecesso;
    private String breveBiografia;
    private int valore;

    public Artista(String nomeArte,String nome,  String cognome, String dataNascita, String dataDecesso,
            String breveBiografia) {
        this.nome = nome;
        this.nomeArte = nomeArte;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.dataDecesso = dataDecesso;
        this.breveBiografia = breveBiografia;

    }

    public Artista(String nome, String cognome, String dataNascita, String dataDecesso, String breveBiografia) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.dataDecesso = dataDecesso;
        this.breveBiografia = breveBiografia;

    }

    public Artista(String nome) {
        this.nomeArte = nome;
    }
    
    
    public Artista(String nome, int valore) {
        this.nomeArte = nome;
        this.valore = valore;
    }
    
    public int getValore() {
        return valore;
    }
    public String getNomeArte() {
        return nomeArte;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public String getDataDecesso() {
        return dataDecesso;
    }
    public String getBreveBiografia() {
        return breveBiografia;
    }
    
}
