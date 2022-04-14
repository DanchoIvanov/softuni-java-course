import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        int specialNumber = Integer.parseInt(input.split(" ")[0]);
        int power = Integer.parseInt(input.split(" ")[1]);

        if (numbers.contains(specialNumber)){
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) == specialNumber){
                    int leftBombArea = i - power;
                    if (i - power < 0){
                        leftBombArea = 0;
                    }
                    int rightBombArea = i + power;
                    if (i + power > numbers.size()-1){
                        rightBombArea = numbers.size()-1;
                    }
                    for (int j = rightBombArea; j >= leftBombArea ; j--) {
                        numbers.remove(j);
                    }
                    i=-1;
                }
            }
        }

        int sum = 0;
        for (int element:numbers) {
            sum += element;
        }
        System.out.println(sum);

    }
}
