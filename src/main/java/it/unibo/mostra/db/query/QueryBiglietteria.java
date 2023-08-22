package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import it.unibo.mostra.db.entity.refreshBiglietteria;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class QueryBiglietteria {
    private Connection connection;

    public QueryBiglietteria(Connection connection) {
        this.connection = connection;
    }

    private void newBiglietto() {
        /*final String query = "INSERT INTO Biglietto "
                + "(CF, codice_biglietto, prezzo, data_biglietto, codice_visita) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cf);
            statement.setTimestamp(2, dataOra);
            statement.setInt(3, puntiFatti);
            statement.setString(4, idCampionato);
            statement.setInt(5, annoCampioanto);
            statement.setString(6, nomeGirone);
            statement.setString(7, nomeSquadra);
            statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new IllegalArgumentException(e);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }*/
    }

    public ObservableList<refreshBiglietteria> refreshBiglietteria(){
        final String query = "SELECT DISTINCT  M.nome,V.codice_visita,M.data_inizio,M.data_fine,B.prezzo"
                            + "FROM Mostra M,Visita V,Biglietto B "
                            + "WHERE M.codice_mostra=V.codice_mostra ";
                        
                            try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
                                final ResultSet rs = stmt.executeQuery();
                    
                                final ObservableList<refreshBiglietteria> tab = FXCollections.observableArrayList();
                                while (rs.next()) {
                                    tab.add(new refreshBiglietteria(rs.getString("nome"), rs.getString("codice_visita"), rs.getString("data_inizio"),
                                            rs.getString("data_fine"), rs.getFloat("prezzo")));
                                                              
                                }
                                return tab;
                            } catch (final SQLException e) {
                                throw new IllegalStateException("Cannot execute the query!", e);
                            
    }
}
}
