import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double grade = Double.parseDouble(scanner.nextLine());

        System.out.println(gradeInWords(grade));
    }


    public static String gradeInWords(double n) {
        if (n >= 2 && n < 3) {
            return "Fail";
        } else if (n < 3.5) {
            return "Poor";
        } else if (n < 4.5) {
            return "Good";
        } else if (n < 5.5) {
            return "Very good";
        } else if (n <= 6) {
            return "Excellent";
        }

        return null;
    }
}
