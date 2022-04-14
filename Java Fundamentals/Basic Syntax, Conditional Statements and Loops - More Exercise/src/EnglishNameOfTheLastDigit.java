import java.util.Scanner;

public class EnglishNameOfTheLastDigit {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        if (num%10 == 0){
            System.out.println("zero");
        } else if (num%10 == 1) {
            System.out.println("one");
        } else if (num%10 == 2) {
            System.out.println("two");
        } else if (num%10 == 3) {
            System.out.println("three");
        } else if (num%10 == 4) {
            System.out.println("four");
        } else if (num%10 == 5) {
            System.out.println("five");
        } else if (num%10 == 6) {
            System.out.println("six");
        } else if (num%10 == 7) {
            System.out.println("seven");
        } else if (num%10 == 8) {
            System.out.println("eight");
        } else if (num%10 == 9) {
            System.out.println("nine");
        }
    }
}
