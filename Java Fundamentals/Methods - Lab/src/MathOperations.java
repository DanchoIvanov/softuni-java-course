import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double a = Double.parseDouble(scanner.nextLine());
        String command = scanner.nextLine();
        double b = Double.parseDouble(scanner.nextLine());

        switch (command){
            case "+":
                System.out.println(new DecimalFormat("0.##").format(add(a,b)));
                break;
            case "/":
                System.out.println(new DecimalFormat("0.##").format(divide(a,b)));
                break;
            case "-":
                System.out.println(new DecimalFormat("0.##").format(subtract(a,b)));
                break;
            case "*":
                System.out.println(new DecimalFormat("0.##").format(multiply(a,b)));
        }

    }

    public static double add(double a, double b){
        return a+b;
    }
    public static double divide(double a, double b){
        return a*1.0/b;
    }

    public static double subtract (double a, double b){
        return  a-b;
    }

    public static double multiply (double a, double b){
        return a*b;
    }
}


