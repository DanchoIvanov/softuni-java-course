import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxCount = 0;
        int repeatedElement = 0;

        for (int i = 0; i < numbers.length; i++) {
            int count = 0;
            int currentRepeatingElement = 0;
            for (int j = i+1; j < numbers.length; j++) {
                if(numbers[i] == numbers[j]){
                    count ++;
                    currentRepeatingElement = numbers[i];
                } else {
                    i+=count;
                    break;
                }
            }
            if (maxCount < count){
                maxCount = count;
                repeatedElement = currentRepeatingElement;
            }
        }
        for (int i = 0; i < maxCount+1; i++) {
            System.out.printf("%d ",repeatedElement);
        }
    }
}

