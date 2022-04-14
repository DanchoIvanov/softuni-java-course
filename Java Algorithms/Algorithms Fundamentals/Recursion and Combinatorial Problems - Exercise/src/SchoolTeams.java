import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SchoolTeams {

    public static final int GIRLS_TEAM_COUNT = 3;
    public static final int BOYS_TEAM_COUNT = 2;
    public static String[] girlsTeam = new String[GIRLS_TEAM_COUNT];
    public static String[] boysTeam = new String[GIRLS_TEAM_COUNT];
    public static List<String[]> girlsCombinations = new ArrayList<>();
    public static List<String[]> boysCombinations = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] girls = scanner.nextLine().split(", ");
        String[] boys = scanner.nextLine().split(", ");

        permute(girls, girlsTeam, girlsCombinations, GIRLS_TEAM_COUNT, 0, 0);
        permute(boys, boysTeam, boysCombinations, BOYS_TEAM_COUNT, 0, 0);
        printResults();
    }

    private static void printResults() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < girlsCombinations.size(); i++) {
            for (int j = 0; j < boysCombinations.size(); j++) {
                String[] result = concatenateArrays(girlsCombinations.get(i), boysCombinations.get(j));
                sb.append(String.join(", ", result)).append(System.lineSeparator());

            }
        }
        System.out.println(sb.toString().trim());
    }

    private static String[] concatenateArrays(String[] a, String[] b) {

        String[] result = new String[a.length + b .length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);

        return result;
    }

    private static void permute(String[] names, String[] team, List<String[]> combinations, int teamCount, int index, int start) {
        if (index >= teamCount) {
            combinations.add(Arrays.copyOf(team, teamCount));
            return;
        }

        for (int i = start; i < names.length; i++) {
            team[index] = names[i];
            permute(names, team, combinations, teamCount, index + 1, i + 1);
        }
    }
}
