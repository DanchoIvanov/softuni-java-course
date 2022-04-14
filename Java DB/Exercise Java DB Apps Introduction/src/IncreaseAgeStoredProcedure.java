import java.sql.*;
import java.util.Scanner;

public class IncreaseAgeStoredProcedure {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = new DBConnector()
                .getConnection();

        int minionID = Integer.parseInt(scanner.nextLine());

        CallableStatement callStatement = connection.prepareCall("CALL usp_get_older(?)");
        callStatement.setInt(1, minionID);
        callStatement.execute();

        PreparedStatement statement = connection.prepareStatement(
                "SELECT name, age FROM minions"
        );

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("name") + " " + resultSet.getInt("age"));
        }
        connection.close();
    }
}
