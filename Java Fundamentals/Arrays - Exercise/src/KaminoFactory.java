import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] numbers = new int[n];
        int[] numbersMaxSequence = new int[n];
        int maxCount = 0;
        int maxCountSum = 0;
        int inputCount = 0;
        int maxCountInputNumber = 0;
        int maxCountStartIndex = Integer.MAX_VALUE;

        String input = scanner.nextLine();
        while (!input.equals("Clone them!")){
            inputCount++;
            numbers = new int[n];
            int arrayLength = 0;
            int arraySum = 0;
            for (int i = 0; i < input.length(); i++) {
                if (Character.isDigit(input.charAt(i))){
                    numbers[arrayLength] = Integer.parseInt(String.valueOf(input.charAt(i)));
                    arrayLength++;
                    arraySum+= Integer.parseInt(String.valueOf(input.charAt(i)));
                }
                if (arrayLength == n){
                    break;
                }
            }
            int startIndex = 0;
            int count = 0;
            int currentMaxCount = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == 1){
                    for (int j = i+1; j < numbers.length; j++) {
                        if (numbers[i] == numbers[j]){
                            count++;
                            if (currentMaxCount < count){
                                currentMaxCount = count;
                                startIndex = i -currentMaxCount;
                            }
                        } else {
                            i+=count;
                            break;
                        }
                    }
                }
            }
            if (count > maxCount){
                numbersMaxSequence = numbers;
                maxCount = count;
                maxCountSum = arraySum;
                maxCountInputNumber = inputCount;
                maxCountStartIndex = startIndex;
            } else if (startIndex < maxCountStartIndex) {
                numbersMaxSequence = numbers;
                maxCount = count;
                maxCountSum = arraySum;
                maxCountInputNumber = inputCount;
                maxCountStartIndex = startIndex;
            } else if (arraySum > maxCountSum){
                numbersMaxSequence = numbers;
                maxCount = count;
                maxCountSum = arraySum;
                maxCountInputNumber = inputCount;
                maxCountStartIndex = startIndex;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n",maxCountInputNumber, maxCountSum);
        for (int i = 0; i < numbersMaxSequence.length; i++) {
            System.out.printf("%d ",numbersMaxSequence[i]);
        }
    }
}