import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        int length = input.length();
        String output = "";

        for (int number : numbers){
            int sum = 0;
            while (number!=0){
                sum+= number%10;
                number /=10;
            }

            while (sum >= input.length()){
                sum -=input.length();
            }
            output += input.charAt(sum);
            StringBuilder sb = new StringBuilder(input);
            sb.deleteCharAt(sum);
            input = sb.toString();
        }
        System.out.println(output);
    }
}
