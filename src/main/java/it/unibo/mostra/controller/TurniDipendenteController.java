package it.unibo.mostra.controller;

import java.util.Arrays;

import it.unibo.mostra.db.entity.Turno;
import it.unibo.mostra.db.query.QueryTurno;
import it.unibo.mostra.view.ViewImpl;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TurniDipendenteController {
    
    private ViewImpl view;
    private QueryTurno queryTurno;
    @FXML
    private TextField codice_contratto;
    @FXML
    private TableView<Turno> tabTurniDipendente;

    public TurniDipendenteController(ViewImpl view, QueryTurno queryTurno) {
        this.queryTurno = queryTurno;
        this.view = view;
    }
    
    @FXML
    public void goBack() {
        this.view.setDipendeteLoginView();
    }
    @FXML
    public void refreshTurniDipendente() {
        this.tabTurniDipendente.getColumns().clear();
       TableColumn<Turno, String> codiceTurno = new TableColumn<>("Codice Turno");
        codiceTurno.setCellValueFactory(new PropertyValueFactory<>("codiceTurno"));
        TableColumn<Turno, String> dataTurno = new TableColumn<>("Data Turno");  
        dataTurno.setCellValueFactory(new PropertyValueFactory<>("dataTurno"));
        TableColumn<Turno, String> oraInizio = new TableColumn<>(" Ora Inizio");
        oraInizio.setCellValueFactory(new PropertyValueFactory<>("oraInizio"));
        TableColumn<Turno, String> oraFine = new TableColumn<>("Ora Fine");
        oraFine.setCellValueFactory(new PropertyValueFactory<>("oraFine"));
        TableColumn<Turno, String> codiceMostra = new TableColumn<>("Codice Mostra");
        codiceMostra.setCellValueFactory(new PropertyValueFactory<>("codiceMostra"));
        this.tabTurniDipendente.getColumns().addAll(Arrays.asList(codiceTurno, dataTurno, oraInizio, oraFine, codiceMostra));
        this.tabTurniDipendente.setItems(this.queryTurno.refreshTurniDipendente(this.codice_contratto.getText()));
    }

    

}
