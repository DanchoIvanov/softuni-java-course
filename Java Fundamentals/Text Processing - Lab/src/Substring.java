import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String toRemove = scanner.nextLine();
        String removeFrom = scanner.nextLine();

        while (removeFrom.contains(toRemove)){
            removeFrom = removeFrom.replace(toRemove, "");
        }
        System.out.println(removeFrom);
    }
}
