package it.unibo.mostra.db.entity;

public class FornitoriPiuAttivi {
    private String nome;
    private String codiceFornitore;
    private Integer numeroVendite;

    public FornitoriPiuAttivi(String nome, String codiceFornitore, Integer rec){
        this.nome = nome;
        this.codiceFornitore = codiceFornitore;
        this.numeroVendite = rec;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCodiceFornitore() {
        return this.codiceFornitore;
    }

    public Integer getNumeroVendite(){
        return this.numeroVendite;
    }
}
