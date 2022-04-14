import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UnaryOperator<Double> addVat = e -> e * 1.2;

        double[] values = Arrays.stream(scanner.nextLine().split(", ")).mapToDouble(Double::parseDouble).toArray();
        System.out.println("Prices with VAT:");
        Arrays.stream(values).forEach(e -> System.out.printf("%.2f%n",addVat.apply(e)));
    }
}
