/** 사용하지 않음 -> ConnectionPoolMgr 으로 대체 **/

//package org.example.overview.database;
//
//import org.h2.Driver;
//
//import java.sql.*;
//
//public class JDBCMgr { // h2 DB 연결
//
//    private static Connection conn;
//
//    private JDBCMgr() {}
//
//    public static Connection getConnection() {
//        //Connection conn = null;
//
//        if (conn == null) {
//            try {
//                DriverManager.registerDriver(new Driver());
//                conn = DriverManager.getConnection("jdbc:h2:~/JDBC;DB_CLOSE_DELAY=-1", "sa", "");
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return conn;
//    }
//
//    public static void close() {
//
//        if (conn != null) {
//
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
//
//
//    // PreparedStatement: PreCompiled SQL 저장 객체
//    // Connection: DB 커넥션 객체
//    public static void close(PreparedStatement stmt) {
//        if (stmt != null) {
//
//            try {
//                stmt.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        if (conn != null) {
//
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
//
//    // ResultSet: SQL 실행결과 저장 객체
//    // PreparedStatement: PreCompiled SQL 저장 객체
//    // Connection: DB 커넥션 객체
//    public static void close(ResultSet rs, PreparedStatement stmt) {
//
//        if (rs != null) {
//
//            try {
//                rs.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        close(stmt);
//    }
//}
