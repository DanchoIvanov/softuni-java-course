import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int biggestNum = Integer.MIN_VALUE;
        int middleNum = Integer.MIN_VALUE;
        int smallestNum = Integer.MIN_VALUE;

        for (int i = 1; i <=3 ; i++) {
            int inputNum = Integer.parseInt(scanner.nextLine());
            if (inputNum > biggestNum){
                smallestNum = middleNum;
                middleNum = biggestNum;
                biggestNum = inputNum;
            } else if (inputNum > middleNum) {
                smallestNum = middleNum;
                middleNum = inputNum;
            } else if (inputNum > smallestNum){
                smallestNum = inputNum;
            }
        }
        System.out.println(biggestNum);
        System.out.println(middleNum);
        System.out.println(smallestNum);
    }
}
