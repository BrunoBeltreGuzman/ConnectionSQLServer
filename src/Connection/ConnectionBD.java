/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author diosl
 */
public class ConnectionBD {

    private Connection connection;
    private final String USER;
    private final String PASS_WORD;
    private final String URL;
    private final String JDBC_DRIVER;

    public ConnectionBD() {
        //URL jdbc Driver//localhost or Direccion ip//port//database=databaseName  
        URL = "jdbc:sqlserver://localhost:1433;database=database;";
        USER = "user=sa;";
        PASS_WORD = "password=root2020;";
        JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    }

    public boolean conectar() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(URL + USER + PASS_WORD);
            return true;
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
            return false;
        }
    }

    public boolean desConectar() {
        if (connection != null) {
            try {
                connection.close();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Error: " + e);
                return false;
            }
        }
        return false;
    }

    public Connection getConexion() {
        try {
            connection = DriverManager.getConnection(URL);
            return connection;
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
            return null;
        }
    }

}
