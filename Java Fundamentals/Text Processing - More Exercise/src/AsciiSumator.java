import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char beginChar = scanner.nextLine().charAt(0);
        char endChar = scanner.nextLine().charAt(0);
        String input = scanner.nextLine();
        int sum =0;

        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i)>beginChar && input.charAt(i)<endChar){
                sum+=input.charAt(i);
            }
        }
        System.out.println(sum);
    }
}
