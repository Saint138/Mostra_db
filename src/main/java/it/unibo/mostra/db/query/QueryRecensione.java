package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Random;

import it.unibo.mostra.db.entity.Recensione;
import it.unibo.mostra.utils.DateAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class QueryRecensione {
    
    private Connection connection;
    private Random rand = new Random();
    

    public QueryRecensione(Connection connection) {
        this.connection = connection;
    }

  
    public void addRecensione(String Cf, String commento, String codMostra, Integer val) throws SQLException, SQLIntegrityConstraintViolationException {
        final String query = " INSERT INTO Recensione (codice_recensione,data_recensione,valutazione,commento,cf,codice_mostra) "
                            + "VALUES (?, ?, ?, ?, ?, ?)";
        String cod = 'A'+ Integer.toString(rand.nextInt(1000, 9999));
        Date date = new Date (System.currentTimeMillis ());
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, cod );
            stmt.setTimestamp(2, DateAdapter.dateToSqlDate(date));
            stmt.setInt(3, val);
            stmt.setString(4, commento);
            stmt.setString(5, Cf);
            stmt.setString(6, codMostra);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Recensione già inserita");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Recensione> visulizzaRecensioniMostra(String codiceMostra){
        final String query = " SELECT  V.nome,V.cognome, R.data_recensione, R.codice, R.valutazione, R.commento"
                            + " FROM Recensione R"
                            + " JOIN Visitatore V on R.CF = V.CF"
                            + " WHERE R.codice_mostra= ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, codiceMostra);
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Recensione> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new Recensione(rs.getString("V.nome"), rs.getString("V.cognome"), rs.getString("R.codice"),rs.getString("R.commento"), 
                                               rs.getInt("R.valutazione"), rs.getString("R.data_recensione")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public ObservableList<Recensione> RecensioniUtente(String CF){
        final String query = "SELECT  V.nome,V.cognome, R.data_recensione, R.valutazione, R.commento, M.nome"
                            + " FROM Recensione R"
                            + " JOIN Visitatore V on R.CF = V.CF"
                            + " JOIN  Mostra M on R.codice_mostra = M.codice_mostra"
                            + " WHERE V.CF= ?";
                            
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, CF);
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Recensione> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new Recensione(rs.getString("V.nome"), rs.getString("V.cognome"),rs.getString("M.nome"), rs.getString("R.codice"),
                                               rs.getInt("R.Valutazione"), rs.getString("R.commento"), rs.getString("data_recensione")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public ObservableList<Recensione> refreshRecensione() {
       final String query = " SELECT V.email, M.nome AS nome_mostra, R.valutazione, R.commento"
                            + " FROM Recensione R"
                            + " JOIN Visitatore V on R.CF = V.CF"
                            + " JOIN MOSTRA M ON R.codice_mostra = M.codice_mostra;";
                            
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Recensione> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new Recensione(rs.getString("email"), rs.getString("nome_mostra"),rs.getInt("valutazione"), 
                                               rs.getString("commento")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
}
}
