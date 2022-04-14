import java.util.Scanner;

public class Dishwasher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bottles = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int loadCount = 0;
        int dishes =0;
        int pots = 0;
        boolean isEnough = true;
        int detergent = 0;
        int detergentNeeded = 0;
        int difference = 0;

        while (!input.equals("End")){
            int load = Integer.parseInt(input);
            loadCount++;
            if (loadCount % 3 == 0){
                pots += load;
            }
            else{
                dishes += load;
            }
            detergent = bottles * 750;
            detergentNeeded = pots * 15 + dishes * 5;
            difference = Math.abs(detergent - detergentNeeded);
            if (detergent < detergentNeeded){
                isEnough = false;
                break;
            }
            input = scanner.nextLine();
        }

        if (isEnough == true){
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.%n", dishes, pots);
            System.out.printf("Leftover detergent %d ml.%n",difference);
        }
        else{
            System.out.printf("Not enough detergent, %d ml. more necessary!%n",difference);
        }
    }
}
