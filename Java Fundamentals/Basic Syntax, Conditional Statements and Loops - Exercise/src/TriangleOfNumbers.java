import java.util.Scanner;

public class TriangleOfNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n ; i++) {
            String line = "";
            for (int j = 1; j <= i ; j++) {
                line +=  + i + " ";
            }
            System.out.println(line);
        }
    }
}
