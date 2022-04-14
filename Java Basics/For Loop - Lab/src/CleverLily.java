import java.util.Scanner;

public class CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int years = Integer.parseInt(scanner.nextLine());
        double laundryMachinePrice = Double.parseDouble(scanner.nextLine());
        int singleToyPrice = Integer.parseInt(scanner.nextLine());

        int moneyGift = 0;
        double toysTotalSum = 0;

        for (int i = 1; i <= years; i++) {
            if (i % 2 == 0){
                moneyGift = moneyGift + (i/2) * 10 - 1;
            }
            else
                toysTotalSum = toysTotalSum + singleToyPrice;
        }
        double difference = Math.abs(toysTotalSum + moneyGift - laundryMachinePrice);

        if (toysTotalSum + moneyGift >= laundryMachinePrice){
            System.out.printf("Yes! %.2f",difference);
        }
        else
            System.out.printf("No! %.2f",difference);
    }
}
