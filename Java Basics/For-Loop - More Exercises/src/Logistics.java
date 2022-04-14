import java.util.Scanner;

public class Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int loads = Integer.parseInt(scanner.nextLine());
        int miniVanTotalWeight = 0;
        int truckTotalWeight = 0;
        int trainTotalWeight= 0;
        int totalPrice = 0;

        for (int i = 1; i <= loads ; i++) {
            int loadWeight = Integer.parseInt(scanner.nextLine());

            if (loadWeight <= 3){
                miniVanTotalWeight += loadWeight;
                totalPrice += loadWeight * 200;
            }
            else if (loadWeight <=11){
                truckTotalWeight += loadWeight;
                totalPrice += loadWeight * 175;
            }
            else{
                trainTotalWeight += loadWeight;
                totalPrice += loadWeight * 120;
            }
        }
        int totalWeight = miniVanTotalWeight + truckTotalWeight + trainTotalWeight;
        double minivansPercentage = (miniVanTotalWeight * 1.0 / totalWeight)*100;
        double trucksPercentage = (truckTotalWeight * 1.0 / totalWeight)*100;
        double trainsPercentage = (trainTotalWeight * 1.0 / totalWeight)*100;
        double averagePrice = totalPrice * 1.0 / totalWeight;

        System.out.printf("%.2f%n",averagePrice);
        System.out.printf("%.2f%%%n",minivansPercentage);
        System.out.printf("%.2f%%%n",trucksPercentage);
        System.out.printf("%.2f%%%n",trainsPercentage);
    }
}
