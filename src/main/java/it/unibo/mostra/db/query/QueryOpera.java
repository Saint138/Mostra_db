package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryOpera {
    
    private Connection connection;

    public QueryOpera(Connection connection) {
        this.connection = connection;
    }

    public void addOpera(String nomeArtista, String nomeOpera, String codiceVendita, String annoRealizzazione, String dimensioni, String tecnica, String descrizione) throws SQLException, SQLIntegrityConstraintViolationException {
        final String query = "INSERT INTO Mostra (NOME_ARTE, NOME, CODICE_VENDITA, ANNO_REALIZZAZIONE , DIMENSIONI, TECNICA, DESCRIZIONE) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nomeArtista);
            stmt.setInt(2, nomeArte);
            stmt.setString(3, codiceVendita);
            stmt.setString(4, annoRealizzazione);
            stmt.setString(5, dimensioni);
            stmt.setString(6, tecnica);
            stmt.setString(7, descrizione);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Opera già inserita");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
