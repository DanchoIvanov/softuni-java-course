import java.util.Scanner;

public class ChristmasGifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int childrenCount =0;
        int adultCount = 0;

        while (!input.equals("Christmas")){
            int age = Integer.parseInt(input);
            if (age <= 16){
                childrenCount++;
            }
            else{
                adultCount++;
            }
            input = scanner.nextLine();
        }
        int toysMoneySpent = childrenCount * 5;
        int sweatersMoneySpent = adultCount * 15;

        System.out.printf("Number of adults: %d%n",adultCount);
        System.out.printf("Number of kids: %d%n",childrenCount);
        System.out.printf("Money for toys: %d%n",toysMoneySpent);
        System.out.printf("Money for sweaters: %d%n",sweatersMoneySpent);
    }
}
