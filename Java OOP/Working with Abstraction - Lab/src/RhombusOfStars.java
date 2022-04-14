import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        printTopPart(n);
        printFoundation(n);
        printBottomPart(n);
    }

    private static void printBottomPart(int n) {
        for (int i = 1; i < n ; i++) {
            printLine(i,n-i);
        }
    }

    private static void printFoundation(int n) {
        StringBuilder sb = new StringBuilder();
        printLine(0,n);
    }

    private static void printTopPart(int n) {
        for (int i = 1; i < n ; i++) {
            printLine(n - i, i);
        }
    }

    private static void printLine (int spaces, int stars){
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j <spaces; j++) {
            sb.append(" ");
        }
        for (int j = 0; j < stars; j++) {
            sb.append("* ");
        }
        System.out.println(sb);
    }
}
