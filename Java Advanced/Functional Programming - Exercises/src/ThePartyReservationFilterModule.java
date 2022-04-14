import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        List<String> filteredGuests = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("Print")){
            String command = input.split(";")[0];
            String option = input.split(";")[1];
            String criteria = input.split(";")[2];

            switch (command){
                case "Add filter":
                    switch (option){
                        case "Starts with":
                            filteredGuests.addAll(guests.stream().filter(n -> n.startsWith(criteria)).collect(Collectors.toList()));
                            break;
                        case "Ends with":
                            filteredGuests.addAll(guests.stream().filter(n -> n.endsWith(criteria)).collect(Collectors.toList()));
                            break;
                        case "Length":
                            int length = Integer.parseInt(criteria);
                            filteredGuests.addAll(guests.stream().filter(n -> n.length() == length).collect(Collectors.toList()));
                            break;
                        case "Contains":
                            filteredGuests.addAll(guests.stream().filter(n -> n.contains(criteria)).collect(Collectors.toList()));
                            break;
                    }
                    break;
                case "Remove filter":
                    switch (option){
                        case "Starts with":
                            filteredGuests = filteredGuests.stream().filter(n -> !n.startsWith(criteria)).collect(Collectors.toList());
                            break;
                        case "Ends with":
                            filteredGuests = filteredGuests.stream().filter(n -> !n.endsWith(criteria)).collect(Collectors.toList());
                            break;
                        case "Length":
                            int length = Integer.parseInt(criteria);
                            filteredGuests = filteredGuests.stream().filter(n -> n.length() != length).collect(Collectors.toList());
                            break;
                        case "Contains":
                            filteredGuests = filteredGuests.stream().filter(n -> !n.contains(criteria)).collect(Collectors.toList());
                            break;
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        List<String> finalFilteredGuests = filteredGuests;
        Predicate<String> predicate = n -> !finalFilteredGuests.contains(n);

        guests.stream().filter(predicate).forEach(n -> System.out.print(n + " "));
    }
}
