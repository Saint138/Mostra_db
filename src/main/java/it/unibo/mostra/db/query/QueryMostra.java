package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import it.unibo.mostra.db.entity.*;
import it.unibo.mostra.utils.DateAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class QueryMostra {

    private Connection connection;

    public QueryMostra(Connection connection) {
        this.connection = connection;
    }

    
    public ObservableList<MediaRecensioniMostra> MediaRecensioni(){
         final String query = " SELECT M.nome AS mostra, AVG(R.valutazione) AS media_valutazione"
                            + " FROM MOSTRA M"
                            + " LEFT JOIN RECENSIONE R ON M.codice_mostra = R.codice_mostra"
                            + " GROUP BY M.nome"
                            + " ORDER BY media_valutazione DESC;";
    
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            final ResultSet rs = stmt.executeQuery();
    
            final ObservableList<MediaRecensioniMostra> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new MediaRecensioniMostra(rs.getString("mostra"), rs.getFloat("media_valutazione")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    
    }
    
    public ObservableList<NumeroRecensioniNegative> RecensioniNegativeMostra(){
        final String query = " SELECT M.nome AS mostra, COUNT(R.codice_recensione) AS recensioni_negative"
                            + " FROM Mostra M"
                            + " JOIN RECENSIONE R ON M.codice_mostra = R.codice_mostra"
                            + " WHERE R.valutazione < 5"
                            + " GROUP BY M.nome"
                            + " ORDER BY recensioni_negative DESC;";
    
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            final ResultSet rs = stmt.executeQuery();
    
            final ObservableList<NumeroRecensioniNegative> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new NumeroRecensioniNegative(rs.getString("nome"), rs.getInt("recensioni_negative")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    
    } 

     public ObservableList<BigliettiMostraTotale> BigliettiTotali(){
        final String query = " SELECT M.nome AS mostra, COUNT(B.codice_biglietto) AS biglietti_venduti"
                            + " FROM MOSTRA M"
                            + " JOIN VISITA V ON M.codice_mostra = V.codice_mostra"
                            + " JOIN BIGLIETTO B ON V.codice_visita = B.codice_visita"
                            + " GROUP BY M.nome;";
        
    
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            final ResultSet rs = stmt.executeQuery();
    
            final ObservableList<BigliettiMostraTotale> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new BigliettiMostraTotale(rs.getString("nome_mostra"),rs.getInt("biglietti_venduti")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    
    }


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
    
    public void addMostra(String nome, String città, String data_inizio, String codiceMostra,String data_fine) 
                            throws SQLException, SQLIntegrityConstraintViolationException {
        final String query = "INSERT INTO MOSTRA (nome, città, data_inizio, data_fine, codice_mostra, numero_opere, valore) "
                + " VALUES (?, ?, ?, ?, ?, ?, ? )";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nome);
            stmt.setString(2, città);
            stmt.setTimestamp(3, DateAdapter.dateToSqlDate(DateAdapter.buildDate(data_inizio).get()));
            stmt.setTimestamp(4, DateAdapter.dateToSqlDate(DateAdapter.buildDate(data_fine).get()));
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
                            + " FROM Mostra ";

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

        final String query = "DELETE FROM Mostra WHERE codice_mostra=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, codiceMostra);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
         
    }

}