package it.unibo.mostra.controller;

import it.unibo.mostra.db.entity.*;
import it.unibo.mostra.db.query.QueryArtista;
import it.unibo.mostra.db.query.QueryDipendenti;
import it.unibo.mostra.db.query.QueryFornitore;
import it.unibo.mostra.db.query.QueryMostra;
import it.unibo.mostra.db.query.QueryOpera;
import it.unibo.mostra.db.query.QueryPresenza;
import it.unibo.mostra.db.query.QueryUtente;
import it.unibo.mostra.db.query.QueryVendita;
import it.unibo.mostra.db.query.QueryVisita;
import it.unibo.mostra.view.ViewImpl;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
    //opera
    @FXML
    private TextField nome_arte, nome_opera, codice_vendita, anno_realizzazione, dimensioni, tecnica, descrizione;
    //mostra
    @FXML
    private TextField nome_mostra, città, data_inizio, data_fine_codice, codice_mostra;
    //artista
    @FXML private TextField nome_arte_artista,nome_artista,cognome_artista,data_di_nascita,data_decesso,breve_biografia;
    //dipendente
    @FXML
    private TextField matricola, nome_dipendente, cognome_dipendente, email_dipendente;
    //turno
    @FXML
    private TextField codice_turno, data_turno, ora_inizio, ora_fine, codice_mostra_turno;
    //vendita
    @FXML
    private TextField codice_vendita_vendita, data_vendita, importo, codice_fornitore_vendita;
    //visita
    @FXML
    private TextField codice_visita, ora_inizio_visita, data_visita, codice_mostra_visita, codice_contratto_guida;
    //fornitore
    @FXML private TextField codice_fornitore,nome_fornitore,email_fornitore,nunero_telefono;
    //presenza
    @FXML
    private TextField codice_mostra_presenza, nome_arte_presenza, nome_opera_presenza;
    
    @FXML
    private ChoiceBox<String> tipi;
    @FXML
    private ChoiceBox<String> turno;
    @FXML
    private TableView<Opera> tabOpere;
    @FXML
    private TableView<Opera> tabMostre;
    @FXML
    private TableView<Opera> tabArtisti;
    @FXML
    private TableView<Opera> tabDipendenti;
    @FXML
    private TableView<Opera> tabTurni;
    @FXML
    private TableView<Opera> tabVendite;
    @FXML
    private TableView<Opera> tabVisite;
    @FXML
    private TableView<Opera> tabFornitori;
    @FXML
    private TableView<Opera> tabPresenze;

    private String[] tipiDipendenti = {"Guardia", "Receptionist", "Guida", "Souvenir", "Magazziniere"};

        

    public AdminViewController(ViewImpl view, QueryVisita queryVisita, QueryOpera queryOpera, QueryMostra queryMostra,
            QueryFornitore queryFornitore, QueryDipendenti queryDipendenti, QueryUtente queryUtente,
            QueryVendita queryVendita, QueryArtista queryArtista, QueryPresenza queryPresenza) {
        this.view = view;
        this.queryDipendenti = queryDipendenti;
        this.queryArtista = queryArtista;
        this.queryFornitore = queryFornitore;
        this.queryMostra = queryMostra;
        this.queryOpera = queryOpera;
        this.queryUtente = queryUtente;
        this.queryVisita = queryVisita;
        this.queryVendita = queryVendita;
        this.queryPresenza = queryPresenza;
    }
    
    public void addOpera() {

    }
    
    public void removeOpera() {

    }
    
    public void refreshOpere() {

    }
    
    public void addMostra() {

    }
    
    public void removeMostra() {

    }
    
    public void refreshMostre() {

    }
    
    public void addArtista() {

    }
    
    public void removeArtista() {

    }
    
    public void refreshArtisti() {

    }
    
    public void addDipendente() {

    }
    
    public void removeDipendente() {

    }
    
    public void refreshDipendenti() {

    }
    
    public void addTurno() {

    }
    
    public void removeTurno() {

    }
    
    public void refreshTurni() {

    }
    
    public void addFornitore() {

    }
    
    public void removeFornitore() {

    }
    
    public void refreshFornitori() {

    }
    
    public void addVisita() {

    }
    
    public void removeVisita() {

    }
    
    public void refreshVisite() {

    }
    
    public void addVendita() {

    }
    
    public void removeVendita() {

    }
    
    public void refreshVendite() {

    }
    
    public void addPresenza() {

    }
    
    public void removePresenza() {

    }
    
    public void refreshPresenze() {
        
    }
}
