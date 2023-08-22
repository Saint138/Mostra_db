package it.unibo.mostra.controller;

import java.sql.Connection;

import it.unibo.mostra.db.ConnectionManager;
import it.unibo.mostra.view.ViewImpl;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DipendenteLoginController{

    private ViewImpl view;
    @FXML TextField username;
    @FXML TextField password;

    /**
     * Constructor for the controller.
     * @param view the view.
     */
    public DipendenteLoginController(ViewImpl view){
        this.view = view;
    }

    @FXML
    public void enterTurniDipendente() {
        try {
            final ConnectionManager connectClass = new ConnectionManager(this.username.getText(),
                    this.password.getText());
            Connection connection = connectClass.getSQLConnection();
            this.view.addConnection(connection);
        } catch (Exception e) {
            this.username.clear();
            this.password.clear();
            this.username.setPromptText("Username errato");
            this.password.setPromptText("Password errata");
            this.username.setStyle("-fx-prompt-text-fill: red");
            this.password.setStyle("-fx-prompt-text-fill: red");
            throw new IllegalStateException(e);
        }
    }
    
    @FXML
    public void goHome() {
          this.view.setHomeView();
    }
    
}