package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.unibo.mostra.db.entity.Artista;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class QueryRicerca {
    
     private Connection connection;

    public QueryRicerca(Connection connection){
        this.connection = connection;
    }



    public ObservableList<Artista> viewRicercaArtista(String nome_arte) {
        final String query = "Select nome, cognome, data_di_nascita, data_decesso,breve_biografia "
        + " FROM Artista "
                + "WHERE nome_arte=? ";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, nome_arte);
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Artista> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new Artista(rs.getString("nome"), rs.getString("cognome"), rs.getString("data_di_nascita"),
                                              rs.getString("data_decesso"), rs.getString("breve_biografia")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
