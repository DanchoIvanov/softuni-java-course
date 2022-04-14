import java.util.Scanner;

public class GraduationPt2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int lowGrade = 0;
        double totalGrades = 0;

        for (int i = 1; i <= 12 ; i++) {
            double grade = Double.parseDouble(scanner.nextLine());
            totalGrades += grade;
            if (grade < 4){
                lowGrade++;
            }
            if (lowGrade == 2){
                System.out.printf("%s has been excluded at %d grade", name, i-1);
                break;
            }
        }
        if (lowGrade < 2){
            System.out.printf("%s graduated. Average grade: %.2f",name, totalGrades/12);
        }
    }
}
