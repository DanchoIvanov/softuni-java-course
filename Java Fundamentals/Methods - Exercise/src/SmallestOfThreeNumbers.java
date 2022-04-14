import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        System.out.println(getSmallestNumber(a,b,c));
    }

    public static int getSmallestNumber (int a, int b, int c){
        if (a <= b && a <= c){
            return a;
        } else if (b <= a && b <= c){
            return  b;
        } else {
            return c;
        }
    }
}
