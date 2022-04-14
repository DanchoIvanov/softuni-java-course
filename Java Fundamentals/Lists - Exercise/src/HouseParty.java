import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> guestList = new ArrayList<>();

        for (int i = 0 ; i < n; i++) {
            String input = scanner.nextLine();
            String guest = input.split(" ")[0];
            String isGoing = input.split(" ")[2];
            if (isGoing.equals("going!")){
                if (guestList.contains(guest)){
                    System.out.println(guest + " is already in the list!");
                } else {
                    guestList.add(guest);
                }
            } else if (isGoing.equals("not")){
                if (!guestList.contains(guest)){
                    System.out.println(guest + " is not in the list!");
                } else {
                    guestList.remove(guest);
                }
            }
        }
        for (String guest: guestList) {
            System.out.println(guest);
        }
    }
}
