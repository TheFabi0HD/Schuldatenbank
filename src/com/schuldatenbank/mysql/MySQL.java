package com.schuldatenbank.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    private String host;
    private String database;
    private String user;
    private String password;

    public  Connection connection;

    public MySQL(String pHost, String pDatabase, String pUser, String pPassword) {
        this.host = pHost;
        this.database = pDatabase;
        this.user = pUser;
        this.password = pPassword;
    }

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database + "?autoReconnect=true", user, password);
            System.out.println("[MySQL] Die Verbindung zur MySQL wurde hergestellt!");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("[MySQL] Die Verbindung zur MySQL ist fehlgeschlagen! Fehler: " + e.getMessage());
        }
    }

    public void close() {
        try {
            if(connection != null) {
                connection.close();
                System.out.println("[MySQL] Die Verbindung zur MySQL wurde erfolgreich beendet!");
            }
        } catch (SQLException e) {
            System.out.println("[MySQL] Fehler beim beenden der Verbindung zur MySQL! Fehler: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }


}
