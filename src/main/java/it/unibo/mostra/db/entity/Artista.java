package it.unibo.mostra.db.entity;

public class Artista {
    private String nome_arte;
    private String nome;
    private String cognome;
    private String data_di_nascita;
    private String data_decesso;
    private String breve_biografia;

    public Artista(String nome,String nome_arte,String cognome,String data_di_nascita,String data_decesso,String breve_biografia) {
        this.nome = nome;
        this.nome_arte = nome_arte;
        this.cognome = cognome;
        this.data_di_nascita = data_di_nascita;
        this.data_decesso = data_decesso;
        this.breve_biografia = breve_biografia;

    }

    public String getNome_arte() {
        return nome_arte;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getData_di_nascita() {
        return data_di_nascita;
    }

    public String getData_decesso() {
        return data_decesso;
    }
    public String getBreve_biografia() {
        return breve_biografia;
    }
    
}
