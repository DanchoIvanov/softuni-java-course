package generic_array_creator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] arr = ArrayCreator.create(6, 6);
        System.out.println(arr);

    }
}
