import java.util.*;
import java.util.stream.Collectors;

public class Cinema {
    public static List<String> visitorNames = new ArrayList<>();
    public static String[] seats;
    public static String[] combinations;
    public static boolean[] used;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        visitorNames = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        seats = new String[visitorNames.size()];

        String input = scanner.nextLine();

        while (!input.equals("generate")) {
            String name = input.split(" - ")[0];
            int seat = Integer.parseInt(input.split(" - ")[1]) - 1;
            seats[seat] = name;
            visitorNames.remove(name);
            input = scanner.nextLine();
        }

        combinations = new String[visitorNames.size()];
        used = new boolean[visitorNames.size()];
        generateVariations(0);
    }

    private static void generateVariations(int index) {
        if (index >= visitorNames.size()) {
            printResult();
        } else {
            for (int i = 0; i < visitorNames.size(); i++) {
                if (!used[i]) {
                    used[i] = true;
                    combinations[index] = visitorNames.get(i);
                    generateVariations(index +1);
                    used[i] = false;
                }
            }
        }
    }

    private static void printResult() {
        int index = 0;
        StringBuilder sb = new StringBuilder();

        for (String seat : seats) {
            if (seat == null) {
                sb.append(combinations[index++]).append(" ");
            } else {
                sb.append(seat).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
