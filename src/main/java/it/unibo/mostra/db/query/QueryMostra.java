package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;

import it.unibo.mostra.db.entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class QueryMostra {

    private Connection connection;

    public QueryMostra(Connection connection) {
        this.connection = connection;
    }

    /* 
    public ObservableList<Recensione> MediaRecensioniMostra(){
        final String query = "SELECT M.nome, COUNT( R.codice_recensione) as numero_recensioni, AVG(R.valutazione) as media"
                            + "FROM Mostra M"
                            + "JOIN Recensione R on M.codice_mostra = R.codice_mostra"
                            + "GROUP BY M.nome";
    
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            final ResultSet rs = stmt.executeQuery();
    
            final ObservableList<Recensione> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new Recensione(rs.getString("M.nome"), rs.getString("numero_recensioni"),rs.getString("media")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    
    }
    
    public ObservableList<Recensione> RecensioniNegativeMostra(){
        final String query = "SELECT M.nome"
                            + "FROM Mostra M"
                            + "JOIN Recensione R ON M.codice_mostra = R.codice_mostra"
                            + "WHERE R.valutazione <= 5"
                            + "GROUP BY M.nome"
                            + "HAVING COUNT(*) >= 5";
        
    
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            final ResultSet rs = stmt.executeQuery();
    
            final ObservableList<Recensione> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new Recensione(rs.getString("M.nome")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    
    } */

    public ObservableList<GuadagnoMostraTotale> GuadagnoMostra(){
        final String query = " SELECT M.nome AS nome_mostra, SUM(B.prezzo) AS valore"
                            + " FROM MOSTRA M"
                            + " JOIN VISITA V ON M.codice_mostra = V.codice_mostra"
                            + " JOIN BIGLIETTO B ON V.codice_visita = B.codice_visita"
                            + " GROUP BY M.nome"
                            + " ORDER BY valore DESC;";
        
    
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            final ResultSet rs = stmt.executeQuery();
    
            final ObservableList<GuadagnoMostraTotale> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new GuadagnoMostraTotale(rs.getString("nome_mostra"),rs.getString("valore")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    
    }
    //inserire una nuova mostra
    
    public void addMostra(String nome, String città, Timestamp data_inizio, String codiceMostra,Timestamp data_fine) 
                            throws SQLException, SQLIntegrityConstraintViolationException {
        final String query = "INSERT INTO MOSTRA (nome, città, data_inizio, data_fine, codice_mostra, numero_opere, valore) "
                            + "VALUES (?, ?, ?, ?, ?, ?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nome);
            stmt.setString(2, città);
            stmt.setTimestamp(3, data_inizio);
            stmt.setTimestamp(4, data_fine);
            stmt.setString(5, codiceMostra);
            stmt.setFloat(6, 0);
            stmt.setInt(7, 0);

            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("mostra già inserita");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
    public ObservableList<RefreshMostra> refreshMostra(){
        final String query = "SELECT nome,codice_mostra,città,data_inizio,data_fine "
                            + "FROM Mostra ";

                            try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
                                final ResultSet rs = stmt.executeQuery();
                    
                                final ObservableList<RefreshMostra> list = FXCollections.observableArrayList();
                                while (rs.next()) {
                                    list.add(new RefreshMostra(rs.getString("nome"), rs.getString("codice_mostra"), rs.getString("città"),
                                                                 rs.getString("data_inizio"),rs.getString("data_fine")));
                                }
                                return list;
                            } catch (final SQLException e) {
                                throw new IllegalStateException("Cannot execute the query!", e);
                            
                            }
    }

    public void removeMostra(String codiceMostra) throws SQLException {
        final String query = "DELETE FROM Mostra WHERE codice_mostra=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, codiceMostra);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        final String query2 = "DELETE FROM Visita WHERE codice_mostra=?";
          try (PreparedStatement statement = connection.prepareStatement(query2)) {
            statement.setString(1, codiceMostra);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
         final String query3 = "DELETE FROM Turno WHERE codice_mostra=?";
          try (PreparedStatement statement = connection.prepareStatement(query3)) {
            statement.setString(1, codiceMostra);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
         final String query4 = "DELETE FROM Presenza WHERE codice_mostra=?";
          try (PreparedStatement statement = connection.prepareStatement(query4)) {
            statement.setString(1, codiceMostra);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
         
    }

}