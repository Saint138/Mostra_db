package it.unibo.mostra.db.query;

import java.sql.Connection;


public class QueryDipendenti {
    
    
    private Connection connection;
    
    public QueryDipendenti(Connection connection) {
        this.connection = connection;
    }
}
