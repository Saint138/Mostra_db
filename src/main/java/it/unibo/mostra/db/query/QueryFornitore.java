package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;


import it.unibo.mostra.db.entity.Fornitore;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class QueryFornitore {
    
    private Connection connection;

    public QueryFornitore(Connection connection) {
        this.connection = connection;
    }

    //inserire una nuovo fornitore
  
    public void addFornitore(String codice_fornitore, String nome,String email, String numero_telefono) throws SQLException, SQLIntegrityConstraintViolationException {
        final String query = "INSERT INTO Fornitore (CODICE_FORNITORE, NOME, EMAIL , NUMERO_TELEFONO) "
                            + "VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, codice_fornitore);
            stmt.setString(2, nome);
            stmt.setString(3, email);
            stmt.setString(4, numero_telefono);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Fornitore già inserita");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

     public  ObservableList<Fornitore> refreshFornitore() {
        final String query = "Select codice_fornitore, nome , email, numero_telefono "
               + " FROM Fornitore ";
       try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
           final ResultSet rs = stmt.executeQuery();

           final ObservableList<Fornitore> list = FXCollections.observableArrayList();
           while (rs.next()) {
               list.add(new Fornitore(rs.getString("codice_fornitore"), rs.getString("nome"), rs.getString("email"),
                       rs.getString("numero_telefono")));
           }
           return list;
       } catch (SQLException e) {
           e.printStackTrace();
           return null;
       }
   }
}
