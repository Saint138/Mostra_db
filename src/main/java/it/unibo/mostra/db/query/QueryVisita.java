package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class QueryVisita {
    
    private Connection connection;

    public QueryVisita(Connection connection) {
        this.connection = connection;
    }

    public void addVisita(String codice_visita, float ora_inizio, String data_visita, int numero_partecipanti,
    String codice_mostra, String codice_contratto) throws SQLException, SQLIntegrityConstraintViolationException {
        final String query = "INSERT INTO Mostra (CODICE_VISITA, ORA_INZIO, DATA, NUMERO_PARTECIPANTI , CODICE_MOSTRA, CODICE_CONTRATTO) "
                            + "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, codice_visita);
            stmt.setFloat(2, ora_inizio);
            stmt.setString(3, data_visita);
            stmt.setInt(4, numero_partecipanti);
            stmt.setString(5, codice_mostra);
            stmt.setString(6, codice_contratto);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("visita già inserita");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
