import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!input.equals("End")){
            String destination = input;
            double budget = Double.parseDouble(scanner.nextLine());
            int savedMoney = 0;
            while (savedMoney < budget){
               String input1 = scanner.nextLine();
                if (input1.equals("End")) {
                    return;
                }
               double currentMoney = Double.parseDouble(input1);
               savedMoney +=currentMoney;
               if (savedMoney >=budget){
                   System.out.printf("Going to %s!%n",destination);
               }
            }
            input = scanner.nextLine();
        }
    }
}
