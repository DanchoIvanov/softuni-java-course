import java.util.Scanner;

public class TradeCommissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String city = scanner.nextLine();
        double sales = Double.parseDouble(scanner.nextLine());

        double commissionPercentage = 0;

        if (sales >= 0 && sales <=500){
            if (city.equals("Sofia")) {
                commissionPercentage = 0.05;
            }
            else if (city.equals("Varna")){
                commissionPercentage = 0.045;
            }
            else if (city.equals("Plovdiv")){
                commissionPercentage = 0.055;
            }
        }
        else if (sales > 500 && sales <=1000){
            if (city.equals("Sofia")) {
                commissionPercentage = 0.07;
            }
            else if (city.equals("Varna")){
                commissionPercentage = 0.075;
            }
            else if (city.equals("Plovdiv")){
                commissionPercentage = 0.08;
            }
        }
        else if (sales > 1000 && sales <=10000){
            if (city.equals("Sofia")) {
                commissionPercentage = 0.08;
            }
            else if (city.equals("Varna")){
                commissionPercentage = 0.1;
            }
            else if (city.equals("Plovdiv")){
                commissionPercentage = 0.12;
            }
        }
        else if (sales > 10000){
            if (city.equals("Sofia")) {
                commissionPercentage = 0.12;
            }
            else if (city.equals("Varna")){
                commissionPercentage = 0.13;
            }
            else if (city.equals("Plovdiv")){
                commissionPercentage = 0.145;
            }
        }
        double commission = sales*commissionPercentage;

        if (commissionPercentage == 0){
            System.out.println("error");
        }
        else
            System.out.printf("%.2f",commission);
    }
}
