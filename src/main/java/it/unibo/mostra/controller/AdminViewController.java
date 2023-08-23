package it.unibo.mostra.controller;

import it.unibo.mostra.db.query.QueryArtista;
import it.unibo.mostra.db.query.QueryBiglietteria;
import it.unibo.mostra.db.query.QueryDipendenti;
import it.unibo.mostra.db.query.QueryFornitore;
import it.unibo.mostra.db.query.QueryMostra;
import it.unibo.mostra.db.query.QueryOpera;
import it.unibo.mostra.db.query.QueryPresenza;
import it.unibo.mostra.db.query.QueryRecensione;
import it.unibo.mostra.db.query.QueryRicerca;
import it.unibo.mostra.db.query.QueryUtente;
import it.unibo.mostra.db.query.QueryVendita;
import it.unibo.mostra.db.query.QueryVisita;
import it.unibo.mostra.view.ViewImpl;

public class AdminViewController {

    private QueryDipendenti queryDipendenti;
    private QueryMostra queryMostra;
    private QueryFornitore queryFornitore;
    private QueryOpera queryOpera;
    private QueryUtente queryUtente;
    private QueryVisita queryVisita;
    private QueryVendita queryVendita;
    private QueryArtista queryArtista;
    private QueryPresenza queryPresenza;
    private ViewImpl view;

    public AdminViewController(ViewImpl view,QueryVisita queryVisita,QueryOpera queryOpera,QueryMostra queryMostra,QueryFornitore queryFornitore,QueryDipendenti queryDipendenti,QueryUtente queryUtente,QueryVendita queryVendita,QueryArtista queryArtista,QueryPresenza queryPresenza){
        this.view=view;
        this.queryDipendenti=queryDipendenti;
        this.queryArtista=queryArtista;
        this.queryFornitore=queryFornitore;
        this.queryMostra=queryMostra;
        this.queryOpera=queryOpera;
        this.queryUtente=queryUtente;
        this.queryVisita=queryVisita;
        this.queryVendita=queryVendita;
        this.queryPresenza=queryPresenza;
    }
}
