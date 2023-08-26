package it.unibo.mostra.controller;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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

    @FXML private TextField Cf;
    @FXML private TextField codiceMostra;
    @FXML private TextField commento;
    @FXML private TextField valutazione;


    public RecensioneController(ViewImpl view, QueryRecensione queryRecensione) {
        this.view = view;
        this.queryRecensione = queryRecensione;
    }
    @FXML
    public void initialize() {
            refreshRecensione();
            
    }

    @FXML
    public void refreshRecensione() {
        this.refreshRecensioneView.getColumns().clear();
        TableColumn<Recensione, String> email = new TableColumn<>("email");
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        TableColumn<Recensione, String> nomeMostra = new TableColumn<>("Nome Mostra");
        nomeMostra.setCellValueFactory(new PropertyValueFactory<>("nomeMostra"));
        TableColumn<Recensione, Integer> valutazione = new TableColumn<>("Valutazione");
        valutazione.setCellValueFactory(new PropertyValueFactory<>("valutazione"));
        TableColumn<Recensione, String> commento = new TableColumn<>("Commento");
        commento.setCellValueFactory(new PropertyValueFactory<>("commento"));
        this.refreshRecensioneView.getColumns().addAll(Arrays.asList(email, nomeMostra, valutazione, commento));
        this.refreshRecensioneView.setItems(this.queryRecensione.refreshRecensione());
    }

    @FXML
    public void newRecensione() {
        try {
            this.queryRecensione.addRecensione(Cf.getText(), commento.getText(), codice_mostra.getText(),
                    Integer.parseInt(valutazione.getText()));
            Cf.clear();
            commento.clear();
            valutazione.clear();
            codice_mostra.clear();
            this.refreshRecensione();
        } catch (SQLIntegrityConstraintViolationException e) {
            Cf.clear();
            Cf.setPromptText("Errore di inserimento");
            Cf.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalArgumentException(e);
        } catch (SQLException e) {
            Cf.clear();
            Cf.setPromptText("Errore di inserimento");
            Cf.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void goBack() {
        this.view.setMainView();
    }
}
