import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int negativeCount = 0;

        for (int i = 1; i <=3 ; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            if (num < 0){
                negativeCount++;
            } else if (num == 0){
                System.out.println("zero");
                return;
            }
        }
        System.out.println(negativeCount%2==0? "positive" : "negative");
    }
}
