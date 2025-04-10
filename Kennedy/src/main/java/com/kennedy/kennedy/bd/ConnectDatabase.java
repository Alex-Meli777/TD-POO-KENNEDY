package com.kennedy.kennedy.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    protected static String url = "jdbc:mysql://localhost:3306/KENNEDY";
    protected static String user = "root";
    protected static String password = "WIFI@2005";

    public static Connection getConnection(){
        try {
            Connection connexion = DriverManager.getConnection(url, user, password);
            System.out.println("\n\tConnexion à la BD KENNEDY réussie !\n");
            return  connexion;
        }catch (
                SQLException e) {
            System.err.println(e.getLocalizedMessage());
            System.exit(1);
        }
        return null;
    }

}
