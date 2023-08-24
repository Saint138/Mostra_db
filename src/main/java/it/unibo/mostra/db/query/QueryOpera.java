package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import it.unibo.mostra.db.entity.Opera;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class QueryOpera {
    
    private Connection connection;

    public QueryOpera(Connection connection) {
        this.connection = connection;
    }

    public void addOpera(String nomeArtista, String nomeOpera, String codiceVendita, String annoRealizzazione, String dimensioni,
                         String tecnica, String descrizione) throws SQLException, SQLIntegrityConstraintViolationException {
        final String query = "INSERT INTO Mostra (NOME_ARTE, NOME, CODICE_VENDITA, ANNO_REALIZZAZIONE , DIMENSIONI, TECNICA, DESCRIZIONE) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nomeArtista);
            stmt.setString(2, nomeOpera);
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

    public void removeOpera(String nomeArtista, String nomeOpera ) throws SQLException {
         final String query = "DELETE FROM Presenza WHERE nome_arte=? AND nome=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nomeArtista);
            statement.setString(2, nomeOpera);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        final String query1 = "DELETE FROM Opera WHERE nome_arte=? AND nome=?";
        try (PreparedStatement statement = connection.prepareStatement(query1)) {
            statement.setString(1, nomeArtista);
            statement.setString(2, nomeOpera);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void updateOpereMostre(){
        
       final String query =   "UPDATE Mostra"
                             + "SET numero_opere = (SELECT COUNT(P.codice_mostra) as opere"
                             + "FROM presenza P "
                             + "WHERE Mostra.codice_mostra = P.codice_mostra)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public ObservableList<Opera> refreshOpera() {
        final String query = "SELECT nome_arte, nome, anno_realizzazione, dimensioni, tecnica, descrizione "
                            + " FROM Opera ";

         try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
                final ResultSet rs = stmt.executeQuery();
                final ObservableList<Opera> tab = FXCollections.observableArrayList();
                 while (rs.next()) {
                                    tab.add(new Opera(rs.getString("nome_arte"), rs.getString("nome"), rs.getString("anno_realizzazione"),
                                            rs.getString("dimensioni"), rs.getString("tecnica"), rs.getString("descrizione")));
                                                              
                                }
                                return tab;
    }
      catch (final SQLException e) {
                                throw new IllegalStateException("Cannot execute the query!", e);
     }                    
}

}
