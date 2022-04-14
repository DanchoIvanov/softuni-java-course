import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set <String>parkingLot = new LinkedHashSet<>();
        String input = scanner.nextLine();

        while (!input.equals("END")){
            String command = input.split(", ")[0];
            String licensePlate = input.split(", ")[1];

            switch (command){
                case "IN":
                    parkingLot.add(licensePlate);
                    break;
                case "OUT":
                    parkingLot.remove(licensePlate);
                    break;
            }

            input = scanner.nextLine();
        }

        if (parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        } else {
            for ( String licensePlate : parkingLot){
                System.out.println(licensePlate);
            }
        }
    }
}
