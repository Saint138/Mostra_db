package it.unibo.mostra.controller;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.ResourceBundle;

import it.unibo.mostra.db.entity.RefreshMostra;
import it.unibo.mostra.db.query.QueryMostra;
import it.unibo.mostra.db.query.QueryVisitatore;
import it.unibo.mostra.view.ViewImpl;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainViewController {
    
    private ViewImpl view;
    private QueryMostra queryMain;
    private QueryVisitatore queryVisitatore;
    @FXML
    private TableView<RefreshMostra> refreshMostraView;
    @FXML
    private TextField nome, cognome, cf, email;

    public MainViewController(ViewImpl view, QueryMostra queryMain,QueryVisitatore queryVisitatore) {
        this.queryMain = queryMain;
        this.queryVisitatore = queryVisitatore;
        this.view = view;
    }

    @FXML
    public void initialize() {
        refreshMostra();
    }

    @FXML
    public void enterBigliettoView() {
        this.view.setBiglietteriaView();
    }
    @FXML
    public void enterRicercaView() {
        this.view.setRicercaView();
    }
    @FXML
    public void enterRecensioneView() {
          this.view.setRecensioneView();
    }

    @FXML
    public void refreshMostra() {
        this.refreshMostraView.getColumns().clear();
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
        this.refreshMostraView.getColumns()
                .addAll(Arrays.asList(nomeMostra, codiceMostra, città, dataInizio, dataFine));
        this.refreshMostraView.setItems(this.queryMain.refreshMostra());

    }
    @FXML
    public void goAdminLoginView() {
          this.view.setAdminLoginView();
    }
    @FXML
    public void goDipendenteLoginView() {
         this.view.setDipendeteLoginView();
    }
    @FXML
    public void goBack() {
        this.view.setHomeView();
    }
    @FXML
    
    public void submitUtente() {
        try{
            queryVisitatore.addVisitatore(cf.getText(),email.getText(),nome.getText(),cognome.getText());
            nome.clear();
            cognome.clear();
            cf.clear();
            email.clear();
        } catch (SQLIntegrityConstraintViolationException e) {
            cf.clear();
            cf.setPromptText("Errore di inserimento");
            cf.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalArgumentException(e);
        } catch (SQLException e) {
            cf.clear();
            cf.setPromptText("Errore di inserimento");
            cf.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }
}
