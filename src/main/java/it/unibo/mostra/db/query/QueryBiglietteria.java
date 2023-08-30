package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Random;

import it.unibo.mostra.db.entity.RefreshBiglietteria;
import it.unibo.mostra.utils.DateAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

public class QueryBiglietteria {
    private Connection connection;

    public QueryBiglietteria(Connection connection) {
        this.connection = connection;
    }

     @FXML
     public void initialize() {
        refreshBiglietteria();
     }
    public void newBiglietto(Float prezzo, String CF, String codice_visita) {

        Random rand = new Random();
        String cod = "B" + Integer.toString(rand.nextInt(100000000, 999999999));
        Date data = new Date (System.currentTimeMillis ());

        final String query = "INSERT INTO Biglietto (CF, codice_biglietto, prezzo, data_biglietto, codice_visita) "
                + " VALUES (?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1,  CF);
            statement.setString(2, cod);
            statement.setFloat(3, prezzo);
            statement.setTimestamp(4, DateAdapter.dateToSqlDate(data));
            statement.setString(5, codice_visita);
            statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new IllegalArgumentException(e);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        updateNumeroPartecipanti(codice_visita);
    }

    public ObservableList<RefreshBiglietteria> refreshBiglietteria() {
        final String query = "SELECT M.nome, V.codice_visita, M.data_inizio, M.data_fine, B.prezzo "
                + " FROM Mostra M, Visita V, Biglietto B"
                + " WHERE M.codice_mostra = V.codice_mostra;";

        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<RefreshBiglietteria> tab = FXCollections.observableArrayList();
            while (rs.next()) {
                tab.add(new RefreshBiglietteria(rs.getString("nome"), rs.getString("codice_visita"),
                        rs.getString("data_inizio"),
                        rs.getString("data_fine"), rs.getFloat("prezzo")));

            }
            return tab;
        } catch (final SQLException e) {
            throw new IllegalStateException("Cannot execute the query!", e);

        }
    }

    private void updateNumeroPartecipanti(String codiceVisita) {
        final String query = "UPDATE VISITA"
                + " SET numero_partecipanti = ("
                + " SELECT COUNT(*) "
                + " FROM BIGLIETTO"
                + " WHERE codice_visita = VISITA.codice_visita"
                + " )"
                + " WHERE codice_visita = ?;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, codiceVisita);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
