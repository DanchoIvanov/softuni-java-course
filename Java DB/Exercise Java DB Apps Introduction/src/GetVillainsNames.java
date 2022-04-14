import java.sql.*;

public class GetVillainsNames {
    public static void main(String[] args) throws SQLException {

        Connection connection = new DBConnector()
                .getConnection();

        PreparedStatement statement = connection.prepareStatement(
                "SELECT v.name, count(DISTINCT mv.minion_id) AS count" +
                " FROM villains AS v" +
                " JOIN minions_villains AS mv ON v.id = mv.villain_id" +
                " GROUP BY v.id" +
                " HAVING count(DISTINCT mv.minion_id) > 15" +
                " ORDER BY count(DISTINCT mv.minion_id) DESC");

        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()){
            System.out.println(resultSet.getString("name") + " " + resultSet.getString("count"));
        }
        connection.close();
    }
}
