package home.budget;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LearnMain {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        final String URL = "jdbc:mysql://localhost:3306/HomeBudgetTwo?characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
        final String USERNAME = "root";
        final String PASSWORD = "root";
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();
      //  statement.executeQuery("SELECT ")
        connection.close();
    }
}
