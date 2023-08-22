package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;


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

    public void addMagazziniere(String matricola, String nome, String cognome, String email, Integer stipendio, String codContratto) throws SQLException, SQLIntegrityConstraintViolationException {
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
            stmt.setBoolean(8, false);
            stmt.setBoolean(9, true);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Dipendente già presete");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
