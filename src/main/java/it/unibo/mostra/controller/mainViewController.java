package it.unibo.mostra.controller;

import java.util.Arrays;

import it.unibo.mostra.db.entity.Mostra;
import it.unibo.mostra.db.entity.refreshMostraView;
import it.unibo.mostra.db.query.QueryMostra;
import it.unibo.mostra.view.ViewImpl;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class mainViewController {
    
    private ViewImpl view;
    private QueryMostra queryMain;
    @FXML private TableView<refreshMostraView> refreshMostraView;

    public mainViewController(ViewImpl view, QueryMostra queryMain) {
        this.queryMain = queryMain;
        this.view = view;
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
       TableColumn<refreshMostraView, String> nomeMostra = new TableColumn<>("Nome mostra");
        nomeMostra.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<refreshMostraView, String> codiceMostra = new TableColumn<>("Codice Mostra");
        codiceMostra.setCellValueFactory(new PropertyValueFactory<>("codiceMostra"));
        TableColumn<refreshMostraView, String> città = new TableColumn<>("Città");
        città.setCellValueFactory(new PropertyValueFactory<>("città"));
        TableColumn<refreshMostraView, String> dataInizio = new TableColumn<>("Data Inizio");
        dataInizio.setCellValueFactory(new PropertyValueFactory<>("dataInizio"));
        TableColumn<refreshMostraView, String> dataFine = new TableColumn<>("Data Fine");
        dataFine.setCellValueFactory(new PropertyValueFactory<>("dataFine"));
        this.refreshMostraView.getColumns().addAll(Arrays.asList(nomeMostra, codiceMostra, città, dataInizio, dataFine));
        this.refreshMostraView.setItems(this.queryMain.refreshMostra());

    }
    
    
}
