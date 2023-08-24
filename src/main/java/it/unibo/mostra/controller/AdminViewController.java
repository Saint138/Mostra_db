package it.unibo.mostra.controller;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;

import it.unibo.mostra.db.entity.*;
import it.unibo.mostra.db.query.*;
import it.unibo.mostra.utils.DateAdapter;
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
    private QueryVisitatore queryVisitatore;
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
    // visitatore
    @FXML
    private TextField cf_visitatore;


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
    @FXML
    private TableView<Visitatore> tabMostreNegative;
    @FXML
    private TableView<Visitatore> tabClassificaMostre;
    @FXML
    private TableView<Visitatore> tabGuadagnoTotale;
    @FXML
    private TableView<Visitatore> tabBigliettiTotali;
    @FXML
    private TableView<Visitatore> tabListaFornitoriPiuAttivi;
    @FXML
    private TableView<Visitatore> tabListaUtentiPiuAttivi;
    

    public AdminViewController(ViewImpl view, QueryVisita queryVisita, QueryOpera queryOpera, QueryMostra queryMostra,
            QueryFornitore queryFornitore, QueryDipendenti queryDipendenti, QueryVisitatore queryVisitatore,
            QueryVendita queryVendita, QueryArtista queryArtista, QueryPresenza queryPresenza,QueryTurno queryTurno) {
        this.view = view;
        this.queryDipendenti = queryDipendenti;
        this.queryArtista = queryArtista;
        this.queryFornitore = queryFornitore;
        this.queryMostra = queryMostra;
        this.queryOpera = queryOpera;
        this.queryVisitatore = queryVisitatore;
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
         try {
            this.queryOpera.removeOpera(nome_arte.getText(), nome_opera.getText());
            nome_arte.clear();
            nome_opera.clear();
            codice_vendita.clear();
            anno_realizzazione.clear();
            dimensioni.clear();
            tecnica.clear();
            descrizione.clear();
            this.refreshOpere();
            this.refreshPresenze();
        } catch (SQLException e) {
            nome_arte.clear();
            nome_arte.setPromptText("Errore di rimozione");
            nome_arte.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void refreshOpere() {
        this.tabOpere.getColumns().clear();
        TableColumn<Opera, String> nomeArte = new TableColumn<>("Nome Artista");
        nomeArte.setCellValueFactory(new PropertyValueFactory<>("nomeArte"));
        TableColumn<Opera, String> nomeOpera = new TableColumn<>("Nome Opera");
        nomeOpera.setCellValueFactory(new PropertyValueFactory<>("nomeOpera"));
        TableColumn<Opera, String> annoRealizzazione = new TableColumn<>("Data");
        annoRealizzazione.setCellValueFactory(new PropertyValueFactory<>("annoRealizzazione"));
        TableColumn<Opera, String> dimensioni = new TableColumn<>("Dimensioni");
        dimensioni.setCellValueFactory(new PropertyValueFactory<>("dimensioni"));
        TableColumn<Opera, String> tecnica = new TableColumn<>("Tecnica");
        tecnica.setCellValueFactory(new PropertyValueFactory<>("tecnica"));
        TableColumn<Opera, String> descrizione = new TableColumn<>("Descrizione");
        descrizione.setCellValueFactory(new PropertyValueFactory<>("descrizione"));
        this.tabOpere.getColumns()
                .addAll(Arrays.asList(nomeArte, nomeOpera, annoRealizzazione, dimensioni, tecnica, descrizione));
        this.tabOpere.setItems(this.queryOpera.refreshOpera());
    }

    @FXML
    public void addMostra() {
       
        try{
            queryMostra.addMostra(nome_mostra.getText(),città.getText(), DateAdapter.dateToSqlDate(DateAdapter.buildDate(data_inizio.getText()).get()),
                                    codice_mostra.getText(),DateAdapter.dateToSqlDate(DateAdapter.buildDate(data_fine.getText()).get()));
        
        
            nome_mostra.clear();
            città.clear();
            data_inizio.clear();
            data_fine.clear();
            codice_mostra.clear();
            this.refreshMostre();
        } catch (SQLIntegrityConstraintViolationException e) {
            e.getCause();
            nome_mostra.clear();
            nome_mostra.setPromptText("Errore di inserimento");
            nome_mostra.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalArgumentException(e);
        } catch (SQLException e) {
            e.getCause();
            nome_mostra.clear();
            nome_mostra.setPromptText("Errore di inserimento");
            nome_mostra.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void removeMostra() {
        try {
            this.queryMostra.removeMostra(codice_mostra.getText());
            codice_mostra.clear();
            nome_mostra.clear();
            città.clear();
            data_inizio.clear();
            data_fine.clear();
            this.refreshMostre();
        } catch (SQLException e) {
            codice_mostra.clear();
            codice_mostra.setPromptText("Errore di rimozione");
            codice_mostra.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
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
         try {
            this.queryArtista.removeArtista(nome_arte_artista.getText());
            nome_arte_artista.clear();
            nome_artista.clear();
            cognome_artista.clear();
            data_di_nascita.clear();
            data_decesso.clear();
            breve_biografia.clear();
            this.refreshArtisti();
        } catch (SQLException e) {
            nome_arte_artista.clear();
            nome_arte_artista.setPromptText("Errore di rimozione");
            nome_arte_artista.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void refreshArtisti() {
        this.tabArtisti.getColumns().clear();
        TableColumn<Artista, String> nomeArte = new TableColumn<>("Nome Arte");
        nomeArte.setCellValueFactory(new PropertyValueFactory<>("nomeArte"));
        TableColumn<Artista, String> nome = new TableColumn<>("Nome");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<Artista, String> cognome = new TableColumn<>("Cognome");
        cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<Artista, String> dataDecesso = new TableColumn<>("Data Decesso");
        dataDecesso.setCellValueFactory(new PropertyValueFactory<>("dataDecesso"));
        TableColumn<Artista, String> dataNascita = new TableColumn<>("Data Nascita");
        dataNascita.setCellValueFactory(new PropertyValueFactory<>("dataNascita"));
        TableColumn<Artista, String> breveBiografia = new TableColumn<>("Breve Biografia");
        breveBiografia.setCellValueFactory(new PropertyValueFactory<>("breveBiografia"));
        this.tabArtisti.getColumns()
                .addAll(Arrays.asList(nomeArte, nome, cognome, dataNascita,dataDecesso, breveBiografia));
        this.tabArtisti.setItems(this.queryArtista.refreshArtista());
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
        
        try {
            this.queryDipendenti.removeDipendenti(matricola.getText());
            matricola.clear();
            nome_dipendente.clear();
            cognome_dipendente.clear();
            email_dipendente.clear();
            stipendio.clear();
            this.refreshDipendenti();
        } catch (SQLException e) {
            matricola.clear();
            matricola.setPromptText("Errore di rimozione");
            matricola.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void refreshDipendenti() {
        this.tabDipendenti.getColumns().clear();
        TableColumn<Dipendente, String> nome = new TableColumn<>("Nome");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<Dipendente, String> cognome = new TableColumn<>("Cognome");
        cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<Dipendente, String> matricola= new TableColumn<>("Matricola");
        matricola.setCellValueFactory(new PropertyValueFactory<>("matricola"));
        TableColumn<Dipendente, String> email = new TableColumn<>("Email");
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.tabDipendenti.getColumns()
                .addAll(Arrays.asList(matricola, nome, cognome, email));
        this.tabDipendenti.setItems(this.queryDipendenti.refreshDipendente());

    }

    @FXML
    public void addTurno() {
            
        try{
            queryTurno.addTurno(codice_turno.getText(),data_turno.getText(), ora_inizio.getText(),
                                    ora_fine.getText(),codice_mostra_turno.getText(),guida_turno.isSelected(),guardia_turno.isSelected(),magazziniere_turno.isSelected(),receptionist_turno.isSelected(),souvenir_turno.isSelected() ); 
            codice_turno.clear();
            data_turno.clear();
            ora_inizio.clear();
            ora_fine.clear();
            codice_mostra_turno.clear();
             guida_turno.setSelected(false);
            guardia_turno.setSelected(false);
            magazziniere_turno.setSelected(false);
            receptionist_turno.setSelected(false);
            souvenir_turno.setSelected(false);
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
        try {
            this.queryTurno.removeTurno(codice_turno.getText());
            codice_turno.clear();
            data_turno.clear();
            ora_inizio.clear();
            ora_fine.clear();
            codice_mostra_turno.clear();
            this.refreshTurni();
        } catch (SQLException e) {
            codice_turno.clear();
            codice_turno.setPromptText("Errore di rimozione");
            codice_turno.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
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
        try {
            this.queryVisita.removeVisita(codice_turno.getText());
            codice_visita.clear();
            ora_inizio_visita.clear();
            data_visita.clear();
            codice_mostra_visita.clear();
            codice_contratto_guida.clear();
            this.refreshVisite();
        } catch (SQLException e) {
            codice_visita.clear();
            codice_visita.setPromptText("Errore di rimozione");
            codice_visita.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void refreshVisite() {
        this.tabVisite.getColumns().clear();
        TableColumn<Visita, String> codice = new TableColumn<>("Codice");
        codice.setCellValueFactory(new PropertyValueFactory<>("codice_visita"));
        TableColumn<Visita, String> data = new TableColumn<>("Data");
        data.setCellValueFactory(new PropertyValueFactory<>("data_visita"));
        TableColumn<Visita, Float> ora= new TableColumn<>("Orario");
        ora.setCellValueFactory(new PropertyValueFactory<>("ora_inizio"));
        TableColumn<Visita, Integer> partecipanti = new TableColumn<>("Numero partecipanti");
        partecipanti.setCellValueFactory(new PropertyValueFactory<>("numero_partecipanti"));
        TableColumn<Visita, String> mostra = new TableColumn<>("Mostra");
        mostra.setCellValueFactory(new PropertyValueFactory<>("nome_mostra"));
        this.tabVisite.getColumns()
                .addAll(Arrays.asList(codice, data, ora, partecipanti, mostra));
        this.tabVisite.setItems(this.queryVisita.refreshVisita());
    }

    @FXML
    public void addVendita() {
        try {
            queryVendita.addVendita(codice_vendita.getText(), data_vendita.getText(),
                    Float.parseFloat(importo.getText()),
                    codice_fornitore_vendita.getText());
            codice_vendita.clear();
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
    public void refreshVendite() { 
        this.tabVendite.getColumns().clear();
        TableColumn<Vendita, String> codice = new TableColumn<>("Codice");
        codice.setCellValueFactory(new PropertyValueFactory<>("codice_vendita"));
        TableColumn<Vendita, String> data = new TableColumn<>("Data");
        data.setCellValueFactory(new PropertyValueFactory<>("data_vendita"));
        TableColumn<Vendita, Float> importo= new TableColumn<>("Importo");
        importo.setCellValueFactory(new PropertyValueFactory<>("importo"));
        TableColumn<Vendita, String> fornitore = new TableColumn<>("Fornitore");
        fornitore.setCellValueFactory(new PropertyValueFactory<>("nome_fornitore"));
        this.tabVendite.getColumns()
                .addAll(Arrays.asList(codice, data, importo, fornitore));
        this.tabVendite.setItems(this.queryVendita.refreshVendita());
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
        try {
            this.queryPresenza.removePresenza(codice_mostra_presenza.getText(), nome_arte_presenza.getText(), nome_opera_presenza.getText());
            codice_mostra_presenza.clear();
            nome_arte_presenza.clear();
            nome_opera_presenza.clear();
            this.refreshPresenze();
        } catch (SQLException e) {
            codice_mostra_presenza.clear();
            codice_mostra_presenza.setPromptText("Errore di rimozione");
            codice_mostra_presenza.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void refreshPresenze() {

    }

    @FXML
    public void removeVisitatore() {
        try {
            this.queryVisitatore.removeUtente(cf_visitatore.getText());
            cf_visitatore.clear();
            
            this.refreshVisitatori();
        } catch (SQLException e) {
            cf_visitatore.clear();
            cf_visitatore.setPromptText("Errore di rimozione");
            cf_visitatore.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }
    @FXML
    public void refreshVisitatori() {

    }

    @FXML
    public void viewMostrenegative() {

    }

    @FXML
    public void viewClassificaMostre() {

    }

    @FXML
    public void viewGuadagnoMostre() {

    }

    @FXML
    public void viewTotaleBiglietti() {

    }

    @FXML
    public void viewFornitoriPiuAttivi() {

    }
    
    @FXML
    public void viewUtentiPiuAttivi() {

    }
    

    @FXML
    public void goBack() {
          this.view.setMainView();
    }
}
