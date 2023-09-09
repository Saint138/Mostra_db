package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import it.unibo.mostra.db.entity.Visita;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class QueryVisita {
    
    private Connection connection;

    public QueryVisita(Connection connection) {
        this.connection = connection;
    }
    //add visita
    public void addVisita(String codice_visita, String ora_inizio, String data_visita,
    String codice_mostra, String codice_contratto) throws SQLException, SQLIntegrityConstraintViolationException {
        final String query = "INSERT INTO Visita(codice_visita,ora_inizio,data_visita,numero_partecipanti,codice_mostra,matricola)"
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
      
         final String query = "DELETE FROM Biglietto WHERE codice_visita=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, codiceVisita);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
          final String query2 = "DELETE FROM Visita WHERE codice_visita=?";
        try (PreparedStatement statement = connection.prepareStatement(query2)) {
            statement.setString(1, codiceVisita);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public  ObservableList<Visita> refreshVisita() {
        final String query = "Select V.codice_visita, V.data_visita , V.ora_inizio, V.numero_partecipanti, M.nome as nome_mostra "
               + " FROM Visita V, Mostra M "
               + " WHERE V.codice_mostra = M.codice_mostra";
       try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
           final ResultSet rs = stmt.executeQuery();

           final ObservableList<Visita> list = FXCollections.observableArrayList();
           while (rs.next()) {
               list.add(new Visita(rs.getString("codice_visita"), rs.getFloat("ora_inizio"), rs.getString("data_visita"),
                       rs.getInt("numero_partecipanti"), rs.getString("nome_mostra")));
           }
           return list;
       } catch (SQLException e) {
           e.printStackTrace();
           return null;
       }
   }
}
