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
        TableColumn<Turno, String> oraInizio = new TableColumn<>(" Ora Inizio");
        oraInizio.setCellValueFactory(new PropertyValueFactory<>("oraInizio"));
        TableColumn<Turno, String> oraFine = new TableColumn<>("Ora Fine");
        oraFine.setCellValueFactory(new PropertyValueFactory<>("oraFine"));
        TableColumn<Turno, String> nomeMostra = new TableColumn<>("Nome Mostra");
        nomeMostra.setCellValueFactory(new PropertyValueFactory<>("nomeMostra"));
        TableColumn<Turno, String> nomeRuolo = new TableColumn<>("Ruolo");
        nomeRuolo.setCellValueFactory(new PropertyValueFactory<>("ruolo"));
         TableColumn<Turno, Integer> stipendio = new TableColumn<>("Stipendio");
        stipendio.setCellValueFactory(new PropertyValueFactory<>("stipendio"));
        this.tabTurniDipendente.getColumns().addAll(Arrays.asList(codiceTurno, oraInizio, oraFine, nomeMostra,nomeRuolo,stipendio));
        this.tabTurniDipendente.setItems(this.queryTurno.refreshTurniDipendente(this.codice_contratto.getText()));
    }

    

}
