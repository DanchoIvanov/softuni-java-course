import java.util.Scanner;

public class YardGreening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double squareArea = Double.parseDouble(scanner.nextLine());

        System.out.println("The final price is: " + (squareArea-(squareArea*0.18))*7.61+ " lv.");
        System.out.println("The discount is: " + (squareArea*0.18)*7.61 + " lv.");
        }
    }
