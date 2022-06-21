package com.example.comicweb.connect;

import java.sql.Connection;

public class ComicDb {
    private IConnection iConnection;
    private static ComicDb comicDb;

    private ComicDb(){
        iConnection = new MySQLConnection("jdbc:mysql://b968d3e8e312e8:7a03316f@us-cdbr-east-05.cleardb.net/heroku_ecfa244169f8b57?autoReconnect=true"
                                            , null, null);
    }

    public static ComicDb getInstance(){
        if (comicDb == null){
            comicDb = new ComicDb();
        }
        return comicDb;
    }

    public Connection getConnection(){
        return iConnection.getConnection();
    }
}
