import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.size() == 1){
                System.out.printf("%d ",numbers.get(i));
            } else {
                System.out.printf("%d ", numbers.get(i) + numbers.get(numbers.size()-1));
                numbers.remove(numbers.size()-1);
                numbers.remove(i);
                i = -1;
            }
        }
    }
}
