package it.unibo.mostra.controller;

import java.util.Arrays;

import it.unibo.mostra.db.entity.Recensione;
import it.unibo.mostra.db.entity.refreshBiglietteria;
import it.unibo.mostra.db.query.QueryRecensione;
import it.unibo.mostra.view.ViewImpl;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RecensioneController {
    private ViewImpl view;
    private QueryRecensione queryRecensione;
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
        TableColumn<Recensione, String> codice_visita = new TableColumn<>("cognome");
        codice_visita.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<Recensione, String> data_inizio = new TableColumn<>("codice fiscale");
        data_inizio.setCellValueFactory(new PropertyValueFactory<>("cf"));
        TableColumn<Recensione, String> data_fine = new TableColumn<>("commento");
        data_fine.setCellValueFactory(new PropertyValueFactory<>("commento"));
        TableColumn<Recensione, Integer> prezzo = new TableColumn<>("valutazione");
        prezzo.setCellValueFactory(new PropertyValueFactory<>("valutazione"));
        System.out.println("fatto");
        this.refreshRecensioneView.getColumns().addAll(Arrays.asList(nome, codice_visita, data_inizio, data_fine, prezzo));
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
