import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int doctors = 7;
        int treatedPatientsSum = 0;
        int untreatedPatientsSum = 0;
        int treatedPatients = 0;
        int untreatedPatients = 0;

        for (int i = 1; i <= days ; i++) {
            int patients = Integer.parseInt(scanner.nextLine());
            if (i % 3 == 0 && untreatedPatientsSum > treatedPatientsSum){
                doctors++;
            }

            if (patients <= doctors){
                treatedPatients = patients;
                treatedPatientsSum += treatedPatients;
            }
            else if (patients > doctors) {
                untreatedPatients = patients - doctors;
                treatedPatients = doctors;
                untreatedPatientsSum += untreatedPatients;
                treatedPatientsSum += treatedPatients;
            }
        }
        System.out.printf("Treated patients: %d.%n",treatedPatientsSum);
        System.out.printf("Untreated patients: %d.",untreatedPatientsSum);
    }
}
