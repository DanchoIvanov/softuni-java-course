import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();
        double price = 0;

        switch (groupType){
            case "Students":
                switch (dayOfWeek){
                    case "Friday":
                        price = 8.45;
                        break;
                    case "Saturday":
                        price = 9.8;
                        break;
                    case "Sunday":
                        price = 10.46;
                        break;
                }break;
            case "Business":
                switch (dayOfWeek){
                    case "Friday":
                        price = 10.9;
                        break;
                    case "Saturday":
                        price = 15.6;
                        break;
                    case "Sunday":
                        price = 16;
                        break;
                }break;
            case "Regular":
                switch (dayOfWeek){
                    case "Friday":
                        price = 15;
                        break;
                    case "Saturday":
                        price = 20;
                        break;
                    case "Sunday":
                        price = 22.5;
                        break;
                }break;
        }

        if (people >= 30 && groupType.equals("Students")){
            price = price  * 0.85;
        } else if (people >= 100 && groupType.equals("Business")){
            people -= 10;
        } else if (people >= 10 && people <= 20 && groupType.equals("Regular")){
            price = price  * 0.95;
        }

        double totalPrice = people * price;

        System.out.printf("Total price: %.2f", totalPrice);
    }
}
