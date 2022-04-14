import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IncreaseMinionsAge {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = new DBConnector().getConnection();

        int[] values = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String updateQuery = String.format("UPDATE minions SET name = lower(name), age = age + 1 WHERE id IN (%s)",
                Arrays.stream(values)
                        .mapToObj(i -> ((Integer) i).toString())
                        .collect(Collectors.joining(", ")));

        PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
        updateStatement.executeUpdate();

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
