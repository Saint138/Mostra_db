package it.unibo.mostra.controller;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;

import it.unibo.mostra.db.entity.*;
import it.unibo.mostra.db.query.QueryArtista;
import it.unibo.mostra.db.query.QueryDipendenti;
import it.unibo.mostra.db.query.QueryFornitore;
import it.unibo.mostra.db.query.QueryMostra;
import it.unibo.mostra.db.query.QueryOpera;
import it.unibo.mostra.db.query.QueryPresenza;
import it.unibo.mostra.db.query.QueryTurno;
import it.unibo.mostra.db.query.QueryUtente;
import it.unibo.mostra.db.query.QueryVendita;
import it.unibo.mostra.db.query.QueryVisita;
import it.unibo.mostra.view.ViewImpl;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private QueryTurno queryTurno;
    private ViewImpl view;
    //opera
    @FXML
    private TextField nome_arte, nome_opera, codice_vendita, anno_realizzazione, dimensioni, tecnica, descrizione;
    //mostra
    @FXML
    private TextField nome_mostra, città, data_inizio, data_fine, codice_mostra;
    //artista
    @FXML private TextField nome_arte_artista,nome_artista,cognome_artista,data_di_nascita,data_decesso,breve_biografia;
    //dipendente
    @FXML
    private TextField matricola, nome_dipendente, cognome_dipendente, email_dipendente,stipendio;
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
    @FXML private TextField codice_fornitore,nome_fornitore,email_fornitore,numero_telefono;
    //presenza
    @FXML
    private TextField codice_mostra_presenza, nome_arte_presenza, nome_opera_presenza;

    @FXML
    private CheckBox guida;
    @FXML
    private CheckBox receptionist;
    @FXML
    private CheckBox guardia;
    @FXML
    private CheckBox souvenir;
    @FXML
    private CheckBox magazziniere;
    @FXML
    private CheckBox guida_turno;
    @FXML
    private CheckBox receptionist_turno;
    @FXML
    private CheckBox guardia_turno;
    @FXML
    private CheckBox souvenir_turno;
    @FXML
    private CheckBox magazziniere_turno;
  
   
    @FXML
    private TableView<Opera> tabOpere;
    @FXML
    private TableView<RefreshMostra> tabMostre;
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

    public AdminViewController(ViewImpl view, QueryVisita queryVisita, QueryOpera queryOpera, QueryMostra queryMostra,
            QueryFornitore queryFornitore, QueryDipendenti queryDipendenti, QueryUtente queryUtente,
            QueryVendita queryVendita, QueryArtista queryArtista, QueryPresenza queryPresenza,QueryTurno queryTurno) {
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
        this.queryTurno = queryTurno;
    }

    @FXML
    public void addOpera() {
         try{
            queryOpera.addOpera(nome_arte.getText(), nome_opera.getText(),
                                    codice_vendita.getText(), anno_realizzazione.getText(), dimensioni.getText(),
                                    tecnica.getText(), descrizione.getText());
            nome_arte.clear();
            nome_opera.clear();
            codice_vendita.clear();
            anno_realizzazione.clear();
            dimensioni.clear();
            tecnica.clear();
            descrizione.clear();
            this.refreshOpere();
        } catch (SQLIntegrityConstraintViolationException e) {
            nome_arte.clear();
            nome_arte.setPromptText("Errore di inserimento");
            nome_arte.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalArgumentException(e);
        } catch (SQLException e) {
            nome_arte.clear();
            nome_arte.setPromptText("Errore di inserimento");
            nome_arte.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void removeOpera() {

    }

    @FXML
    public void refreshOpere() {

    }

    @FXML
    public void addMostra() {
       
        try{
            queryMostra.addMostra(nome_mostra.getText(),città.getText(), data_inizio.getText(),
                                    codice_mostra.getText(),data_fine.getText());
            nome_mostra.clear();
            città.clear();
            data_inizio.clear();
            data_fine.clear();
            codice_mostra.clear();
            this.refreshMostre();
        } catch (SQLIntegrityConstraintViolationException e) {
            nome_mostra.clear();
            nome_mostra.setPromptText("Errore di inserimento");
            nome_mostra.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalArgumentException(e);
        } catch (SQLException e) {
            nome_mostra.clear();
            nome_mostra.setPromptText("Errore di inserimento");
            nome_mostra.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void removeMostra() {

    }

    @FXML
    public void refreshMostre() {
        this.tabMostre.getColumns().clear();
        TableColumn<RefreshMostra, String> nomeMostra = new TableColumn<>("Nome mostra");
        nomeMostra.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<RefreshMostra, String> codiceMostra = new TableColumn<>("Codice RefreshMostra");
        codiceMostra.setCellValueFactory(new PropertyValueFactory<>("codiceMostra"));
        TableColumn<RefreshMostra, String> città = new TableColumn<>("Città");
        città.setCellValueFactory(new PropertyValueFactory<>("città"));
        TableColumn<RefreshMostra, String> dataInizio = new TableColumn<>("Data Inizio");
        dataInizio.setCellValueFactory(new PropertyValueFactory<>("dataInizio"));
        TableColumn<RefreshMostra, String> dataFine = new TableColumn<>("Data Fine");
        dataFine.setCellValueFactory(new PropertyValueFactory<>("dataFine"));
        this.tabMostre.getColumns()
                .addAll(Arrays.asList(nomeMostra, codiceMostra, città, dataInizio, dataFine));
        this.tabMostre.setItems(this.queryMostra.refreshMostra());
    }

    @FXML
    public void addArtista() {
         try{
            queryArtista.addArtista(nome_arte_artista.getText(),nome_artista.getText(), cognome_artista.getText(),
                                    data_di_nascita.getText(),data_decesso.getText(),breve_biografia.getText());
            nome_arte_artista.clear();
            nome_artista.clear();
            cognome_artista.clear();
            data_decesso.clear();
            breve_biografia.clear();
            this.refreshArtisti();
        } catch (SQLIntegrityConstraintViolationException e) {
            nome_arte_artista.clear();
            nome_arte_artista.setPromptText("Errore di inserimento");
            nome_arte_artista.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalArgumentException(e);
        } catch (SQLException e) {
            nome_arte_artista.clear();
            nome_arte_artista.setPromptText("Errore di inserimento");
            nome_arte_artista.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void removeArtista() {

    }

    @FXML
    public void refreshArtisti() {

    }

    @FXML
    public void addDipendente() { 
        try{
            queryDipendenti.addDipendente(matricola.getText(),nome_dipendente.getText(), cognome_dipendente.getText(),
                                    email_dipendente.getText(),guida.isSelected(),guardia.isSelected(),magazziniere.isSelected(),receptionist.isSelected(),souvenir.isSelected(),Integer.parseInt(stipendio.getText()));
            matricola.clear();
            nome_dipendente.clear();
            cognome_dipendente.clear();
            email_dipendente.clear();
            guida.setSelected(false);
            guardia.setSelected(false);
            magazziniere.setSelected(false);
            receptionist.setSelected(false);
            souvenir.setSelected(false);
            stipendio.clear();
            this.refreshDipendenti();
        } catch (SQLIntegrityConstraintViolationException e) {
            matricola.clear();
            matricola.setPromptText("Errore di inserimento");
            matricola.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalArgumentException(e);
        } catch (SQLException e) {
            matricola.clear();
            matricola.setPromptText("Errore di inserimento");
            matricola.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void removeDipendente() {

    }

    @FXML
    public void refreshDipendenti() {

    }

    @FXML
    public void addTurno() {
        try{
            queryTurno.addTurno(codice_turno.getText(),data_turno.getText(), ora_inizio.getText(),
                                    ora_fine.getText(),codice_mostra_turno.getText());
            codice_turno.clear();
            data_turno.clear();
            ora_inizio.clear();
            ora_fine.clear();
            codice_mostra_turno.clear();
            this.refreshTurni();
        } catch (SQLIntegrityConstraintViolationException e) {
            codice_turno.clear();
            codice_turno.setPromptText("Errore di inserimento");
            codice_turno.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalArgumentException(e);
        } catch (SQLException e) {
            codice_turno.clear();
            codice_turno.setPromptText("Errore di inserimento");
            codice_turno.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void removeTurno() {

    }

    @FXML
    public void refreshTurni() {

    }

    @FXML
    public void addFornitore() { 
        try{
            queryFornitore.addFornitore(codice_fornitore.getText(),nome_fornitore.getText(), email_fornitore.getText(),
                                    numero_telefono.getText());
            codice_fornitore.clear();
            nome_fornitore.clear();
            email_fornitore.clear();
            numero_telefono.clear();
            this.refreshFornitori();
        } catch (SQLIntegrityConstraintViolationException e) {
            codice_fornitore.clear();
            codice_fornitore.setPromptText("Errore di inserimento");
            codice_fornitore.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalArgumentException(e);
        } catch (SQLException e) {
            codice_fornitore.clear();
            codice_fornitore.setPromptText("Errore di inserimento");
            codice_fornitore.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void removeFornitore() {

    }

    @FXML
    public void refreshFornitori() {

    }

    @FXML
    public void addVisita() { 
        try{
            queryVisita.addVisita(codice_visita.getText(),ora_inizio_visita.getText(), data_visita.getText(),
                                    codice_mostra_visita.getText(),codice_contratto_guida.getText());
            codice_visita.clear();
            ora_inizio_visita.clear();
            data_visita.clear();
            codice_mostra_visita.clear();
            codice_contratto_guida.clear();
            this.refreshVisite();
        } catch (SQLIntegrityConstraintViolationException e) {
            codice_visita.clear();
            codice_visita.setPromptText("Errore di inserimento");
            codice_visita.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalArgumentException(e);
        } catch (SQLException e) {
            codice_visita.clear();
            codice_visita.setPromptText("Errore di inserimento");
            codice_visita.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void removeVisita() {

    }

    @FXML
    public void refreshVisite() {

    }

    @FXML
    public void addVendita() { 
        try{
            queryVendita.addVendita(codice_vendita_vendita.getText(),data_vendita.getText(), Float.parseFloat(importo.getText()),
                                    codice_fornitore_vendita.getText());
            codice_vendita_vendita.clear();
            data_vendita.clear();
            importo.clear();
            codice_fornitore_vendita.clear();
            codice_contratto_guida.clear();
            this.refreshVendite();
        } catch (SQLIntegrityConstraintViolationException e) {
            codice_vendita_vendita.clear();
            codice_vendita_vendita.setPromptText("Errore di inserimento");
            codice_vendita_vendita.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalArgumentException(e);
        } catch (SQLException e) {
            codice_vendita_vendita.clear();
            codice_vendita_vendita.setPromptText("Errore di inserimento");
            codice_vendita_vendita.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void removeVendita() {

    }

    @FXML
    public void refreshVendite() {

    }

    @FXML
    public void addPresenza() { 
        try{
            queryPresenza.addPresenza(codice_mostra_presenza.getText(),nome_arte_presenza.getText(), nome_opera_presenza.getText());
            codice_mostra_presenza.clear();
            nome_arte_presenza.clear();
            nome_opera_presenza.clear();
            this.refreshPresenze();
        } catch (SQLIntegrityConstraintViolationException e) {
            codice_mostra_presenza.clear();
            codice_mostra_presenza.setPromptText("Errore di inserimento");
            codice_mostra_presenza.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalArgumentException(e);
        } catch (SQLException e) {
            codice_mostra_presenza.clear();
            codice_mostra_presenza.setPromptText("Errore di inserimento");
            codice_mostra_presenza.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
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
