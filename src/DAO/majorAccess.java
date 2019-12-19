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
public class majorAccess {

    public PreparedStatement pstmt;
    public Connection sqlCon;
    public ResultSet rs;

    public void setConn() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            sqlCon = DriverManager.getConnection("jdbc:sqlserver://localhost;database=LibDB", "sa", "123");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(majorAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(majorAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addMajor(String majorName, String phone) {
        try {
            setConn();
            pstmt = sqlCon.prepareStatement("INSERT major VALUES(?,?)");
            pstmt.setString(1, majorName);
            pstmt.setString(2, phone);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(majorAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateMajor(int id, String name, String phone) {
        try {
            setConn();
            pstmt = sqlCon.prepareStatement("UPDATE major SET majorName=?, phone=? WHERE majorId=?");
            pstmt.setString(1, name);
            pstmt.setString(2, phone);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(majorAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteMajor(int id) {
        setConn();
        try {
            pstmt = sqlCon.prepareStatement("DELETE FROM major WHERE majorId=?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(majorAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
