package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import it.unibo.mostra.db.entity.Presenza;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


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
        updateValore(mostra);
        updateNumeroOpere(mostra);

    }

    public void removePresenza(String nomeArtista, String nomeOpera, String codiceMostra) throws SQLException {
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
    
    public ObservableList<Presenza> refreshPresenze() {
        final String query = "SELECT P.nome_arte, P.nome, P.codice_mostra, M.nome AS nome_mostra"
                + " FROM Presenza AS P, MOSTRA AS M"
                + " WHERE P.codice_mostra = M.codice_mostra";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Presenza> list = FXCollections.observableArrayList();
            while (rs.next()) {
                list.add(new Presenza(rs.getString("nome_arte"), rs.getString("nome"), rs.getString("nome_mostra"),
                        rs.getString("codice_mostra")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private void updateValore(String codiceMostra) {
        final String query = "UPDATE MOSTRA M"
                + " JOIN ("
                + " SELECT P.codice_mostra, SUM(V.importo) AS total_value"
                + " FROM Presenza P"
                + " JOIN OPERA O ON P.nome_arte = O.nome_arte AND P.nome = O.nome"
                + " JOIN VENDITA V ON O.codice_vendita = V.codice_vendita"
                + " GROUP BY P.codice_mostra"
                + " ) AS Subquery"
                + " ON M.codice_mostra = Subquery.codice_mostra"
                + " SET M.valore = Subquery.total_value"
                + " WHERE M.codice_mostra =?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, codiceMostra);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
    
       private void updateNumeroOpere(String codiceMostra) {
        final String query = "UPDATE MOSTRA M"
                + " JOIN ("
                + " SELECT codice_mostra, COUNT(*) AS total_opere"
                + " FROM Presenza "
                + " GROUP BY codice_mostra"
                + " ) AS Subquery"
                + " ON M.codice_mostra = Subquery.codice_mostra"
                + " SET M.numero_opere = Subquery.total_opere"
                + " WHERE M.codice_mostra = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, codiceMostra);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
   
}
