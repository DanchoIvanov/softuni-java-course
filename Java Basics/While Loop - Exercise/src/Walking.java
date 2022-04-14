import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int steps = 0;
        int totalSteps = 0;

        while (totalSteps < 10000){
            if (input.equals("Going home")){
                input = scanner.nextLine();
                steps = Integer.parseInt(input);
                totalSteps += steps;
                break;
            }
            steps = Integer.parseInt(input);
            totalSteps += steps;
            if (totalSteps >=10000){
                break;
            }

            input = scanner.nextLine();
        }

        int difference = Math.abs(totalSteps - 10000);

        if (totalSteps < 10000){
            System.out.printf("%d more steps to reach goal.",difference);
        }
        else
            System.out.printf("Goal reached! Good job!%n%d steps over the goal!", difference);
    }
}
