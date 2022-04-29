import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseAuthService implements AuthService {
    private static Connection connection;
    private static Statement statement;
    private static final String url = "jdbc:sqlite:C:\\sqlite\\users.db";

    @Override
    public void start() {
        System.out.println("Сервис аутентификации запущен");
    }

    @Override
    public void stop() {
        System.out.println("Сервис аутентификации остановлен");
    }

    private static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection(url);
        statement = connection.createStatement();
        System.out.println("Connected");
    }
    @Override
    public String getNickByLoginPass(String login, String pass) throws SQLException, ClassNotFoundException {
        connect();
        String query = "SELECT * from users";
        ResultSet rs = statement.executeQuery(query);
        String nick = "";
        while(rs.next()) {
            if(rs.getString("login").equals(login) && rs.getString("password").equals(pass)){
                nick = rs.getString("nick");
            }
        }
        if(nick!=""){
            return nick;
        }
        connection.close();
        return null;
    }
    //  void connect
    //
}