package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import it.unibo.mostra.db.entity.Turno;
import it.unibo.mostra.utils.DateAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class QueryTurno {

    private Connection connection;
    
    public QueryTurno(Connection connection) {
        this.connection = connection;
    }

    public void addTurno(String codice_turno, String data_turno, String ora_inizio, String ora_fine, String codice_mostra,boolean codice_guida, boolean codice_guardia,  boolean codice_magazziniere, boolean codice_receptionist,boolean codice_souvenir,String codice_contratto) throws SQLIntegrityConstraintViolationException, SQLException{
        final String query = "INSERT INTO Turno(codice_turno, data_turno, ora_inizio, ora_fine, codice_mostra, codice_contratto, codice_contratto_receptionist, codice_contratto_guardia, codice_contratto_magazziniere) "
                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
          try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, codice_turno);
            stmt.setTimestamp(2, DateAdapter.dateToSqlDate(DateAdapter.buildDate(data_turno).get()));
            stmt.setString(3, ora_inizio);
            stmt.setString(4, ora_fine);
            stmt.setString(5, codice_mostra);
            stmt.setString(6, ora_inizio);
            stmt.setBoolean(7, codice_souvenir);
            stmt.setBoolean(8, codice_receptionist);
            stmt.setBoolean(9, codice_guardia);
            stmt.setBoolean(8, codice_guida);
            stmt.setBoolean(9, codice_magazziniere);
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

    public  ObservableList<Turno> refreshTurniDipendente(String codContratto) {
         final String query = "SELECT T.codice_turno, T.data_turno, T.ora_inizio, T.ora_fine, T.codice_mostra "
                 + " FROM TURNO T "
                 + "WHERE T.codice_contratto = ? "
                 + "   OR T.codice_contratto_receptionist = ? "
                 + "   OR T.codice_contratto_guardia = ? "
                 + "   OR T.codice_contratto_magazziniere = ? "
                + "ORDER BY T.data_turno, T.ora_inizio";
                try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
                    stmt.setString(1, codContratto);
                    stmt.setString(2, codContratto);
                    stmt.setString(3, codContratto);
                    stmt.setString(4, codContratto);
                    final ResultSet rs = stmt.executeQuery();
            
                    final ObservableList<Turno> list = FXCollections.observableArrayList();
                    while (rs.next()) {
                        list.add(new Turno(rs.getString("codice_turno"), rs.getString("data_turno"),
                                rs.getString("ora_inizio"), rs.getString("ora_fine"),rs.getString("codice_mostra")));
                    }
                    return list;
                } catch (final SQLException e) {
                    throw new IllegalStateException("Cannot execute the query!", e);
                }
    }
    
    public  ObservableList<Turno> refreshTurni() {
         final String query = "SELECT codice_turno, data_turno, ora_inizio, ora_fine, codice_mostra "
                + " FROM Turno ";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Turno> list = FXCollections.observableArrayList();
            while (rs.next()) {
                list.add(new Turno(rs.getString("codice_turno"), rs.getString("data_turno"), rs.getString("ora_inizio"),
                        rs.getString("ora_fine"), rs.getString("codice_mostra")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
