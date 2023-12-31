package it.unibo.mostra.view;

import java.sql.Connection;
import it.unibo.mostra.controller.HomeController;
import it.unibo.mostra.controller.AdminLoginController;
import it.unibo.mostra.controller.AdminViewController;
import it.unibo.mostra.controller.BiglietteriaController;
import it.unibo.mostra.controller.DipendenteLoginController;
import it.unibo.mostra.controller.MainViewController;
import it.unibo.mostra.controller.RecensioneController;
import it.unibo.mostra.controller.RicercaController;
import it.unibo.mostra.controller.TurniDipendenteController;
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
    private QueryVisitatore queryVisitatore;
    private QueryVisita queryVisita;
    private QueryRicerca queryRicerca;
    private QueryBiglietteria queryBiglietteria;
    private QueryVendita queryVendita;
    private QueryArtista queryArtista;
    private QueryPresenza queryPresenza;
    private QueryTurno queryTurno;
    /**
     * Constructor for the view.
     * 
     * @param primaryStage the stage.
     */
    public ViewImpl(final Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Associazione Culturale");
        primaryStage.getIcons().add(new Image(ClassLoader.getSystemResource("images/logo.jpg").toExternalForm()));
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        this.setHomeView();
        primaryStage.show();
    }
    


    @Override
    public void setHomeView() {
        try {
            final var loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/HomeView.fxml"));
            loader.setController(new HomeController(this));
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setAdminLoginView() {
        try {
            final var loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/adminLoginView.fxml"));
            loader.setController(new AdminLoginController(this));
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setDipendeteLoginView() {
        try {
            final var loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/dipendenteLoginView.fxml"));
            loader.setController(new DipendenteLoginController(this));
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setMainView() {
        try{
            final var loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/MainView.fxml"));
            loader.setController(new MainViewController(this, queryMostra,queryVisitatore));
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setRicercaView() {
        try {
            final var loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/ricercaView.fxml"));
            loader.setController(new RicercaController(this,queryRicerca));
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setBiglietteriaView() {
        try {
            final var loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/BiglietteriaView.fxml"));
            loader.setController(new BiglietteriaController(this,queryBiglietteria));
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setRecensioneView() {
        try {
            final var loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/RecensioneView.fxml"));
            loader.setController(new RecensioneController(this,queryRecensione));
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setAdminView() {
       try {
            final var loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/AdminView.fxml"));
            loader.setController(new AdminViewController(this,queryVisita,queryOpera,queryMostra,queryFornitore,queryDipendenti,queryVisitatore,queryVendita,queryArtista,queryPresenza,queryTurno));
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setDipendenteTurni() {
        try {
            final var loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/turniDipendenteView.fxml"));
            loader.setController(new TurniDipendenteController(this,queryTurno));
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void addConnection(final Connection connection) {
        this.queryRecensione = new QueryRecensione(connection);
        this.queryFornitore = new QueryFornitore(connection);
        this.queryDipendenti = new QueryDipendenti(connection);
        this.queryMostra = new QueryMostra(connection);
        this.queryVisitatore = new QueryVisitatore(connection);
        this.queryVisita = new QueryVisita(connection);
        this.queryOpera = new QueryOpera(connection);
        this.queryVendita = new QueryVendita(connection);
        this.queryRicerca = new QueryRicerca(connection);
        this.queryArtista = new QueryArtista(connection);
        this.queryBiglietteria = new QueryBiglietteria(connection);
        this.queryTurno = new QueryTurno(connection);
        this.queryPresenza = new QueryPresenza(connection);
        
    }

    
    
}
