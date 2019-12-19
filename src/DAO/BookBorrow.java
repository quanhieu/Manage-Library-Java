/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Soi Lan Tron
 */
public class BookBorrow {

    public PreparedStatement pstmt;
    public Connection conn;
    public ResultSet rs;

    public void setConn() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;database=LibDB", "sa", "123");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookBorrow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookBorrow.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void AddBookBorrow(int sId, int cNumber, String issueDate, String dueDate, String status, String checkOut) {
        try {
            setConn();
            pstmt = conn.prepareStatement("INSERT StudentBook VALUES (?,?,?,?,?,?)");
            pstmt.setInt(1, sId);
            pstmt.setInt(2, cNumber);
            pstmt.setString(3, issueDate);
            pstmt.setString(4, dueDate);
            pstmt.setString(5, status);
            pstmt.setString(6, checkOut);
            
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookBorrow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
