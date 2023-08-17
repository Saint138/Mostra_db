package it.unibo.mostra.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryOpera {
    
    private Connection connection;

    public QueryOpera(Connection connection) {
        this.connection = connection;
    }
}
