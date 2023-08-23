package it.unibo.mostra.controller;

import java.util.HashSet;
import java.util.Set;
import it.unibo.mostra.utils.Pair;
import it.unibo.mostra.view.ViewImpl;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AdminLoginController{

    private String user;
    private String pass;
    private ViewImpl view;
    private Set<Pair<String, String>> admin;
     
    @FXML private TextField username;
    @FXML private PasswordField password;

    /**
     * Constructor for the controller.
     * @param view the view.
     */
    public AdminLoginController(ViewImpl view){
        this.view = view;
        this.user = "admin";
        this.pass = "admin";
        this.admin = new HashSet<>();
        this.admin.add(new Pair<>(this.user, this.pass));
    }

    @FXML
    public void enterAdminPage() {
        
        if (this.admin.contains(new Pair<>(this.username.getText(), this.password.getText()))) {
            this.view.setAdminView();
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
    public void goHome() {
          this.view.setMainView();
    }
    
}