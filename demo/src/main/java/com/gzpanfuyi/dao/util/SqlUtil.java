package com.gzpanfuyi.dao.util;

import java.sql.*;
import java.util.ResourceBundle;

public class SqlUtil {
    private static ResourceBundle rs = ResourceBundle.getBundle("mysql");
    private static String  driver = rs.getString("driver");
    private static String url = rs.getString("url");
    private static String name = rs.getString("username");
    private static String password = rs.getString("password");
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,name,password);
    }
    public static void close(ResultSet rs, Statement state, Connection conn){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (state != null) {
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Statement state, Connection conn){
        if (state != null) {
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
