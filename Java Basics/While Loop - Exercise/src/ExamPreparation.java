import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lowGrades = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int lowGradesCount = 0;
        int problemsCount = 0;
        String problemName = "";
        int gradeSum =0;

        while (!input.equals("Enough")){
            problemName = input;
            int grade = Integer.parseInt(scanner.nextLine());
            problemsCount++;
            gradeSum += grade;

            if (grade <= 4){
                lowGradesCount++;
            }
            if (lowGrades == lowGradesCount){
                System.out.printf("You need a break, %d poor grades.", lowGradesCount);
                break;
            }
            input = scanner.nextLine();
        }
        double averageGrade = (gradeSum*1.0)/problemsCount;
        if (lowGradesCount < lowGrades) {
            System.out.printf("Average score: %.2f%n", averageGrade);
            System.out.printf("Number of problems: %d%n", problemsCount);
            System.out.printf("Last problem: %s%n", problemName);
        }
    }
}
