package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private String url = "jdbc:mysql://localhost:3306/furama";
    private String username = "root";
    private String password = "hongson";
    private Connection connection;

    public BaseRepository(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    public Connection getConnection(){
        return connection;
    }
}
