package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import it.unibo.mostra.utils.DateAdapter;

public class QueryArtista {

     private Connection connection;

    public QueryArtista(Connection connection) {
        this.connection = connection;
    }

    public void addArtista(String nome, String nome_arte, String cognome, String data_di_nascita, String data_decesso,
    String breve_biografia) throws SQLException, SQLIntegrityConstraintViolationException {
        final String query = "INSERT INTO Artista (nome_arte,nome,cognome,data_di_nascita,data_decesso,breve_biografia) "
                            + "VALUES (?, ?, ?, ?, ?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nome_arte);
            stmt.setString(2, nome);
            stmt.setString(3, cognome);
            stmt.setTimestamp(4,DateAdapter.dateToSqlDate(DateAdapter.buildDate(data_di_nascita).get()) );
            stmt.setTimestamp(5,DateAdapter.dateToSqlDate(DateAdapter.buildDate(data_decesso).get()) );
            stmt.setString(6, breve_biografia);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Artista già inserito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeOpera(String nomeArtista){
        final String query = "DELETE FROM Artista WHERE nome_arte=? ";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nomeArtista);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
         final String query2 = "DELETE FROM Opera WHERE nome_arte=?";
        try (PreparedStatement statement = connection.prepareStatement(query2)) {
            statement.setString(1, nomeArtista);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        final String query3 = "DELETE FROM Presenza WHERE nome_arte=?";
        try (PreparedStatement statement = connection.prepareStatement(query3)) {
            statement.setString(1, nomeArtista);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}