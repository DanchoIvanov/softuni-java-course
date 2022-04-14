import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double width = Double.parseDouble(scanner.nextLine());
        double length = Double.parseDouble(scanner.nextLine());

        System.out.printf("%.0f",getRectangeleArea(width,length));
    }

    public static double getRectangeleArea(double width, double length){
        return  width*length;
    }
}
