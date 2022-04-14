import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double p1x1 = Integer.parseInt(scanner.nextLine());
        double p1y1 = Integer.parseInt(scanner.nextLine());
        double p1x2 = Integer.parseInt(scanner.nextLine());
        double p1y2 = Integer.parseInt(scanner.nextLine());
        double p2x1 = Integer.parseInt(scanner.nextLine());
        double p2y1 = Integer.parseInt(scanner.nextLine());
        double p2x2 = Integer.parseInt(scanner.nextLine());
        double p2y2 = Integer.parseInt(scanner.nextLine());

        getLongerLineCoordinates(p1x1,p1y1,p1x2,p1y2,p2x1,p2y1,p2x2,p2y2);
    }

    public static void getClosestPoint(double x1, double y1, double x2, double y2){
        double firstPoint = Math.sqrt(Math.pow(x1,2)+Math.pow(y1,2));
        double secondPoint = Math.sqrt(Math.pow(x2,2)+Math.pow(y2,2));
        if(firstPoint >= secondPoint){
            System.out.printf("(%.0f, %.0f)(%.0f, %.0f)",x2,y2,x1,y1);
        } else {
            System.out.printf("(%.0f, %.0f)(%.0f, %.0f)",x1,y1,x2,y2);
        }
    }

    private static void getLongerLineCoordinates(double p1x1, double p1y1, double p1x2, double p1y2, double p2x1, double p2y1, double p2x2, double p2y2){
        if (getLineLength(p1x1,p1y1,p1x2,p1y2) >= getLineLength(p2x1,p2y1,p2x2,p2y2)){
            getClosestPoint(p1x1,p1y1,p1x2,p1y2);
        } else {
            getClosestPoint(p2x1,p2y1,p2x2,p2y2);
        }
    }

    private static double getLineLength(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2));
    }
}