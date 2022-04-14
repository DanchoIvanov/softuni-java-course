import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RemoveVillain {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = new DBConnector().getConnection();

        int villainID = Integer.parseInt(scanner.nextLine());

        PreparedStatement getVillainName = connection.prepareStatement(
                "SELECT name FROM villains WHERE id = ?");

        getVillainName.setInt(1, villainID);

        ResultSet resultSet = getVillainName.executeQuery();

        if (!resultSet.next()) {
            System.out.println("No such villain was found");
            return;
        }

        String villainName = resultSet.getString("name");

        connection.setAutoCommit(false);

        try {
            PreparedStatement releaseMinions = connection.prepareStatement(
                    "UPDATE minions_villains" +
                            " SET villain_id = null" +
                            " WHERE villain_id = ?");

            releaseMinions.setInt(1, villainID);
            int releasedMinionsCount = releaseMinions.executeUpdate();

            PreparedStatement deleteVillain = connection.prepareStatement(
                    "DELETE v FROM villains AS v WHERE v.id = ?");

            deleteVillain.setInt(1, villainID);
            deleteVillain.executeUpdate();

            connection.commit();

            System.out.println(villainName + " was deleted");
            System.out.println(releasedMinionsCount + " minions released");

        } catch (SQLException e) {
            connection.rollback();
        }

        connection.close();
    }
}
