import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dataType = scanner.nextLine();
        switch (dataType){
            case "int":
                int n = Integer.parseInt(scanner.nextLine());
                multiply(n);
                break;
            case "real":
                double num = Double.parseDouble(scanner.nextLine());
                multiply(num);
                break;
            case "string":
                String input = scanner.nextLine();
                surroundWithDollarSigns(input);
                break;
        }
    }

    public static void multiply (int n){
        System.out.println(n*2);
    }

    public static void multiply (double n){
        System.out.printf("%.2f",n*1.5);
    }

    public static void surroundWithDollarSigns (String input){
        System.out.println("$"+input+"$");
    }
}