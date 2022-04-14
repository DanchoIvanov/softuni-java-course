import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int judges = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        double gradeSum = 0;
        double gradeAvg = 0;
        double totalGrade =0;
        int presentationCount = 0;

        while (!input.equals("Finish")){
            String presentationName = input;
            gradeSum = 0;
            gradeAvg = 0;
            presentationCount++;
            for (int i = 1; i <= judges ; i++) {
                double grade = Double.parseDouble(scanner.nextLine());
                gradeSum += grade;
                totalGrade += grade;
            }
            gradeAvg = gradeSum / judges;
            System.out.printf("%s - %.2f.%n",presentationName,gradeAvg);
            input = scanner.nextLine();
        }
        double totalGradeAvg = totalGrade / (judges * presentationCount);
        System.out.printf("Student's final assessment is %.2f.", totalGradeAvg);
    }
}
