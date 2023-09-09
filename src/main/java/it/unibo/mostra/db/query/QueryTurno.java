package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import it.unibo.mostra.db.entity.Turno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class QueryTurno {

    private Connection connection;
    
    public QueryTurno(Connection connection) {
        this.connection = connection;
    }

    public void addTurno(String codice_turno, String ora_inizio, String ora_fine, String codice_mostra) throws SQLIntegrityConstraintViolationException, SQLException{
        final String query = "INSERT INTO Turno(codice_turno, ora_inizio, ora_fine, codice_mostra) "
                + " values (?, ?, ?, ?);";
          try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, codice_turno);
            stmt.setString(2, ora_inizio);
            stmt.setString(3, ora_fine);
            stmt.setString(4, codice_mostra);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Turno già presente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }           

    public void removeTurno(String cod) throws SQLException {
        final String query = "DELETE FROM Turno WHERE codice_turno=? ";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cod);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }

    public  ObservableList<Turno> refreshTurniDipendente(String matricola) {
         final String query = "SELECT T.codice_turno, T.ora_inizio, T.ora_fine, M.nome AS nome_mostra, D.nome_ruolo, R.stipendio "
                 + "FROM DIPENDENTE AS D "
                 + "JOIN TURNO AS T ON D.codice_turno = T.codice_turno "
                 + "JOIN MOSTRA AS M ON T.codice_mostra = M.codice_mostra "
                 + "JOIN RUOLO AS R ON D.nome_ruolo = R.nome_ruolo "
                 + "WHERE D.matricola = ? ; " ;
                try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
                    stmt.setString(1, matricola);
                    
                    final ResultSet rs = stmt.executeQuery();
            
                    final ObservableList<Turno> list = FXCollections.observableArrayList();
                    while (rs.next()) {
                        list.add(new Turno(rs.getString("codice_turno"),
                                rs.getString("ora_inizio"), rs.getString("ora_fine"),rs.getString("nome_mostra"),rs.getString("nome_ruolo"),rs.getInt("stipendio")));
                    }
                    return list;
                } catch (final SQLException e) {
                    throw new IllegalStateException("Cannot execute the query!", e);
                }
    }
    
    public  ObservableList<Turno> refreshTurni() {
         final String query = "SELECT codice_turno, ora_inizio, ora_fine, codice_mostra "
                + " FROM Turno ";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Turno> list = FXCollections.observableArrayList();
            while (rs.next()) {
                list.add(new Turno(rs.getString("codice_turno"), rs.getString("ora_inizio"),
                        rs.getString("ora_fine"), rs.getString("codice_mostra")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
