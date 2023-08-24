package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class QueryVisita {
    
    private Connection connection;

    public QueryVisita(Connection connection) {
        this.connection = connection;
    }

    public void addVisita(String codice_visita, String ora_inizio, String data_visita,
    String codice_mostra, String codice_contratto) throws SQLException, SQLIntegrityConstraintViolationException {
        final String query = "INSERT INTO Mostra (CODICE_VISITA, ORA_INZIO, DATA, NUMERO_PARTECIPANTI , CODICE_MOSTRA, CODICE_CONTRATTO) "
                            + "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, codice_visita);
            stmt.setString(2, ora_inizio);
            stmt.setString(3, data_visita);
            stmt.setInt(4, 0);
            stmt.setString(5, codice_mostra);
            stmt.setString(6, codice_contratto);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("visita già inserita");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeVisita(String codiceVisita)  throws SQLException{
        final String query = "DELETE FROM Visita WHERE codice_visita=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, codiceVisita);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
         final String query2 = "DELETE FROM Biglietto WHERE codice_visita=?";
        try (PreparedStatement statement = connection.prepareStatement(query2)) {
            statement.setString(1, codiceVisita);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
