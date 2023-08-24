package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import it.unibo.mostra.db.entity.Vendita;
import it.unibo.mostra.db.entity.Visita;
import it.unibo.mostra.utils.DateAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class QueryVendita {

    private Connection connection;

    public QueryVendita(Connection connection) {
        this.connection = connection;
    }
    
    public void addVendita(String codice_vendita, String data_vendita, float importo, String codice_fornitore) throws SQLException, SQLIntegrityConstraintViolationException {
        final String query = " INSERT INTO Vendita(codice_vendita,data_vendita,importo,codice_fornitore) "
        + "VALUES (?, ?, ?, ?, ?, ?)";

         try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, codice_vendita);
            stmt.setTimestamp(2, DateAdapter.dateToSqlDate(DateAdapter.buildDate(data_vendita).get()));
            stmt.setFloat(3, importo);
            stmt.setString(4, codice_fornitore);
         }  catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("vendita già inserita");
         } catch (SQLException e) {
            e.printStackTrace();
         }
    }

       public  ObservableList<Vendita> refreshVendita() {
        final String query = "Select V.codice_vendita, V.data_vendita, V.importo, F.nome as nome_fornitore "
               + " FROM Vendita V, Fornitore F "
               + " WHERE V.codice_fornitore = F.codice_fornitore ";
       try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
           final ResultSet rs = stmt.executeQuery();

           final ObservableList<Vendita> list = FXCollections.observableArrayList();
           while (rs.next()) {
               list.add(new Vendita(rs.getString("codice_vendita"), rs.getString("data_vendita"), rs.getFloat("importo"),
                     rs.getString("nome_fornitore")));
           }
           return list;
       } catch (SQLException e) {
           e.printStackTrace();
           return null;
       }
   }

}
