package it.unibo.mostra.controller;

import java.util.Arrays;

import it.unibo.mostra.db.entity.Recensione;
import it.unibo.mostra.db.query.QueryRecensione;
import it.unibo.mostra.view.ViewImpl;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class RecensioneController {
    private ViewImpl view;
    private QueryRecensione queryRecensione;
    @FXML private TextField testo;
    @FXML private TextField cf;
    @FXML private TextField codice_mostra;
    @FXML private TableView<Recensione> refreshRecensioneView;

    public RecensioneController (ViewImpl view, QueryRecensione queryRecensione){
        this.view = view;
        this.queryRecensione = queryRecensione;
    }

    @FXML
    public void refreshRecensione() {
        this.refreshRecensioneView.getColumns().clear();
       TableColumn<Recensione, String> nome = new TableColumn<>("nome");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<Recensione, String> cognome = new TableColumn<>("cognome");
        cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<Recensione, String> codice_recensione = new TableColumn<>("codice recensione");
        codice_recensione.setCellValueFactory(new PropertyValueFactory<>("codice_recensione"));
        TableColumn<Recensione, String> commento = new TableColumn<>("commento");
        commento.setCellValueFactory(new PropertyValueFactory<>("commento"));
        TableColumn<Recensione, Integer> valutazione = new TableColumn<>("valutazione");
        valutazione.setCellValueFactory(new PropertyValueFactory<>("valutazione"));
        TableColumn<Recensione, String> data_recensione = new TableColumn<>("Data");
        data_recensione.setCellValueFactory(new PropertyValueFactory<>("data_recensione"));
        TableColumn<Recensione, String> codice_mostra = new TableColumn<>("mostra");
        codice_mostra.setCellValueFactory(new PropertyValueFactory<>("codice_mostra"));
        this.refreshRecensioneView.getColumns().addAll(Arrays.asList(nome, cognome, codice_recensione, commento, valutazione, data_recensione, codice_mostra));
        this.refreshRecensioneView.setItems(this.queryRecensione.refreshRecensione());
    }

    @FXML
    public void newRecensione() {
        /* */
    }

    @FXML
    public void goBack() {
        this.view.setMainView();
    }
}
