/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg123210068_responsi;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author PC PRAKTIKUM
 */
public class Connector {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/responsi_prak_pbo";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection conn;
    Statement statement;
    PreparedStatement pstmt;

    public Connector() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (Exception e) {
            System.out.println("Connection failed");
        }
    }
    
    
    
    
}
