package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.unibo.mostra.db.entity.Artista;
import it.unibo.mostra.db.entity.Mostra;
import it.unibo.mostra.db.entity.Opera;
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
            while (rs.next()) {
                list.add(new Artista(rs.getString("nome"), rs.getString("cognome"), rs.getString("data_di_nascita"),
                        rs.getString("data_decesso"), rs.getString("breve_biografia")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ObservableList<Opera> viewRicercaOpera(String nome_opera) {
        final String query = "Select nome_arte, anno_realizzazione, dimensioni,tecnica,descrizione "
                + " FROM Opera "
                + "WHERE nome=? ";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, nome_opera);
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Opera> list = FXCollections.observableArrayList();
            while (rs.next()) {
                list.add(new Opera(rs.getString("nome_arte"), rs.getString("anno_realizzazione"),
                        rs.getString("dimensioni"), rs.getString("tecnica"), rs.getString("descrizione")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ObservableList<Mostra> viewRicercaMostra(String nome_mostra) {
        final String query = "Select città, data_inizio, data_fine,codice_mostra,numero_opere,valore "
                            + " FROM Mostra "
                            + "WHERE nome=? ";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, nome_mostra);
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Mostra> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new Mostra(rs.getString("città"), rs.getString("data_inizio"),
                                            rs.getString("data_fine"),rs.getString("codice_mostra"), rs.getInt("numero_opere"),rs.getInt("valore")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
