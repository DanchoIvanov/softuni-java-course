import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")){
            String command = input.split(" ")[0];
            switch (command){
                case "Contains":
                    int num = Integer.parseInt(input.split(" ")[1]);
                    System.out.println(numbers.contains(num)? "Yes":"No such number");
                    break;
                case "Print":
                    String option = input.split(" ")[1];
                    if (option.equals("even")){
                        printEven(numbers);
                    } else if (option.equals("odd")){
                        printOdd(numbers);
                    }
                    break;
                case "Get":
                    getSum(numbers);
                    break;
                case "Filter":
                    option = input.split(" ")[1];
                    num = Integer.parseInt(input.split(" ")[2]);
                    filter(option,num,numbers);
                    break;
            }
            input = scanner.nextLine();
        }
    }

    static void filter (String option, int num, List<Integer> numbers){
        for (int i = 0; i < numbers.size(); i++) {
            switch (option){
                case ">":
                    if (numbers.get(i)>num){
                        System.out.printf("%d ",numbers.get(i));
                    }
                    break;
                case "<":
                    if (numbers.get(i)<num){
                        System.out.printf("%d ",numbers.get(i));
                    }
                    break;
                case ">=":
                    if (numbers.get(i)>=num){
                        System.out.printf("%d ",numbers.get(i));
                    }
                    break;
                case "<=":
                    if (numbers.get(i)<=num){
                        System.out.printf("%d ",numbers.get(i));
                    }
                    break;
            }
        }
        System.out.println();
    }

    static void getSum (List <Integer> numbers){
        int sum = 0;
        for ( int element:numbers) {
            sum+= element;
        }
        System.out.println(sum);
    }

    static void printEven (List <Integer> numbers){
        for (int element:numbers) {
            if (element%2==0){
                System.out.printf("%d ",element);
            }
        }
        System.out.println();
    }

    static void printOdd (List <Integer> numbers){
        for (int element:numbers) {
            if (element%2==1){
                System.out.printf("%d ",element);
            }
        }
        System.out.println();
    }
}
