package util;

import util.log.Logcat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection = null;

    private static String DB="jdbc:mysql://localhost:3306/order_sys?autoReconnect=true";

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");

            if(connection == null) {
                connection = DriverManager.getConnection(DB, "root", "root186" +
                        "");
            }

            return connection;
        } catch (SQLException e) {
            e.printStackTrace();

            //输出错误信息
            Logcat.log(e.getMessage());
            Logcat.log(e.getSQLState());

            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

            return null;
        }
    }
}
