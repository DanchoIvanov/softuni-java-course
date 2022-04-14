import java.util.Scanner;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lists = scanner.nextLine().split("\\|");

        for (int i = lists.length-1; i >= 0; i--) {
            String elements = lists[i].trim();
            if (elements.equals("") || elements.equals(" ")){
                continue;
            }
            String[] numbers = elements.split("\\s+");
            for (String number:numbers){
                System.out.printf("%s ",number);
            }
        }
    }
}
