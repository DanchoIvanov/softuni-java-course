import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int times = Integer.parseInt(scanner.nextLine());
        int result = num * times;

        System.out.printf("%d X %d = %d%n",num, times, result);

        for (int i = times +1 ; i <= 10 ; i++) {
            result = i * num;
            System.out.printf("%d X %d = %d%n",num, i, result);
        }
    }
}
