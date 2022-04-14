import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double savings = Double.parseDouble(scanner.nextLine());

        List<Integer> drumSet = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> drumSetCurrentState = new ArrayList<>(drumSet);
        String input = scanner.nextLine();
        while(!input.equals("Hit it again, Gabsy!")){
            int hitPower = Integer.parseInt(input);
            for (int i = 0; i < drumSetCurrentState.size(); i++) {
                drumSetCurrentState.set(i, drumSetCurrentState.get(i) - hitPower);
                if (drumSetCurrentState.get(i) <= 0){
                    int replacementPrice = drumSet.get(i) * 3;
                    if (replacementPrice <= savings){
                        savings -= replacementPrice;
                        drumSetCurrentState.set(i, drumSet.get(i));
                    } else {
                        drumSetCurrentState.remove(i);
                        drumSet.remove(i);
                        i--;
                    }
                }
            }
            input = scanner.nextLine();
        }
        for (int drum:drumSetCurrentState) {
            System.out.printf("%d ",drum);
        }
        System.out.println();
        System.out.printf("Gabsy has %.2flv.",savings);
    }
}
