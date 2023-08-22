package it.unibo.mostra.controller;

import java.util.HashSet;
import java.util.Set;
import it.unibo.mostra.utils.Pair;
import it.unibo.mostra.view.ViewImpl;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class DipendenteLoginController{
    private String user;
    private String pass;
    private ViewImpl view;
    private Set<Pair<String, String>> dipendenti;
     
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public DipendenteLoginController(ViewImpl view){
        this.view = view;
        this.user = "dipendente";
        this.pass = "dipendente";
        this.dipendenti = new HashSet<>();
        this.dipendenti.add(new Pair<>(this.user, this.pass));
    }

    @FXML
    public void checkAccess() {
        
        if (this.dipendenti.contains(new Pair<>(this.username.getText(), this.password.getText()))) {
            /*this.view.setDipendenteTurni();*/
        } else {
            this.username.clear();
            this.username.setPromptText("Username o password sbagliata");
            this.username.setStyle("-fx-prompt-text-fill: red;");
            this.password.clear();
            this.password.setPromptText("Password sbagliata");
            this.password.setStyle("-fx-prompt-text-fill: red;");
        }
    }
    
    @FXML
    public void goBack() {
          this.view.setHomeView();
    }
    
}