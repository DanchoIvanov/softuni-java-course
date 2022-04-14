import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetMinionNames {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = new DBConnector()
                .getConnection();

        PreparedStatement villainStatement = connection.prepareStatement(
                    "SELECT name" +
                        " FROM villains" +
                        " WHERE id = ?;");

        String villainID = scanner.nextLine();
        villainStatement.setInt(1, Integer.parseInt(villainID));

        ResultSet villainResultSet = villainStatement.executeQuery();
        if (!villainResultSet.next()) {
            System.out.printf("No villain with ID %s exists in the database.%n",villainID);
        } else {
            PreparedStatement minionsStatement = connection.prepareStatement(
                        "SELECT m.name, m.age" +
                            " FROM minions AS m" +
                            " JOIN minions_villains AS mv ON mv.minion_id = m.id" +
                            " WHERE mv.villain_id = ?;");

            minionsStatement.setInt(1, Integer.parseInt(villainID));

            ResultSet minionsResultSet = minionsStatement.executeQuery();

            System.out.printf("Villain: %s%n",villainResultSet.getString("name"));
            int count = 1;
            while (minionsResultSet.next()) {
                System.out.printf("%d. %s %s%n",count++, minionsResultSet.getString("name"), minionsResultSet.getString("age"));
            }
        }
        connection.close();
    }
}
