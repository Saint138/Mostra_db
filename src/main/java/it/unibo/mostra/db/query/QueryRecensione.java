package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.unibo.mostra.db.entity.Recensione;

public class QueryRecensione {
    
    private Connection connection;
    

    public QueryRecensione(Connection connection) {
        this.connection = connection;
    }

    //inserire una nuova mostra
  
    public void addRecensione(String cod, String Cf, String commento, String codMostra, Integer val) throws SQLException, SQLIntegrityConstraintViolationException {
        final String query = "INSERT INTO Mostra (CODICE_RECENSIONE, CF, COMMENTO, CODICE_MOSTRA , VALUTAZIONE) "
                            + "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, cod);
            stmt.setInt(2, cf);
            stmt.setString(3, commento);
            stmt.setString(4, codMostra);
            stmt.setString(5, valore);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Recensione già inserita");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<List> visulizzaRecensioniMostra(String codiceMostra){
        final String query = "SELECT  V.nome,V.cognome, R.data_recensione, R.valutazione, R.commento"
                            + "FROM Recensione R"
                            + "JOIN Visitatore V on R.CF = V.CF"
                            + "WHERE R.codice_mostra= ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, codiceMostra);
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Recensione> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new List(rs.getString("V.nome"), rs.getString("V.cognome"),
                                               rs.getString("R.Valutazione"), rs.getString("R.commento")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public ObservableList<Recensione>aRecensioniUtente(String CF){
        final String query = "SELECT  V.nome,V.cognome, R.data_recensione, R.valutazione, R.commento"
                            + "FROM Recensione R"
                            + "JOIN Visitatore V on R.CF = V.CF"
                            + "WHERE V.CF= ?";
                            
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, CF);
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Recensione> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new Recensione(rs.getString("V.nome"), rs.getString("V.cognome"),
                                               rs.getString("R.Valutazione"), rs.getString("R.commento")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public ObservableList<Recensione> visulizzaRecensioniPerData(String data){
        final String query = "SELECT  V.nome,V.cognome, M.nome, R.valutazione, R.commento"
                            + "FROM Recensione R"
                            + "JOIN Visitatore V on R.CF = V.CF"
                            + "JOIN  Mostra M on R.codice_mostra = M.codice_mostra"
                            + "WHERE R.data_recensione = ?";
                            
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, data);
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Recensione> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new Recensione(rs.getString("V.nome"), rs.getString("V.cognome"),rs.getString("M.nome"),
                                               rs.getString("R.Valutazione"), rs.getString("R.commento")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
