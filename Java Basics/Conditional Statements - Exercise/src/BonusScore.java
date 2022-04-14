import java.util.Scanner;

public class BonusScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int points = Integer.parseInt(scanner.nextLine());
        double bonus = 0;

        if (points<=100){
            bonus = 5;
        }
        else if (points<=1000){
            bonus = 0.2*points;
        }
        else {
            bonus = points*0.1;
        }

        if (points%2==0){
            bonus = bonus + 1;
        }
        if (points%10==5){
            bonus = bonus + 2;
        }

        System.out.println(bonus);
        System.out.println(bonus+points);
    }
}
