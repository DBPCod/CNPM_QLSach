/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author HP
 */
public class ConnectDB {
    private static final String URL = "jdbc:mysql://localhost:3306/qlsach"; // Thay đổi tên cơ sở dữ liệu
    private static final String USER = "root"; // Tên người dùng
    private static final String PASSWORD = ""; // M    ật khẩu

    public static Connection connect() {
        Connection connection = null;
        try {
            // Kết nối đến cơ sở dữ liệu
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Kết nối thành công đến cơ sở dữ liệu!");
        } catch (SQLException e) {
            System.out.println("Kết nối thất bại!");
            e.printStackTrace();
        }
        return connection;
    }
    
    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
        // Đóng ResultSet
        System.out.println(conn +" and " +stmt +" and " + rs);
        if (rs != null) {
            try {
                rs.close();
                System.out.println("ResultSet đã được đóng.");
            } catch (SQLException e) {
                System.err.println("Đóng ResultSet thất bại.");
                e.printStackTrace();
            }
        }

        // Đóng Statement
        if (stmt != null) {
            try {
                stmt.close();
                System.out.println("Statement đã được đóng.");
            } catch (SQLException e) {
                System.err.println("Đóng Statement thất bại.");
                e.printStackTrace();
            }
        }

        // Đóng Connection
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connection đã được đóng.");
            } catch (SQLException e) {
                System.err.println("Đóng Connection thất bại.");
                e.printStackTrace();
            }
        }
    }
}
