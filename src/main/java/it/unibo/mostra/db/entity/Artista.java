package it.unibo.mostra.db.entity;

public class Artista {
    private String nomeArte;
    private String nome;
    private String cognome;
    private String dataNascita;
    private String dataDecesso;
    private String breveBiografia;

    public Artista(String nome, String nomeArte, String cognome, String dataNascita, String dataDecesso,
            String breveBiografia) {
        this.nome = nome;
        this.nomeArte = nomeArte;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.dataDecesso = dataDecesso;
        this.breveBiografia = breveBiografia;

    }
       public Artista(String nome,String cognome,String dataNascita,String dataDecesso,String breveBiografia) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.dataDecesso = dataDecesso;
        this.breveBiografia = breveBiografia;

    }


    public String getnomeArte() {
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
