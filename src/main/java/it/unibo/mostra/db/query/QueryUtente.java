package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import it.unibo.mostra.db.entity.UtentiPiùAttivi;
import it.unibo.mostra.utils.DateAdapter;
import it.unibo.mostra.db.entity.Recensione;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class QueryUtente {
       
    private Connection connection;
    

    public QueryUtente(Connection connection) {
        this.connection = connection;
    }

    public void addUtente(String CF, String email, String nome, String cognome) throws SQLException, SQLIntegrityConstraintViolationException {
         final String query = "INSERT INTO Visitatore(nome,cognome,email,CF)"
                             + "VALUES (?, ?, ?, ?)";
        
         try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setString(3, email);
            stmt.setString(4, CF);
         }  catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("utente già registrato");
         } catch (SQLException e) {
            e.printStackTrace();
         }
    }
    
    public ObservableList<UtentiPiùAttivi> UtentiPiùAttivi(){
        final String query = "SELECT  V.nome,V.cognome,V.CF, COUNT(R.codice_recensione) as conteggio_recensioni"
                            + "FROM Recensione R"
                            + "JOIN Visitatore V on R.CF = V.CF"
                            + "GROUP BY V.nome,V.cognome,V.CF"
                            + "ORDER BY conteggio_recensioni DESC"
                            + "LIMIT 5";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<UtentiPiùAttivi> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new UtentiPiùAttivi(rs.getString("V.nome"), rs.getString("V.cognome"),
                                               rs.getInt("conteggio_recensioni")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
