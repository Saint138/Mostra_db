package it.unibo.mostra.view;

import java.sql.Connection;

import javax.security.auth.login.LoginContext;

import it.unibo.mostra.controller.LoginController;
import it.unibo.mostra.db.query.*;
import it.unibo.mostra.view.api.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ViewImpl implements View {

    private Stage primaryStage;
    private QueryDipendenti queryDipendenti;
    private QueryMostra queryMostra;
    private QueryFornitore queryFornitore;
    private QueryOpera queryOpera;
    private QueryRecensione queryRecensione;
    private QueryUtente queryUtente;
    private QueryVisita queryVisita;
    /**
     * Constructor for the view.
     * 
     * @param primaryStage the stage.
     */
    public ViewImpl(final Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("MostraDb");
        /*primaryStage.getIcons().add(new Image(ClassLoader.getSystemResource("images/Logo.png").toExternalForm()));*/
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        this.setHomeView();
        primaryStage.show();
    }
    


    @Override
    public void setHomeView() {
        try {
            final var loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/loginView.fxml"));
            loader.setController(new LoginController(this));
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setAdminLoginView() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setAdminLoginView'");
    }

    @Override
    public void setDipendeteLoginView() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDipendeteLoginView'");
    }

    @Override
    public void setMainView() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setMainView'");
    }

    @Override
    public void setRicercaView() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setRicercaView'");
    }

    @Override
    public void setBiglietteriaView() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setBiglietteriaView'");
    }

    @Override
    public void setRecensioneView() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setRecensioneView'");
    }

    @Override
    public void setAdminAdd() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setAdminAdd'");
    }

    @Override
    public void setDipendenteTurni() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDipendenteTurni'");
    }



    public void addConnection(final Connection connection) {
        this.queryRecensione = new QueryRecensione(connection);
        this.queryFornitore = new QueryFornitore(connection);
        this.queryDipendenti = new QueryDipendenti(connection);
        this.queryMostra = new QueryMostra(connection);
        this.queryUtente = new QueryUtente(connection);
        this.queryVisita = new QueryVisita(connection);
        this.queryOpera = new QueryOpera(connection);
    }

    
    
}
