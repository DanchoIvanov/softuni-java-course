import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        BigInteger result = new BigInteger("1");
        while (n > 1) {
            result = result.multiply(new BigInteger(String.valueOf(n)));
            n--;
        }
        System.out.println(result);
    }
}
