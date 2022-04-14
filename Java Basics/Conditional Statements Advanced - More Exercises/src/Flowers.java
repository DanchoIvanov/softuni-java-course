import java.util.Scanner;

public class Flowers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int chrysanthemumsBought = Integer.parseInt(scanner.nextLine());
        int rosesBought = Integer.parseInt(scanner.nextLine());
        int tulipsBought = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        String holiday = scanner.nextLine();

        double chrysanthemumsPrice = 0;
        double rosesPrice = 0;
        double tulipsPrice = 0;

        if (season.equals("Spring") || season.equals("Summer")){
            chrysanthemumsPrice = 2;
            rosesPrice = 4.1;
            tulipsPrice = 2.5;
        }
        else if (season.equals("Autumn") || season.equals("Winter")){
            chrysanthemumsPrice = 3.75;
            rosesPrice = 4.5;
            tulipsPrice = 4.15;
        }

        if (holiday.equals("Y")){
            chrysanthemumsPrice = chrysanthemumsPrice * 1.15;
            rosesPrice = rosesPrice * 1.15;
            tulipsPrice = tulipsPrice * 1.15;
        }

        double bouquetPrice = chrysanthemumsBought * chrysanthemumsPrice + rosesBought * rosesPrice + tulipsBought * tulipsPrice;

        if (tulipsBought > 7 && season.equals("Spring")){
            bouquetPrice = bouquetPrice *0.95;
        }
        else if (rosesBought >= 10 && season.equals("Winter")){
            bouquetPrice = bouquetPrice * 0.9;
        }

        if (chrysanthemumsBought + rosesBought + tulipsBought > 20){
            bouquetPrice = bouquetPrice * 0.8;
        }

        System.out.printf("%.2f",bouquetPrice + 2);
    }
}
