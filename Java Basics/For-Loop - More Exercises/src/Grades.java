import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());
        double gradesSum = 0;
        int excellentGradeCount = 0;
        int goodGradeCount = 0;
        int mediocreGradeCount = 0;
        int poorGradeCount = 0;

        for (int i = 1; i <=students ; i++) {
            double grade = Double.parseDouble(scanner.nextLine());
            if (grade >= 5.00){
                gradesSum += grade;
                excellentGradeCount++;
            }
            else if (grade >= 4.00){
                gradesSum += grade;
                goodGradeCount++;
            }
            else if (grade >= 3.00){
                gradesSum += grade;
                mediocreGradeCount++;
            }
            else{
                gradesSum += grade;
                poorGradeCount++;
            }
        }
        double averageGrade = gradesSum / students;
        double excellentGradePercentage = (excellentGradeCount * 1.0 / students) * 100;
        double goodGradePercentage = (goodGradeCount * 1.0 / students)*100;
        double mediocreGradePercentage = (mediocreGradeCount * 1.0 / students)*100;
        double poorGradePercentage = (poorGradeCount * 1.0 / students)*100;

        System.out.printf("Top students: %.2f%%%n",excellentGradePercentage);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", goodGradePercentage);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n",mediocreGradePercentage);
        System.out.printf("Fail: %.2f%%%n", poorGradePercentage);
        System.out.printf("Average: %.2f",averageGrade);
    }
}
