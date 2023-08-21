package it.unibo.mostra.controller;

import it.unibo.mostra.db.query.QueryMostra;
import it.unibo.mostra.view.ViewImpl;
import javafx.fxml.FXML;

public class mainViewController {
    
    private ViewImpl view;
    private QueryMostra queryMain;

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
    public void setRecensioneView() {
          this.view.setRecensioneView();
    }


}
