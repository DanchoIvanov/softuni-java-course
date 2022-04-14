import java.util.Scanner;

public class Scholarship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double salary = Double.parseDouble(scanner.nextLine());
        double grade = Double.parseDouble(scanner.nextLine());
        double minimalWage = Double.parseDouble(scanner.nextLine());

        double socialScholarship = 0;
        double excellentResultScholarship = 0;

        if (grade > 4.5 && salary < minimalWage)
            socialScholarship =  0.35 * minimalWage;

        if (grade >= 5.5) {
            excellentResultScholarship = grade * 25;
        }

        if (socialScholarship <= excellentResultScholarship && grade >= 5.5) {
            System.out.printf("You get a scholarship for excellent results %.0f BGN",Math.floor(excellentResultScholarship));
        }
        else if (grade > 4.5 && salary < minimalWage){
            System.out.printf("You get a Social scholarship %.0f BGN",Math.floor(socialScholarship));
        }
        else System.out.println("You cannot get a scholarship!");
    }
}
