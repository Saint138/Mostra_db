package it.unibo.mostra.controller;


import java.util.Arrays;
import it.unibo.mostra.db.entity.refreshBiglietteria;
import it.unibo.mostra.db.query.QueryBiglietteria;
import it.unibo.mostra.view.ViewImpl;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class BiglietteriaController {
    
    private ViewImpl view;
    private QueryBiglietteria queryBiglietteria;
    @FXML private TableView<refreshBiglietteria> refreshBiglietteriaView;
    
    public BiglietteriaController(ViewImpl view, QueryBiglietteria queryBiglietteria) {
        this.view = view;
        this.queryBiglietteria = queryBiglietteria;
    }

    @FXML
    public void refreshBiglietteria() {
        this.refreshBiglietteriaView.getColumns().clear();
       TableColumn<refreshBiglietteria, String> nome = new TableColumn<>("Nome mostra");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<refreshBiglietteria, String> codice_visita = new TableColumn<>("Codice Visita");
        codice_visita.setCellValueFactory(new PropertyValueFactory<>("codice_visita"));
        TableColumn<refreshBiglietteria, String> data_inizio = new TableColumn<>("data Inizio");
        data_inizio.setCellValueFactory(new PropertyValueFactory<>("data_inizio"));
        TableColumn<refreshBiglietteria, String> data_fine = new TableColumn<>("Data Fine");
        data_fine.setCellValueFactory(new PropertyValueFactory<>("data_fine"));
        TableColumn<refreshBiglietteria, Float> prezzo = new TableColumn<>("prezzo");
        prezzo.setCellValueFactory(new PropertyValueFactory<>("prezzo"));
        System.out.println("fatto");
        this.refreshBiglietteriaView.getColumns().addAll(Arrays.asList(nome, codice_visita, data_inizio, data_fine, prezzo));
        this.refreshBiglietteriaView.setItems(this.queryBiglietteria.refreshBiglietteria());
    }



    @FXML
    public void newBiglietto() {
        /* */
    }

    @FXML
    public void goBack() {
          this.view.setMainView();
    }
}
