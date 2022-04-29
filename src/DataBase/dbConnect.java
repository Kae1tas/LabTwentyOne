package DataBase;

import java.sql.*;
public class dbConnect {
    final static String connectionUrl = "jdbc:sqlite:identifier.sqlite";
    private static Connection connection;
    private static Statement stmt;

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(connectionUrl);
            stmt = connection.createStatement();
            System.out.println("Connected");
            String loginOne = "login1";
            String passOne = "pass1";
            String query = "SELECT * FROM users WHERE login='login1' AND pass='pass1' ";
            String nickReturn = " ";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                nickReturn = rs.getString("nick");
                System.out.println(rs.getString("nick"));
            }
            if (nickReturn == " ") System.out.println("Ничего не найдено");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}