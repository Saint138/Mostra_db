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
    private TextField matricola;
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
        codiceTurno.setCellValueFactory(new PropertyValueFactory<>("codice_turno"));
        TableColumn<Turno, String> dataTurno = new TableColumn<>("dataTurno");  
        dataTurno.setCellValueFactory(new PropertyValueFactory<>("data_turno"));
        TableColumn<Turno, String> oraInizio = new TableColumn<>(" Ora Inizio");
        oraInizio.setCellValueFactory(new PropertyValueFactory<>("ora_inizio"));
        TableColumn<Turno, String> oraFine = new TableColumn<>("Ora Fine");
        oraFine.setCellValueFactory(new PropertyValueFactory<>("ora_fine"));
        TableColumn<Turno, String> codiceMostra = new TableColumn<>("Codice Mostra");
        codiceMostra.setCellValueFactory(new PropertyValueFactory<>("codice_mostra"));
        this.tabTurniDipendente.getColumns().addAll(Arrays.asList(codiceTurno, dataTurno, oraInizio, oraFine, codiceMostra));
        this.tabTurniDipendente.setItems(this.queryTurno.refreshTurniDipendente(this.matricola.getText()));
    }

}
