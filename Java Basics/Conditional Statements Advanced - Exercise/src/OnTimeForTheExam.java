import java.util.Scanner;

public class OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int examHour = Integer.parseInt(scanner.nextLine());
        int examMinutes = Integer.parseInt(scanner.nextLine());
        int arrivalHours = Integer.parseInt(scanner.nextLine());
        int arrivalMinutes = Integer.parseInt(scanner.nextLine());

        int arrivalTime = arrivalHours * 60 + arrivalMinutes;
        int examTime = examHour * 60 + examMinutes;

        int difference = Math.abs(arrivalTime-examTime);
        int differenceHours = difference/60;
        int differenceMinutes = difference%60;

        if (arrivalTime-examTime >= 60) {
                System.out.printf("Late%n%d:%02d hours after the start", differenceHours, differenceMinutes);
        }
        else if (arrivalTime-examTime >0){
            System.out.printf("Late%n%d minutes after the start",differenceMinutes);
        }
        else if (examTime-arrivalTime >= 60) {
                System.out.printf("Early%n%d:%02d hours before the start", differenceHours, differenceMinutes);
            }

        else if (examTime-arrivalTime > 30){
            System.out.printf("Early%n%d minutes before the start",differenceMinutes);
        }
        else
            System.out.printf("On time%n%d minutes before the start",differenceMinutes);
        }
    }


