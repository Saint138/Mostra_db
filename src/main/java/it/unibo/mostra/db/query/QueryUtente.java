package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.unibo.mostra.db.entity.Recensione;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class QueryUtente {
       
    private Connection connection;
    

    public QueryUtente(Connection connection) {
        this.connection = connection;
    }

    public ObservableList<Recensione> UtentiPiùAttivi(){
        final String query = "SELECT  V.nome,V.cognome,V.CF, COUNT(R.codice_recensione) as conteggio_recensioni"
                            + "FROM Recensione R"
                            + "JOIN Visitatore V on R.CF = V.CF"
                            + "GROUP BY V.nome,V.cognome,V.CF"
                            + "ORDER BY conteggio_recensioni DESC"
                            + "LIMIT 5";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Recensione> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new UtentiPiùAttivi(rs.getString("V.nome"), rs.getString("V.cognome"),
                                               rs.getString("conteggio_recensioni")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
