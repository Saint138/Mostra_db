package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryMostra {

    private Connection connection;
    
    public QueryMostra(Connection connection) {
        this.connection = connection;
    }

    public ObservableList<Recensione> MediaRecensioniMostra(){
        final String query = "SELECT M.nome, COUNT( R.codice_recensione) as numero_recensioni, AVG(R.valutazione) as media"
                            + "FROM Mostra M"
                            + "JOIN Recensione R on M.codice_mostra = R.codice_mostra"
                            + "GROUP BY M.nome";

        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Recensione> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new Recensione(rs.getString("M.nome"), rs.getString("numero_recensioni"),rs.getString("media")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public ObservableList<Recensione> RecensioniNegativeMostra(){
        final String query = "SELECT M.nome"
                            + "FROM Mostra M"
                            + "JOIN Recensione R ON M.codice_mostra = R.codice_mostra"
                            + "WHERE R.valutazione <= 5"
                            + "GROUP BY M.nome"
                            + "HAVING COUNT(*) >= 5";
        

        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Recensione> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new Recensione(rs.getString("M.nome")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    public ObservableList<Recensione> GuadagnoMostra(String codice_mostra){
        final String query = " Select SUM(B.prezzo) as guadagno"
                            + "FROM Biglietto B,Visita V,Mostra M"
                            + "WHERE B.codice_visita = V.codice_visita"
                            + "AND V.codice_mostra = ?";
        

        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, codice_mostra);
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Recensione> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new Recensione(rs.getString("M.nome")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
