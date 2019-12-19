/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Soi Lan Tron
 */
public class ConnectToSqlServer {
    //http://viettuts.vn/java-jdbc/connection-trong-java
    // PreparedStatement là một đối tượng mà biểu diễn một lệnh SQL 
    //được biên dịch trước. Tức là, một lệnh SQL được biên dịch trước
    //và được lưu trữ trong một đối tượng PreparedStatement. 
    //Đối tượng này sau đó có thể được sử dụng để thực thi có hiệu quả 
    //Statement này nhiều lần.
    // PreparedStatement giúp tăng hiệu suất, bởi vì truy vấn của bạn sẽ được biên dịch chỉ một lần.

    //ResultSet duy trì một con trỏ trỏ đến một hàng của một bảng. 
    //Ban đầu, con trỏ trỏ đến hàng đầu tiên. 
    
    //Connection trong java là phiên làm việc giữa ứng dụng java 
    //và cơ sở dữ liệu
    
    //
    
    public PreparedStatement pstmt;
    public Connection conn;
    public ResultSet rs;

    public void setConnection() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;database=LibDB", "sa", "123");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectToSqlServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectToSqlServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
