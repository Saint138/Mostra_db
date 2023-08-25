package it.unibo.mostra.db.entity;

public class MediaRecensioniMostra {
    private String nome;
    private float media;

    public MediaRecensioniMostra(String nome, Float media) {
        this.nome = nome;
        this.media = media;
    }

    public String getNome() {
        return nome;
    }

    public Float getMedia() {
        return media;
    }
}
