import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrintAllMinionNames {
    public static void main(String[] args) throws SQLException {

        Connection connection = new DBConnector()
                .getConnection();

        PreparedStatement getMinions = connection.prepareStatement(
                "SELECT name FROM minions"
        );

        ResultSet resultSet = getMinions.executeQuery();
        List<String> minionNames = new ArrayList<>();

        while (resultSet.next()) {
            minionNames.add(resultSet.getString("name"));
        }

        while (!minionNames.isEmpty()){
            System.out.println(minionNames.remove(0));
            if (!minionNames.isEmpty()) {
                System.out.println(minionNames.remove(minionNames.size() - 1));
            }
        }

        connection.close();
    }
}
