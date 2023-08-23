package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import it.unibo.mostra.db.entity.Turno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class QueryDipendenti {
    
    
    private Connection connection;
    
    public QueryDipendenti(Connection connection) {
        this.connection = connection;
    }

    public void addReceptionist(String matricola, String nome, String cognome, String email, Integer stipendio, String codContratto) throws SQLException, SQLIntegrityConstraintViolationException {
        final String query = "INSERT INTO Membro_Receptionist (STIPENDIO, CODICE_CONTRATTO, MATRICOLA) "
                            + "VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, stipendio);
            stmt.setString(2, codContratto);
            stmt.setString(3, matricola);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Dipendente già presete");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        final String query2 =  "INSERT INTO Dipendente (MATRICOLA, NOME, COGNOME, EMAIL, GUARDIA, GUIDA , COMMESSO_SOUVENIR, RECEPITIONIST, MAGAZZINIERE) "
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query2)) {
            stmt.setString(1, matricola);
            stmt.setString(2, nome);
            stmt.setString(3, cognome);
            stmt.setString(4, email);
            stmt.setBoolean(5, false);
            stmt.setBoolean(6, false);
            stmt.setBoolean(7, false);
            stmt.setBoolean(8, true);
            stmt.setBoolean(9, false);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Dipendente già presete");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addGuida(String matricola, String nome, String cognome, String email, Integer stipendio, String codContratto) throws SQLException, SQLIntegrityConstraintViolationException {
        final String query = "INSERT INTO Guida (STIPENDIO, CODICE_CONTRATTO, MATRICOLA) "
                            + "VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, stipendio);
            stmt.setString(2, codContratto);
            stmt.setString(3, matricola);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Dipendente già presete");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        final String query2 =  "INSERT INTO Dipendente (MATRICOLA, NOME, COGNOME, EMAIL, GUARDIA, GUIDA , COMMESSO_SOUVENIR, RECEPITIONIST, MAGAZZINIERE) "
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query2)) {
            stmt.setString(1, matricola);
            stmt.setString(2, nome);
            stmt.setString(3, cognome);
            stmt.setString(4, email);
            stmt.setBoolean(5, false);
            stmt.setBoolean(6, true);
            stmt.setBoolean(7, false);
            stmt.setBoolean(8, false);
            stmt.setBoolean(9, false);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Dipendente già presete");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addGuardia(String matricola, String nome, String cognome, String email, Integer stipendio, String codContratto) throws SQLException, SQLIntegrityConstraintViolationException {
        final String query = "INSERT INTO Membro_Guardia (STIPENDIO, CODICE_CONTRATTO, MATRICOLA) "
                            + "VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, stipendio);
            stmt.setString(2, codContratto);
            stmt.setString(3, matricola);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Dipendente già presete");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        final String query2 =  "INSERT INTO Dipendente (MATRICOLA, NOME, COGNOME, EMAIL, GUARDIA, GUIDA , COMMESSO_SOUVENIR, RECEPITIONIST, MAGAZZINIERE) "
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query2)) {
            stmt.setString(1, matricola);
            stmt.setString(2, nome);
            stmt.setString(3, cognome);
            stmt.setString(4, email);
            stmt.setBoolean(5, true);
            stmt.setBoolean(6, false);
            stmt.setBoolean(7, false);
            stmt.setBoolean(8, false);
            stmt.setBoolean(9, false);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Dipendente già presete");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCommesso(String matricola, String nome, String cognome, String email, Integer stipendio, String codContratto) throws SQLException, SQLIntegrityConstraintViolationException {
        final String query = "INSERT INTO Membro_Commesso (STIPENDIO, CODICE_CONTRATTO, MATRICOLA) "
                            + "VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, stipendio);
            stmt.setString(2, codContratto);
            stmt.setString(3, matricola);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Dipendente già presete");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        final String query2 =  "INSERT INTO Dipendente (MATRICOLA, NOME, COGNOME, EMAIL, GUARDIA, GUIDA , COMMESSO_SOUVENIR, RECEPITIONIST, MAGAZZINIERE) "
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query2)) {
            stmt.setString(1, matricola);
            stmt.setString(2, nome);
            stmt.setString(3, cognome);
            stmt.setString(4, email);
            stmt.setBoolean(5, false);
            stmt.setBoolean(6, false);
            stmt.setBoolean(7, true);
            stmt.setBoolean(8, false);
            stmt.setBoolean(9, false);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Dipendente già presete");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addMagazziniere(String matricola, String nome, String cognome, String email, Integer stipendio,
            String codContratto) throws SQLException, SQLIntegrityConstraintViolationException {
        final String query = "INSERT INTO Receptionist (STIPENDIO, CODICE_CONTRATTO, MATRICOLA) "
                + "VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, stipendio);
            stmt.setString(2, codContratto);
            stmt.setString(3, matricola);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Dipendente già presete");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        final String query2 = "INSERT INTO Dipendente (MATRICOLA, NOME, COGNOME, EMAIL, GUARDIA, GUIDA , COMMESSO_SOUVENIR, RECEPITIONIST, MAGAZZINIERE) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query2)) {
            stmt.setString(1, matricola);
            stmt.setString(2, nome);
            stmt.setString(3, cognome);
            stmt.setString(4, email);
            stmt.setBoolean(5, false);
            stmt.setBoolean(6, false);
            stmt.setBoolean(7, false);
            stmt.setBoolean(8, false);
            stmt.setBoolean(9, true);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Dipendente già presete");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public  ObservableList<Turno> refreshTurniDipendente(String matricola) {
         final String query = "Select codice_turno, data_turno,ora_inizio,ora_fine,codice_mostra "
                + " FROM Turno "
                + "WHERE matricola=? ";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, matricola);
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
