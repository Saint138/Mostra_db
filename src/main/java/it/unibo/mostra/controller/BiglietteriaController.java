package it.unibo.mostra.controller;


import java.util.Arrays;
import it.unibo.mostra.db.entity.RefreshBiglietteria;
import it.unibo.mostra.db.query.QueryBiglietteria;
import it.unibo.mostra.view.ViewImpl;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class BiglietteriaController {
    
    private ViewImpl view;
    private QueryBiglietteria queryBiglietteria;
    @FXML
    private TableView<RefreshBiglietteria> refreshBiglietteriaView;
    @FXML
    private TextField cf;
    @FXML
    private TextField cod_visita;
    
    public BiglietteriaController(ViewImpl view, QueryBiglietteria queryBiglietteria) {
        this.view = view;
        this.queryBiglietteria = queryBiglietteria;
    }

    @FXML
    public void initialize() {
        refreshBiglietteria();
    }

    @FXML
    public void refreshBiglietteria() {
        this.refreshBiglietteriaView.getColumns().clear();
        TableColumn<RefreshBiglietteria, String> nome = new TableColumn<>("Nome");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<RefreshBiglietteria, String> codiceVisita = new TableColumn<>("Codice Visita ");
        codiceVisita.setCellValueFactory(new PropertyValueFactory<>("codiceVisita"));
        TableColumn<RefreshBiglietteria, String> dataInizio = new TableColumn<>("Data Inizio");
        dataInizio.setCellValueFactory(new PropertyValueFactory<>("dataInizio"));
        TableColumn<RefreshBiglietteria, String> dataFine = new TableColumn<>("Data Fine");
        dataFine.setCellValueFactory(new PropertyValueFactory<>("dataFine"));
        this.refreshBiglietteriaView.getColumns()
                .addAll(Arrays.asList(nome,codiceVisita,dataInizio, dataFine));
        this.refreshBiglietteriaView.setItems(this.queryBiglietteria.refreshBiglietteria());
    }



    @FXML
    public void newBiglietto() {
        this.queryBiglietteria.newBiglietto(cf.getText(),cod_visita.getText());
        cf.clear();
        cod_visita.clear();
    }

    @FXML
    public void goBack() {
          this.view.setMainView();
    }
}
