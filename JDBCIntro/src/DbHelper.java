import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    private String username = "root";
    private String password = "12345";
    private String dbURL = "jdbc:mysql://localhost:3306/world";
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbURL, username, password);
    }
    public void showErrorMessage (SQLException exception){
        System.out.println("Error: "+exception.getMessage());
        System.out.println("Error code : "+exception.getErrorCode());

    }
}
