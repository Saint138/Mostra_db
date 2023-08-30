package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.unibo.mostra.db.entity.Artista;
import it.unibo.mostra.db.entity.ClassificaOpere;
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
        final String query = "Select nome_arte, nome, cognome, data_di_nascita, data_decesso,breve_biografia "
                + " FROM Artista "
                + " WHERE nome_arte LIKE ?;";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, nome_arte + "%");
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Artista> list = FXCollections.observableArrayList();
            while (rs.next()) {
                list.add(new Artista(rs.getString("nome_arte"),rs.getString("nome"), rs.getString("cognome"), rs.getString("data_di_nascita"),
                        rs.getString("data_decesso"), rs.getString("breve_biografia")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ObservableList<Opera> viewRicercaOpera(String nome_opera) {
        final String query = "Select nome, nome_arte, anno_realizzazione, dimensioni, tecnica, descrizione "
                + " FROM Opera "
                + " WHERE nome LIKE ? ;";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, nome_opera + "%");
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Opera> list = FXCollections.observableArrayList();
            while (rs.next()) {
                list.add(new Opera(rs.getString("nome"),rs.getString("nome_arte"), rs.getString("anno_realizzazione"),
                        rs.getString("dimensioni"), rs.getString("tecnica"), rs.getString("descrizione")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ObservableList<Mostra> viewRicercaMostra(String nome_mostra) {
        final String query = "Select M.nome, M.città, M.data_inizio, M.data_fine, M.codice_mostra, M.numero_opere, M.valore,A.nome_arte"
                + " FROM Mostra M"
                + " JOIN Presenza P ON M.codice_mostra = P.codice_mostra"
                + " JOIN Artista A On P.nome_arte = A.nome_arte "
                + " JOIN Opera O ON P.nome_arte = O.nome_arte AND P.nome = O.nome"
                + " WHERE nome LIKE ?;";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, nome_mostra + "%");
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Mostra> list = FXCollections.observableArrayList();
            while (rs.next()) {
                list.add(new Mostra(rs.getString("nome"),rs.getString("città"), rs.getString("data_inizio"),
                        rs.getString("data_fine"), rs.getString("codice_mostra"), rs.getInt("numero_opere"),
                        rs.getInt("valore"),rs.getString("nome_arte")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ObservableList<ClassificaOpere> classificaValoreOpera() {
        final String query = " SELECT O.nome, V.importo"
                + " FROM OPERA O"
                + " INNER JOIN VENDITA V ON O.codice_vendita = V.codice_vendita"
                + " ORDER BY V.importo DESC;";

        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            final ResultSet rs = stmt.executeQuery();
            final ObservableList<ClassificaOpere> tab = FXCollections.observableArrayList();
            while (rs.next()) {
                tab.add(new ClassificaOpere(rs.getString("nome"), rs.getInt("importo")));

            }
            return tab;
        } catch (final SQLException e) {
            throw new IllegalStateException("Cannot execute the query!", e);
        }
    }

    public ObservableList<Mostra> classificaValoreMostra() {
        final String query = " SELECT nome, valore"
                + " FROM MOSTRA"
                + " ORDER BY valore DESC;";

        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            final ResultSet rs = stmt.executeQuery();
            final ObservableList<Mostra> tab = FXCollections.observableArrayList();
            while (rs.next()) {
                tab.add(new Mostra(rs.getString("nome"), rs.getInt("valore")));

            }
            return tab;
        } catch (final SQLException e) {
            throw new IllegalStateException("Cannot execute the query!", e);
        }
    }
}
