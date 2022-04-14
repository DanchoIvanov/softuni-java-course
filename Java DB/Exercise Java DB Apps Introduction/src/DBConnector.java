import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector {
    private String user;
    private String password;
    private String url;

    //set connection properties here
    private static final String USER = "";
    private static final String PASSWORD = "";
    private static final String URL = "";

    public DBConnector(String user, String password, String url) {
        this.user = user;
        this.password = password;
        this.url = url;
    }

    public DBConnector() {
        this.user = USER;
        this.password = PASSWORD;
        this.url = URL;
    }

    public Connection getConnection() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        return DriverManager
                .getConnection(url, props);
    }
}
