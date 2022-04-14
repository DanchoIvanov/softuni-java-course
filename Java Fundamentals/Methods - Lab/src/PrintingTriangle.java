import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        printTopOfPyramid(n);
        printBottomOfPyramid(n);
    }

    public static void printTopOfPyramid(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d ",j);
            }
            System.out.println();
        }
    }

    public static void  printBottomOfPyramid(int n){
        for (int i = n - 1; i >= 1 ; i--) {
            for (int j = 1; j <= i ; j++) {
                System.out.printf("%d ",j);
            }
            System.out.println();
        }
    }
}
