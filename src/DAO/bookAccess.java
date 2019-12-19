/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import com.sun.rowset.CachedRowSetImpl;
import com.sun.rowset.JdbcRowSetImpl;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.*;
import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;

/**
 *
 * @author Soi Lan Tron
 */

// load dang ky driver
//tao ket noi
// tao doi tuong thuc thi
// truyen tham so
public class bookAccess {
    public static Connection sqlConn;
    public static PreparedStatement pstmt;
    public static ResultSet rs;
    public static JdbcRowSet jrs;
    public static CachedRowSet crs;
    
   // rowset trong java bao gồm CachedRowSet Sử dụng 
    //RowSet thực hiện các thao tác thêm, xoá và cập nhật một cách tiện lợi mà không cần phải viết các câu lệnh sql.
    
    public static String url = "jdbc:sqlserver://localhost;database=LibDB";
    public static String user = "sa";
    public static String password = "123";
    public static String sql;
    
    
    public static void setConnectSql() {
    
  
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            sqlConn=DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(bookAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(bookAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
    
        public static void setConnectDB(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            crs = new CachedRowSetImpl();
            crs.setUrl("jdbc:sqlserver://localhost;database=LibDB");
            crs.setUsername("sa");
            crs.setPassword("123");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(bookAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(bookAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static void searchByTitle(String title){
        try {
         //   setConnectSql();
         setConnectDB();
//            sql= " SELECT * FROM Book WHERE Title LIKE '%"+title+"%'";
//            pstmt= sqlConn.prepareStatement(sql);
//            rs = pstmt.executeQuery();
//
//    // dung de thao tac voi java bin / java web
//              jrs = new JdbcRowSetImpl(rs);

           sql = "SELECT * FROM BOOK WHERE Title like '%"+title+"%'";
           // crs Chỉ định cột và dữ liệu được cập nhật
           crs.setCommand(sql);
           crs.execute();
        } catch (SQLException ex) {
            Logger.getLogger(bookAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

  }