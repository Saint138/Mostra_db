package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import it.unibo.mostra.db.entity.Dipendente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class QueryDipendenti {
    
    
    private Connection connection;
    
    public QueryDipendenti(Connection connection) {
        this.connection = connection;
    }

    public void removeDipendenti(String matricola)  throws SQLException{
       
          final String query = "DELETE FROM Dipendente WHERE matricola=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, matricola);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void addDipendente (String matricola, String nome, String cognome, String email,String nome_ruolo,String codice_turno) throws SQLIntegrityConstraintViolationException, SQLException {
        final String query = "INSERT INTO Dipendente(matricola,nome,cognome,email,nome_ruolo, codice_turno)"
                                + "VALUES (?,?,?,?,?,?)" ;
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, matricola);
            stmt.setString(2, nome);
            stmt.setString(3, cognome);
            stmt.setString(4, email);
            stmt.setString(5, nome_ruolo);
             stmt.setString(6, codice_turno);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Dipendente già presete");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public ObservableList<Dipendente> refreshDipendente() {
        final String query = "Select nome, cognome , email, matricola "
                + " FROM Dipendente ";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Dipendente> list = FXCollections.observableArrayList();
            while (rs.next()) {
                list.add(new Dipendente(rs.getString("matricola"), rs.getString("nome"), rs.getString("cognome"),
                        rs.getString("email")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
   
}
