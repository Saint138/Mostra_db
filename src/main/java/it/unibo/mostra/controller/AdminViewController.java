package it.unibo.mostra.controller;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import it.unibo.mostra.db.entity.*;
import it.unibo.mostra.db.query.*;
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
    private TextField nome_arte_opera, nome_opera, codice_vendita, anno_realizzazione, dimensioni, tecnica, descrizione;
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
    private TextField codice_turno, ora_inizio, ora_fine, codice_mostra_turno;
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
    private TableView<NumeroRecensioniNegative> tabMostreNegative;
    @FXML
    private TableView<MediaRecensioniMostra> tabMediaRecensioni;
    @FXML
    private TableView<GuadagnoMostraTotale> tabGuadagnoTotale;
    @FXML
    private TableView<BigliettiMostraTotale> tabBigliettiTotali;
    @FXML
    private TableView<FornitoriPiuAttivi> tabListaFornitoriPiuAttivi;
    @FXML
    private TableView<UtentiPiùAttivi> tabListaUtentiPiuAttivi;
    @FXML
    private TableView<Artista> tabArtistaValore;
    @FXML
    private TableView<Visitatore> tabTopVisitatori;
    @FXML
    private TableView<Mostra> tabMediaOpere;
    @FXML
    private TableView<Visitatore> tabVisitatori;
    @FXML
    private TableView<Artista> tabArtistiNoOpere;
    

    public AdminViewController(ViewImpl view, QueryVisita queryVisita, QueryOpera queryOpera, QueryMostra queryMostra,
            QueryFornitore queryFornitore, QueryDipendenti queryDipendenti, QueryVisitatore queryVisitatore,
            QueryVendita queryVendita, QueryArtista queryArtista, QueryPresenza queryPresenza, QueryTurno queryTurno) {
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
    public void initialize() {
        refreshOpere();
        refreshArtisti();
        refreshDipendenti();
        refreshFornitori();
        refreshMostre();
        refreshVendite();
        refreshVisitatori();
        refreshVisite();
        refreshPresenze();
        refreshTurni();
        viewClassificaMostre();
        viewFornitoriPiuAttivi();
        viewMostreNegative();
        viewTotaleBiglietti();
        viewGuadagnoMostre();
        viewUtentiPiuAttivi();
        viewArtistaTopValore();
        viewArtistiNoOpere();
        viewMediaOpere();
        viewTopVisitatori();

    }

    @FXML
    public void addOpera() {
         try{
            queryOpera.addOpera(nome_arte_opera.getText(), nome_opera.getText(),
                                    codice_vendita.getText(), anno_realizzazione.getText(), dimensioni.getText(),
                                    tecnica.getText(), descrizione.getText());
            nome_arte_opera.clear();
            nome_opera.clear();
            codice_vendita.clear();
            anno_realizzazione.clear();
            dimensioni.clear();
            tecnica.clear();
            descrizione.clear();
            this.refreshOpere();
        } catch (SQLIntegrityConstraintViolationException e) {
            nome_arte_opera.clear();
            nome_arte_opera.setPromptText("Errore di inserimento");
            nome_arte_opera.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalArgumentException(e);
        } catch (SQLException e) {
            nome_arte_opera.clear();
            nome_arte_opera.setPromptText("Errore di inserimento");
            nome_arte_opera.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void removeOpera() {
         try {
            this.queryOpera.removeOpera(nome_arte_opera.getText(), nome_opera.getText());
            nome_arte_opera.clear();
            nome_opera.clear();
            codice_vendita.clear();
            anno_realizzazione.clear();
            dimensioni.clear();
            tecnica.clear();
            descrizione.clear();
            this.refreshOpere();
            this.refreshPresenze();
        } catch (SQLException e) {
            nome_arte_opera.clear();
            nome_arte_opera.setPromptText("Errore di rimozione");
            nome_arte_opera.setStyle("-fx-prompt-text-fill: red;");
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
            queryMostra.addMostra(nome_mostra.getText(),città.getText(), data_inizio.getText(),
                                    codice_mostra.getText(),data_fine.getText());
        
            nome_mostra.clear();
            città.clear();
            data_inizio.clear();
            data_fine.clear();
            codice_mostra.clear();
            this.refreshMostre();
        } catch (SQLIntegrityConstraintViolationException e) {
            e.getCause();
            codice_mostra.clear();
            codice_mostra.setPromptText("Errore di inserimento");
            codice_mostra.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalArgumentException(e);
        } catch (SQLException e) {
            e.getCause();
            codice_mostra.clear();
            codice_mostra.setPromptText("Errore di inserimento");
            codice_mostra.setStyle("-fx-prompt-text-fill: red;");
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
        TableColumn<RefreshMostra, String> codiceMostra = new TableColumn<>("Codice Mostra");
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
                .addAll(Arrays.asList(nomeArte, nome, cognome, dataNascita, dataDecesso, breveBiografia));
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
            queryTurno.addTurno(codice_turno.getText(), ora_inizio.getText(),
                                    ora_fine.getText(),codice_mostra_turno.getText()); 
            codice_turno.clear();
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
        try {
            this.queryTurno.removeTurno(codice_turno.getText());
            codice_turno.clear();
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
        this.tabTurni.getColumns().clear();
        TableColumn<Turno, String> codiceTurno = new TableColumn<>("Codice Turno");
        codiceTurno.setCellValueFactory(new PropertyValueFactory<>("codiceTurno"));
        TableColumn<Turno, String> oraInizio = new TableColumn<>("Ora Inizio");
        oraInizio.setCellValueFactory(new PropertyValueFactory<>("oraInizio"));
        TableColumn<Turno, String> oraFine = new TableColumn<>("Ora fine");
        oraFine.setCellValueFactory(new PropertyValueFactory<>("oraFine"));
        TableColumn<Turno, String> codiceMostra = new TableColumn<>("Codice Mostra");
        codiceMostra.setCellValueFactory(new PropertyValueFactory<>("codiceMostra"));
        this.tabTurni.getColumns()
                .addAll(Arrays.asList(codiceTurno, oraInizio, oraFine, codiceMostra));
        this.tabTurni.setItems(this.queryTurno.refreshTurni());
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
        this.tabFornitori.getColumns().clear();
        TableColumn<Fornitore, String> codiceFornitore = new TableColumn<>("Codice Fornitore");
        codiceFornitore.setCellValueFactory(new PropertyValueFactory<>("codiceFornitore"));
        TableColumn<Fornitore, String> nome = new TableColumn<>("Nome Fornitore");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<Fornitore, String> email = new TableColumn<>("Email");
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        TableColumn<Fornitore, String> numeroTelefono = new TableColumn<>("Numero Telefono");
        numeroTelefono.setCellValueFactory(new PropertyValueFactory<>("numeroTelefono"));
        this.tabFornitori.getColumns()
                .addAll(Arrays.asList(codiceFornitore, nome, email, numeroTelefono));
        this.tabFornitori.setItems(this.queryFornitore.refreshFornitore());
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
            this.queryVisita.removeVisita(codice_visita.getText());
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
            queryVendita.addVendita(codice_vendita_vendita.getText(), data_vendita.getText(),
                    Float.parseFloat(importo.getText()),
                    codice_fornitore_vendita.getText());
            codice_vendita_vendita.clear();
            data_vendita.clear();
            importo.clear();
            codice_fornitore_vendita.clear();
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
        TableColumn<Vendita, String> codiceVendita = new TableColumn<>("Codice Vendita");
        codiceVendita.setCellValueFactory(new PropertyValueFactory<>("codiceVendita"));
        TableColumn<Vendita, String> dataVendita = new TableColumn<>("Data");
        dataVendita.setCellValueFactory(new PropertyValueFactory<>("dataVendita"));
        TableColumn<Vendita, Float> importo= new TableColumn<>("Importo");
        importo.setCellValueFactory(new PropertyValueFactory<>("importo"));
        TableColumn<Vendita, String> codiceFornitore = new TableColumn<>("Codice Fornitore");
        codiceFornitore.setCellValueFactory(new PropertyValueFactory<>("codiceFornitore"));
        this.tabVendite.getColumns()
                .addAll(Arrays.asList(codiceVendita, dataVendita, importo, codiceFornitore));
        this.tabVendite.setItems(this.queryVendita.refreshVendita());
    }

    @FXML
    public void addPresenza() { 
        try{
            queryPresenza.addPresenza(nome_opera_presenza.getText(),nome_arte_presenza.getText(), codice_mostra_presenza.getText());
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
        this.tabPresenze.getColumns().clear();
        TableColumn<Presenza, String> nomeArte = new TableColumn<>("Nome Artista");
        nomeArte.setCellValueFactory(new PropertyValueFactory<>("nomeArte"));
        TableColumn<Presenza, String> nomeOpera = new TableColumn<>("Nome Opera");
        nomeOpera.setCellValueFactory(new PropertyValueFactory<>("nomeOpera"));
        TableColumn<Presenza, String> nomeMostra = new TableColumn<>("Nome Mostra");
        nomeMostra.setCellValueFactory(new PropertyValueFactory<>("nomeMostra"));
        TableColumn<Presenza, String> codiceMostra = new TableColumn<>("Codice Mostra");
        codiceMostra.setCellValueFactory(new PropertyValueFactory<>("codiceMostra"));
        this.tabPresenze.getColumns()
                .addAll(Arrays.asList(nomeArte, nomeOpera, nomeMostra,codiceMostra));
        this.tabPresenze.setItems(this.queryPresenza.refreshPresenze());
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
        this.tabVisitatori.getColumns().clear();
        TableColumn<Visitatore, String> cf = new TableColumn<>("Codice Fiscale");
        cf.setCellValueFactory(new PropertyValueFactory<>("cf"));
        TableColumn<Visitatore, String> nome = new TableColumn<>("Nome");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<Visitatore, String> cognome= new TableColumn<>("cognome");
        cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<Visitatore, String> email = new TableColumn<>("Email");
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.tabVisitatori.getColumns()
                .addAll(Arrays.asList(cf, nome, cognome, email));
        this.tabVisitatori.setItems(this.queryVisitatore.refreshVisitatori());
    }

    @FXML
    public void viewMostreNegative() {
        this.tabMostreNegative.getColumns().clear();
        TableColumn<NumeroRecensioniNegative, String> nome = new TableColumn<>("Nome");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<NumeroRecensioniNegative, String> totale = new TableColumn<>("Totale ");
        totale.setCellValueFactory(new PropertyValueFactory<>("totale"));

        this.tabMostreNegative.getColumns()
                .addAll(Arrays.asList(nome,totale));
        this.tabMostreNegative.setItems(this.queryMostra.RecensioniNegativeMostra());
    }

    @FXML
    public void viewClassificaMostre() {
        this.tabMediaRecensioni.getColumns().clear();
        TableColumn<MediaRecensioniMostra, String> nome = new TableColumn<>("Nome");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<MediaRecensioniMostra, Float> media = new TableColumn<>("Media ");
        media.setCellValueFactory(new PropertyValueFactory<>("media"));

        this.tabMediaRecensioni.getColumns()
                .addAll(Arrays.asList(nome,media));
        this.tabMediaRecensioni.setItems(this.queryMostra.MediaRecensioni());
    }

    @FXML
    public void viewGuadagnoMostre() {
        this.tabGuadagnoTotale.getColumns().clear();
        TableColumn<GuadagnoMostraTotale, String> nome = new TableColumn<>("Nome Mostra");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<GuadagnoMostraTotale, String> valore = new TableColumn<>("valore ");
        valore.setCellValueFactory(new PropertyValueFactory<>("valore"));

        this.tabGuadagnoTotale.getColumns()
                .addAll(Arrays.asList(nome,valore));
        this.tabGuadagnoTotale.setItems(this.queryMostra.GuadagnoMostra());
    }

    @FXML
    public void viewTotaleBiglietti() {
        this.tabBigliettiTotali.getColumns().clear();
        TableColumn<BigliettiMostraTotale, String> nome = new TableColumn<>("Nome Mostra");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<BigliettiMostraTotale, Integer> totale = new TableColumn<>("Numero Biglietti ");
        totale.setCellValueFactory(new PropertyValueFactory<>("totale"));

        this.tabBigliettiTotali.getColumns()
                .addAll(Arrays.asList(nome,totale));
        this.tabBigliettiTotali.setItems(this.queryMostra.BigliettiTotali());
    }

    @FXML
    public void viewFornitoriPiuAttivi() {
        this.tabListaFornitoriPiuAttivi.getColumns().clear();
        TableColumn<FornitoriPiuAttivi, String> codiceFornitore = new TableColumn<>("Codice Fornitore");
        codiceFornitore.setCellValueFactory(new PropertyValueFactory<>("codiceFornitore"));
        TableColumn<FornitoriPiuAttivi, String> nome = new TableColumn<>("nome ");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<FornitoriPiuAttivi, Integer> numeroVendite = new TableColumn<>("numeroVendite");
        numeroVendite.setCellValueFactory(new PropertyValueFactory<>("numeroVendite"));
        
        this.tabListaFornitoriPiuAttivi.getColumns()
                .addAll(Arrays.asList(nome,codiceFornitore,numeroVendite));
        this.tabListaFornitoriPiuAttivi.setItems(this.queryFornitore.FornitoriPiuAttivi());
    }
    
    @FXML
    public void viewUtentiPiuAttivi() {
        this.tabListaUtentiPiuAttivi.getColumns().clear();
        TableColumn<UtentiPiùAttivi, String> nome = new TableColumn<>("Nome");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<UtentiPiùAttivi, String> cognome = new TableColumn<>("Cognome ");
        cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<UtentiPiùAttivi, Integer> conteggioRecensioni = new TableColumn<>("Numero Recensioni");
        conteggioRecensioni.setCellValueFactory(new PropertyValueFactory<>("conteggioRecensioni"));
        this.tabListaUtentiPiuAttivi.getColumns()
                .addAll(Arrays.asList(nome, cognome, conteggioRecensioni));
        this.tabListaUtentiPiuAttivi.setItems(this.queryVisitatore.UtentiPiùAttivi());
    }

    @FXML
    public void viewTopVisitatori() {
        this.tabTopVisitatori.getColumns().clear();
        TableColumn<Visitatore, String> nome = new TableColumn<>("Nome");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<Visitatore, String> cognome = new TableColumn<>("Cognome ");
        cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<Visitatore, String> cf = new TableColumn<>("Codice Fiscale");
        cf.setCellValueFactory(new PropertyValueFactory<>("cf"));
        TableColumn<Visitatore, Integer> numeroMostre = new TableColumn<>("Numero Mostre Visitate");
        numeroMostre.setCellValueFactory(new PropertyValueFactory<>("numeroMostre"));
        this.tabTopVisitatori.getColumns()
                .addAll(Arrays.asList(nome, cognome, cf,numeroMostre));
        this.tabTopVisitatori.setItems(this.queryVisitatore.viewTopVisitatori());
    }

    @FXML
    public void viewArtistaTopValore() {
        this.tabArtistaValore.getColumns().clear();
        TableColumn<Artista, String> nome = new TableColumn<>("Nome Arte");
        nome.setCellValueFactory(new PropertyValueFactory<>("nomeArte"));
        TableColumn<Artista, Integer> valore = new TableColumn<>("Valore ");
        valore.setCellValueFactory(new PropertyValueFactory<>("valore"));
        this.tabArtistaValore.getColumns()
                .addAll(Arrays.asList(nome, valore));
        this.tabArtistaValore.setItems(this.queryArtista.artistaTopValore());
    }
    
    @FXML
    public void viewMediaOpere() {
        this.tabMediaOpere.getColumns().clear();
        TableColumn<Mostra, String> nome = new TableColumn<>("Nome Mostra");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<Mostra, Float> media = new TableColumn<>("media ");
        media.setCellValueFactory(new PropertyValueFactory<>("media"));
        this.tabMediaOpere.getColumns()
                .addAll(Arrays.asList(nome, media));
        this.tabMediaOpere.setItems(this.queryMostra.mediaOpere());
    }

    @FXML
    public void viewArtistiNoOpere() {
        this.tabArtistiNoOpere.getColumns().clear();
        TableColumn<Artista, String> nome = new TableColumn<>("Nome Artista");
        nome.setCellValueFactory(new PropertyValueFactory<>("nomeArte"));
        this.tabArtistiNoOpere.getColumns()
                .addAll(Arrays.asList(nome));
        this.tabArtistiNoOpere.setItems(this.queryArtista.artistiNoOpere());
    }

    @FXML
    public void goBack() {
          this.view.setMainView();
    }
}
