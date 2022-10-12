package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {

    public static Connection getConnection() {
        String jdbcURL = "jdbc:mysql://localhost:3306/finalexam3";
        String jdbcUsername = "root";
        String jdbcPassword = "123456";
        Connection connection = null;
        try {
            System.out.println("Kết nối thành công");
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("Connection successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("Kết nối thất bại");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("Kết nối thất bại");
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void main(String[] args) {
        getConnection();
    }

}
