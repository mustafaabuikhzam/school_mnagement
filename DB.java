/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ahmed
 */
public class DB {
    private static Connection connection = null;
    
    public static Connection DBconnect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_management", "root", "");
            return connection;

        } catch (ClassNotFoundException | SQLException ex) {
            Alert.viewWarningMessage("Couldn't connect to database");
            return connection;
        }
    }
}