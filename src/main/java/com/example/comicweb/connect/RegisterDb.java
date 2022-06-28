package com.example.comicweb.connect;

import java.sql.Connection;

public class RegisterDb {
    private IConnection iConnection;
    private static RegisterDb registerDb;

    private RegisterDb() {
        iConnection = new MySQLConnection("jdbc:mysql://b968d3e8e312e8:7a03316f@us-cdbr-east-05.cleardb.net/heroku_ecfa244169f8b57?autoReconnect=true"
                , null, null);
    }

    public static RegisterDb getInstance() {
        if (registerDb == null) {
            registerDb = new RegisterDb();
        }
        return registerDb;
    }

    public Connection getConnection() {
        return iConnection.getConnection();
    }
}