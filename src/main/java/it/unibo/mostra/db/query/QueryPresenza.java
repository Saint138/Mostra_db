package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;


public class QueryPresenza {
    
     private Connection connection;

    public QueryPresenza(Connection connection) {
        this.connection = connection;
    }

    public void addPresenza(String artista, String opera, String mostra) throws SQLException, SQLIntegrityConstraintViolationException {
        final String query = "INSERT INTO Presenza(codice_mostra,nome,nome_arte)"
                            + "VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, mostra);
            stmt.setString(2, opera);
            stmt.setString(3, artista);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("presenza già inserita");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeOpera(String nomeArtista, String nomeOpera, String codiceMostra){
        final String query = "DELETE FROM Presenza WHERE nome_arte=? AND codice_mostra=? AND nome=? ";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nomeArtista);
            statement.setString(2, nomeOpera);
            statement.setString(3, codiceMostra);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }
}
