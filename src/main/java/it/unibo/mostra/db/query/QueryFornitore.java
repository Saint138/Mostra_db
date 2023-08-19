package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class QueryFornitore {
    
    private Connection connection;

    public QueryFornitore(Connection connection) {
        this.connection = connection;
    }

    //inserire una nuovo fornitore
  
    public void addFornitore(String codice_fornitore, String nome, String cognome, String email, String numero_telefono) throws SQLException, SQLIntegrityConstraintViolationException {
        final String query = "INSERT INTO Mostra (CODICE_FORNITORE, NOME, COGNOME, EMAIL , NUMERO_TELEFONO) "
                            + "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, codice_fornitore);
            stmt.setString(2, nome);
            stmt.setString(3, cognome);
            stmt.setString(4, email);
            stmt.setString(5, numero_telefono);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Fornitore già inserita");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
