import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            int result = statement.executeUpdate();
            statement.executeUpdate("SET FOREIGN_KEY_CHECKS=0;");
            statement = connection.prepareStatement("insert into city(Name,CountryCode,District,Population) values ('Düzce','TUR','Düzce',500)");

            System.out.println("Kayıt eklendi");

        }
         catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
        finally {

        }
    }
}