import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int coinCount = 0;
        double change = Double.parseDouble(scanner.nextLine())*100;

        while (change > 0){
            if (change >= 200){
                change -= 200;
                coinCount ++;
            }
            else if (change >= 100){
                change -= 100;
                coinCount ++;
            }
            else if (change >= 50){
                change -= 50;
                coinCount ++;
            }
            else if (change >= 20){
                change -= 20;
                coinCount ++;
            }
            else if (change >= 10){
                change -= 10;
                coinCount ++;
            }
            else if (change >= 5){
                change -= 5;
                coinCount ++;
            }
            else if (change >= 2){
                change -= 2;
                coinCount ++;
            }
            else if (change >= 1){
                change -= 1;
                coinCount ++;
            }
            else {
                change = 0;
            }
        }
        System.out.println(coinCount);
    }
}
