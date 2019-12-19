/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.bookAccess.crs;
import static DAO.bookAccess.setConnectDB;
import static DAO.bookAccess.sql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Soi Lan Tron
 */
public class studentAccess {
    
majorAccess obj = new majorAccess();

    public static Connection sqlConn;
    public static PreparedStatement pstmt;
    public static ResultSet rs;
    public static JdbcRowSet jrs;
    public static CachedRowSet crs;
    
    public static String url = "jdbc:sqlserver://localhost;database=LibDB";
    public static String user = "sa";
    public static String password = "123";
    public static String esql;
    public static void searchByID(String studentid){
        try {
         //   setConnectSql();
         setConnectDB();
//            sql= " SELECT * FROM Book WHERE Title LIKE '%"+title+"%'";
//            pstmt= sqlConn.prepareStatement(sql);
//            rs = pstmt.executeQuery();
//
//    // dung de thao tac voi java bin / java web
//              jrs = new JdbcRowSetImpl(rs);

           esql = "SELECT * FROM Student WHERE StudentId like '%"+studentid+"%'";
           crs.setCommand(esql);
           crs.execute();
        } catch (SQLException ex) {
            Logger.getLogger(studentAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


