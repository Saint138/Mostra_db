package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import it.unibo.mostra.db.entity.Artista;
import it.unibo.mostra.utils.DateAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class QueryArtista {

     private Connection connection;

    public QueryArtista(Connection connection) {
        this.connection = connection;
    }

    public void addArtista(String nome, String nome_arte, String cognome, String data_di_nascita, String data_decesso,
    String breve_biografia) throws SQLException, SQLIntegrityConstraintViolationException {
        final String query = "INSERT INTO Artista (nome_arte, nome, cognome, data_di_nascita, data_decesso, breve_biografia)"
                + " VALUES (?, ?, ?, ?, ?, ?);";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nome_arte);
            stmt.setString(2, nome);
            stmt.setString(3, cognome);
            stmt.setTimestamp(4,DateAdapter.dateToSqlDate(DateAdapter.buildDate(data_di_nascita).get()) );
            stmt.setTimestamp(5,DateAdapter.dateToSqlDate(DateAdapter.buildDate(data_decesso).get()));
            stmt.setString(6, breve_biografia);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Artista già inserito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeArtista(String nome_arte) throws SQLException{
    
        final String query = "DELETE FROM Opera WHERE nome_arte= ? ;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nome_arte);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        final String query2 = "DELETE FROM Presenza WHERE nome_arte= ? ;";
        try (PreparedStatement statement = connection.prepareStatement(query2)) {
            statement.setString(1, nome_arte);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        final String query3 = "DELETE FROM Artista WHERE nome_arte= ?; ";
        try (PreparedStatement statement = connection.prepareStatement(query3)) {
            statement.setString(1, nome_arte);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public ObservableList<Artista> refreshArtista() {
        final String query = "SELECT nome_arte, nome, cognome, data_di_nascita, data_decesso, breve_biografia"
                + " FROM Artista; ";

        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            final ResultSet rs = stmt.executeQuery();
            final ObservableList<Artista> tab = FXCollections.observableArrayList();
            while (rs.next()) {
                tab.add(new Artista(rs.getString("nome_arte"), rs.getString("nome"), rs.getString("cognome"),
                        rs.getString("data_di_nascita"), rs.getString("data_decesso"),
                        rs.getString("breve_biografia")));

            }
            return tab;
        } catch (final SQLException e) {
            throw new IllegalStateException("Cannot execute the query!", e);
        }

    }
    
    public ObservableList<Artista> artistaTopValore() {
        final String query = "SELECT A.nome_arte, SUM(V.importo) AS valore_totale_opere "
                + " FROM ARTISTA A "
                + " JOIN OPERA O ON A.nome_arte = O.nome_arte "
                + " JOIN VENDITA V ON O.codice_vendita = V.codice_vendita "
                + " GROUP BY A.nome_arte "
                + " ORDER BY valore_totale_opere DESC";

        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Artista> list = FXCollections.observableArrayList();
            while (rs.next()) {
                list.add(new Artista(rs.getString("nome_arte"), rs.getInt("valore_totale_opere")));
            }
            return list;
        } catch (final SQLException e) {
            throw new IllegalStateException("Cannot execute the query!", e);

        }
    }
    
     public ObservableList<Artista> artistiNoOpere(){
        final String query = "SELECT DISTINCT A.nome_arte "
                            + " FROM ARTISTA A "
                            + " LEFT JOIN OPERA O ON A.nome_arte = O.nome_arte"
                            + " LEFT JOIN PRESENZA P ON O.nome_arte = P.nome_arte "
                + " WHERE P.codice_mostra IS NULL;";
                           

                            try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
                                final ResultSet rs = stmt.executeQuery();
                    
                                final ObservableList<Artista> list = FXCollections.observableArrayList();
                                while (rs.next()) {
                                    list.add(new Artista(rs.getString("nome_arte")));
                                }
                                return list;
                            } catch (final SQLException e) {
                                throw new IllegalStateException("Cannot execute the query!", e);
                            
                            }
    }
}
