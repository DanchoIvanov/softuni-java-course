import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeTownNamesCasing {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = new DBConnector().getConnection();

        String townName = scanner.nextLine();

        PreparedStatement statement = connection.prepareStatement(
                "UPDATE towns" +
                        " SET name = UPPER(name)" +
                        " WHERE country = ?");

        statement.setString(1, townName);

        int affectedRows = statement.executeUpdate();

        if (affectedRows == 0) {
            System.out.println("No town names were affected.");
            return;
        }

        System.out.println(affectedRows + " town names were affected.");
            PreparedStatement getAffectedTowns = connection.prepareStatement(
                    "SELECT name" +
                            " FROM towns" +
                            " WHERE country = ?");

            getAffectedTowns.setString(1, townName);

            ResultSet resultSet = getAffectedTowns.executeQuery();
            List<String> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(resultSet.getString("name"));
            }

            System.out.println(result);
            connection.close();
    }
}
