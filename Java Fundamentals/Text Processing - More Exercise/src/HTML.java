import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String title = scanner.nextLine();
        String article = scanner.nextLine();
        String input = scanner.nextLine();
        System.out.printf("<h1>%n   %s%n</h1>%n", title);
        System.out.printf("<article>%n   %s%n</article>%n", article);
        while (!input.equals("end of comments")) {
            System.out.printf("<div>%n   %s%n</div>%n", input);
            input = scanner.nextLine();
        }
    }
}
