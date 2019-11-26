/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carli
 */
public class ConnectionPostgreSQL {

    private static ConnectionPostgreSQL instance;
    private static Connection connection;

    private static final String serverName = "200.18.128.54";
    private static final String mydatabase = "carla";
    private static final String userName = "projeto";
    private static final String password = "projeto";

    //private static String url = "jdbc:postgresql://" + serverName + "/" + mydatabase + "?useTimezone=true&serverTimezone=UTC";
    private static String url = "jdbc:postgresql://" + serverName + "/" + mydatabase;

    private ConnectionPostgreSQL() {
        try {
            Class.forName("org.postgresql.Driver");
            ConnectionPostgreSQL.connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            System.out.println("Conexao nao criada." + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Conexao nao criada." + ex.getMessage());
            Logger.getLogger(ConnectionPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ConnectionPostgreSQL getInstance() {
        if (instance == null) {
            instance = new ConnectionPostgreSQL();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
