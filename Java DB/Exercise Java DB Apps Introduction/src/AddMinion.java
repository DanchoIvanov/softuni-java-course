import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddMinion {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = new DBConnector()
                .getConnection();

        String[] minionInfo = scanner.nextLine().split("\\s+");
        String minionName = minionInfo[1];
        int minionAge = Integer.parseInt(minionInfo[2]);
        String minionCity = minionInfo[3];

        String villainName = scanner.nextLine().split("\\s+")[1];

        int cityId = getCityId(connection, minionCity);

        addMinion(connection, minionName, minionAge, cityId);

        int minionID = getMinionID(connection, minionName, minionAge, cityId);
        int villainID = getVillainID(connection, villainName);

        AddMinionToVillain(connection, minionID, villainID);
        System.out.printf("Successfully added %s to be minion of %s.%n", minionName, villainName);

        connection.close();
    }

    private static void AddMinionToVillain(Connection connection, int minionID, int villainID) throws SQLException {
        PreparedStatement addMinionToVillain = connection.prepareStatement(
                "INSERT INTO minions_villains (minion_id, villain_id)" +
                        " VALUES (?, ?)");

        addMinionToVillain.setInt(1, minionID);
        addMinionToVillain.setInt(2, villainID);
        addMinionToVillain.executeUpdate();
    }

    private static int getMinionID(Connection connection, String minionName, int minionAge, int cityId) throws SQLException {
        PreparedStatement getMinionIDStatement = connection.prepareStatement(
                    "SELECT id" +
                        " FROM minions" +
                        " WHERE name = ? AND age = ? AND town_id = ?");

        getMinionIDStatement.setString(1, minionName);
        getMinionIDStatement.setInt(2, minionAge);
        getMinionIDStatement.setInt(3, cityId);

        ResultSet minionID = getMinionIDStatement.executeQuery();
        minionID.next();

        return minionID.getInt("id");
    }

    private static int getVillainID(Connection connection, String villainName) throws SQLException {
        PreparedStatement getVillainIDStatement = connection.prepareStatement(
                    "SELECT id" +
                        " FROM villains" +
                        " WHERE name = ?");

        getVillainIDStatement.setString(1, villainName);

        ResultSet villainIDResultSet = getVillainIDStatement.executeQuery();

        if (!villainIDResultSet.next()) {
            PreparedStatement addVillainStatement = connection.prepareStatement(
                        "INSERT INTO villains (name, evilness_factor)" +
                            " VALUES (?, 'evil');");

            addVillainStatement.setString(1, villainName);
            addVillainStatement.executeUpdate();

            villainIDResultSet = getVillainIDStatement.executeQuery();

            System.out.printf("Villain %s was added to the database.%n", villainName);
            villainIDResultSet.next();
        }

        return villainIDResultSet.getInt("id");
    }

    private static void addMinion(Connection connection, String minionName, int minionAge, int cityId) throws SQLException {
        PreparedStatement addMinionStatement = connection.prepareStatement(
                "INSERT INTO minions (name, age, town_id)" +
                        " VALUES (?, ?, ?);");

        addMinionStatement.setString(1, minionName);
        addMinionStatement.setInt(2, minionAge);
        addMinionStatement.setInt(3, cityId);
        addMinionStatement.executeUpdate();
    }

    private static int getCityId(Connection connection, String minionCity) throws SQLException {
        PreparedStatement getCityIDStatement = connection.prepareStatement(
                    "SELECT id" +
                        " FROM towns" +
                        " WHERE name = ?");

        getCityIDStatement.setString(1, minionCity);

        ResultSet cityIDResultSet = getCityIDStatement.executeQuery();

        if (!cityIDResultSet.next()) {
            PreparedStatement addCityStatement = connection.prepareStatement(
                        "INSERT INTO towns (name)" +
                            " VALUES (?);");

            addCityStatement.setString(1, minionCity);
            addCityStatement.executeUpdate();

            cityIDResultSet = getCityIDStatement.executeQuery();

            System.out.printf("Town %s was added to the database.%n", minionCity);
            cityIDResultSet.next();
        }

        return cityIDResultSet.getInt("id");
    }
}