import java.util.*;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> reservations = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Party!")){
            String command = input.split("\\s+")[0];
            String option = input.split("\\s+")[1];

            switch (command){
                case "Remove":
                    String criteria = input.split("\\s+")[2];
                    switch (option){
                        case "StartsWith":
                            reservations = reservations.stream().filter(n -> !n.startsWith(criteria)).collect(Collectors.toList());
                            break;
                        case "EndsWith":
                            reservations = reservations.stream().filter(n -> !n.endsWith(criteria)).collect(Collectors.toList());
                            break;
                        case "Length":
                            int length = Integer.parseInt(input.split("\\s+")[2]);
                            reservations = reservations.stream().filter(n -> n.length() != length).collect(Collectors.toList());
                            break;
                    }
                    break;
                case "Double":
                    criteria = input.split("\\s+")[2];
                    switch (option) {
                        case "StartsWith":
                            List<String> addReservations = reservations.stream().filter(n -> n.startsWith(criteria)).collect(Collectors.toList());
                            reservations.addAll(addReservations);
                            break;
                        case "EndsWith":
                            addReservations = reservations.stream().filter(n -> n.endsWith(criteria)).collect(Collectors.toList());
                            reservations.addAll(addReservations);
                            break;
                        case "Length":
                            int length = Integer.parseInt(input.split("\\s+")[2]);
                            addReservations = reservations.stream().filter(n -> n.length() == length).collect(Collectors.toList());
                            reservations.addAll(addReservations);
                            break;
                    }
            }
            input = scanner.nextLine();
        }
        if (!reservations.isEmpty()){
            System.out.printf("%s are going to the party!", reservations.stream().sorted().collect(Collectors.joining(", ")));
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }
}
