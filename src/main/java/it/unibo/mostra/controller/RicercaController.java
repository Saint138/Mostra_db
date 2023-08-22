package it.unibo.mostra.controller;

import java.util.Arrays;

import it.unibo.mostra.db.entity.Artista;
import it.unibo.mostra.db.entity.Mostra;
import it.unibo.mostra.db.entity.Opera;
import it.unibo.mostra.db.query.QueryRicerca;
import it.unibo.mostra.view.ViewImpl;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class RicercaController {
    private ViewImpl view;
    private QueryRicerca queryRicerca;
    @FXML private TextField nome_arte;
    @FXML private TextField nome_opera;
    @FXML private TextField nome_mostra;
    @FXML private TableView<Artista> ricercaArtista;
    @FXML private TableView<Opera> ricercaOpera;
    @FXML private TableView<Mostra> ricercaMostra;

    
    public RicercaController(ViewImpl view, QueryRicerca queryRicerca) {
       this.view = view;
       this.queryRicerca = queryRicerca;
    }

    
    @FXML
    public void goHome(){
        this.view.setMainView();
    }

    @FXML
    public void ricercaArtista() {
        this.ricercaArtista.getColumns().clear();
        TableColumn<Artista, String> nome = new TableColumn<>("Nome");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<Artista, String> cognome = new TableColumn<>("Cognome");
        cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<Artista, String> data_di_nascita = new TableColumn<>("Data Nascita");
        data_di_nascita.setCellValueFactory(new PropertyValueFactory<>("data_di_nascita"));
        TableColumn<Artista, String> data_decesso = new TableColumn<>("Data Decesso");
        data_decesso.setCellValueFactory(new PropertyValueFactory<>("data_decesso"));
        TableColumn<Artista, String> breve_biografia = new TableColumn<>("Breve Biografia");
        breve_biografia.setCellValueFactory(new PropertyValueFactory<>("breve_biografia"));
        this.ricercaArtista.getColumns()
                .addAll(Arrays.asList(nome, cognome, data_di_nascita, data_decesso, breve_biografia));
        this.ricercaArtista.setItems(this.queryRicerca.viewRicercaArtista(this.nome_arte.getText()));
        this.nome_arte.clear();
    }

     @FXML
     public void ricercaOpera() {
     }

     @FXML
     public void ricercaMostra() {
     }
}
