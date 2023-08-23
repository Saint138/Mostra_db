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
    private TableView<Mostra> tabMostre;
    @FXML
    private TableView<Artista> tabArtisti;
    @FXML
    private TableView<Dipendente> tabDipendenti;
    @FXML
    private TableView<Turno> tabTurni;
    @FXML
    private TableView<Vendita> tabVendite;
    @FXML
    private TableView<Visita> tabVisite;
    @FXML
    private TableView<Fornitore> tabFornitori;
    @FXML
    private TableView<Presenza> tabPresenze;

    private String[] tipiDipendenti = {"Guardia", "Receptionist", "Guida", "Souvenir", "Magazziniere"};
    private String[] tipiContratto = {"Contratto_Guardia", "Contratto_Receptionist", "Contratto_Guida", "Contratto_Souvenir", "Contratto_Magazziniere"};

        

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

    @FXML
    public void addOpera() {

    }

    @FXML
    public void removeOpera() {

    }

    @FXML
    public void refreshOpere() {

    }

    @FXML
    public void addMostra() {

    }

    @FXML
    public void removeMostra() {

    }

    @FXML
    public void refreshMostre() {

    }

    @FXML
    public void addArtista() {

    }

    @FXML
    public void removeArtista() {

    }

    @FXML
    public void refreshArtisti() {

    }

    @FXML
    public void addDipendente() {

    }

    @FXML
    public void removeDipendente() {

    }

    @FXML
    public void refreshDipendenti() {

    }

    @FXML
    public void addTurno() {

    }

    @FXML
    public void removeTurno() {

    }

    @FXML
    public void refreshTurni() {

    }

    @FXML
    public void addFornitore() {

    }

    @FXML
    public void removeFornitore() {

    }

    @FXML
    public void refreshFornitori() {

    }

    @FXML
    public void addVisita() {

    }

    @FXML
    public void removeVisita() {

    }

    @FXML
    public void refreshVisite() {

    }

    @FXML
    public void addVendita() {

    }

    @FXML
    public void removeVendita() {

    }

    @FXML
    public void refreshVendite() {

    }

    @FXML
    public void addPresenza() {

    }

    @FXML
    public void removePresenza() {

    }

    @FXML
    public void refreshPresenze() {

    }

    @FXML
    public void goBack() {
          this.view.setMainView();
    }
}
