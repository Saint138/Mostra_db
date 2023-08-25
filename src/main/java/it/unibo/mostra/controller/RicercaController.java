package it.unibo.mostra.controller;

import java.util.Arrays;

import it.unibo.mostra.db.entity.Artista;
import it.unibo.mostra.db.entity.ClassificaOpere;
import it.unibo.mostra.db.entity.Mostra;
import it.unibo.mostra.db.entity.Opera;
import it.unibo.mostra.db.query.QueryRicerca;
import it.unibo.mostra.view.ViewImpl;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class RicercaController {
    private ViewImpl view;
    private QueryRicerca queryRicerca;
    @FXML private TextField nome_arte;
    @FXML private TextField nome_opera;
    @FXML private TextField nome_mostra;
    @FXML private TableView<Artista> viewRicercaArtista;
    @FXML private TableView<Opera> viewRicercaOpera;
    @FXML
    private TableView<Mostra> viewRicercaMostra;
    @FXML private TableView<ClassificaOpere> tabClassificaOpere;
    @FXML private TableView<Mostra> tabClassificaMostre;


    
    public RicercaController(ViewImpl view, QueryRicerca queryRicerca) {
       this.view = view;
       this.queryRicerca = queryRicerca;
    }

    
    @FXML
    public void goBack(){
        this.view.setMainView();
    }

    @FXML
    public void ricercaArtista() {
        this.viewRicercaArtista.getColumns().clear();
        TableColumn<Artista, String> nome = new TableColumn<>("Nome");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<Artista, String> cognome = new TableColumn<>("Cognome");
        cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<Artista, String> data_di_nascita = new TableColumn<>("Data Nascita");
        data_di_nascita.setCellValueFactory(new PropertyValueFactory<>("data_di_nascita"));
        TableColumn<Artista, String> data_decesso = new TableColumn<>("Data Decesso");
        data_decesso.setCellValueFactory(new PropertyValueFactory<>("data_decesso"));
        TableColumn<Artista, String> breve_biografia = new TableColumn<>("Breve Biografia");
        breve_biografia.setCellValueFactory(new PropertyValueFactory<>("breve_biografia"));
        this.viewRicercaArtista.getColumns()
                .addAll(Arrays.asList(nome, cognome, data_di_nascita, data_decesso, breve_biografia));
        this.viewRicercaArtista.setItems(this.queryRicerca.viewRicercaArtista(this.nome_arte.getText()));
        this.nome_arte.clear();
    }

     @FXML
     public void ricercaOpera() {
        this.viewRicercaOpera.getColumns().clear();
        TableColumn<Opera, String> annoRealizzazione = new TableColumn<>("Anno Realizzazione");
        annoRealizzazione.setCellValueFactory(new PropertyValueFactory<>("anno_realizzazione"));
        TableColumn<Opera, String> nomeArte = new TableColumn<>("Nome D'Arte");
        nomeArte.setCellValueFactory(new PropertyValueFactory<>("nome_arte"));
        TableColumn<Opera, String> dimensioni = new TableColumn<>("Dimensioni");
        dimensioni.setCellValueFactory(new PropertyValueFactory<>("dimensioni"));
        TableColumn<Opera, String> tecnica = new TableColumn<>("Tecnica");
        tecnica.setCellValueFactory(new PropertyValueFactory<>("tecnica"));
        TableColumn<Opera, String> descrizione = new TableColumn<>("Descrizione");
        descrizione.setCellValueFactory(new PropertyValueFactory<>("descrizione"));
        this.viewRicercaOpera.getColumns()
                .addAll(Arrays.asList(annoRealizzazione, nomeArte, dimensioni, tecnica, descrizione));
        this.viewRicercaOpera.setItems(this.queryRicerca.viewRicercaOpera(this.nome_opera.getText()));
        this.nome_opera.clear();
     }

     @FXML
     public void ricercaMostra() {
             this.viewRicercaMostra.getColumns().clear();
             TableColumn<Mostra, String> città = new TableColumn<>("Città");
             città.setCellValueFactory(new PropertyValueFactory<>("città"));
             TableColumn<Mostra, String> data_inizio = new TableColumn<>("Data Inizio");
             data_inizio.setCellValueFactory(new PropertyValueFactory<>("data_inizio"));
             TableColumn<Mostra, String> data_fine = new TableColumn<>("Data Fine");
             data_fine.setCellValueFactory(new PropertyValueFactory<>("data_fine"));
             TableColumn<Mostra, String> codice_mostra = new TableColumn<>("Codice Mostra");
             codice_mostra.setCellValueFactory(new PropertyValueFactory<>("codice_mostra"));
             TableColumn<Mostra, Integer> valore = new TableColumn<>("Valore");
             valore.setCellValueFactory(new PropertyValueFactory<>("valore"));
             TableColumn<Mostra, Integer> numero_opere = new TableColumn<>("Numero Opere");
             numero_opere.setCellValueFactory(new PropertyValueFactory<>("numero_opere"));
             this.viewRicercaMostra.getColumns()
                             .addAll(Arrays.asList(città, data_inizio, data_fine, codice_mostra, valore, numero_opere));
             this.viewRicercaMostra.setItems(this.queryRicerca.viewRicercaMostra(this.nome_mostra.getText()));
             nome_mostra.clear();
            
     }

     public void viewClassificaOpere() {
          this.tabClassificaOpere.getColumns().clear();
        TableColumn<ClassificaOpere, String> nome = new TableColumn<>("Nome");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<ClassificaOpere, Integer> valore = new TableColumn<>("valore ");
        valore.setCellValueFactory(new PropertyValueFactory<>("valore"));
        this.tabClassificaOpere.getColumns()
                .addAll(Arrays.asList(nome, valore));
        this.tabClassificaOpere.setItems(this.queryRicerca.classificaValoreOpera());
     }
     
     public void viewClassificaMostre(){
        this.tabClassificaMostre.getColumns().clear();
        TableColumn<Mostra, String> nome = new TableColumn<>("Nome");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<Mostra, Integer> valore = new TableColumn<>("valore ");
        valore.setCellValueFactory(new PropertyValueFactory<>("valore"));
        this.tabClassificaMostre.getColumns()
                .addAll(Arrays.asList(nome, valore));
        this.tabClassificaMostre.setItems(this.queryRicerca.classificaValoreMostra());
     }
}

