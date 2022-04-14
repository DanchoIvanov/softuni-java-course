import java.util.Scanner;

public class PipesInPool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int v = Integer.parseInt(scanner.nextLine());
        int p1 = Integer.parseInt(scanner.nextLine());
        int p2 = Integer.parseInt(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());

        double p1Fill = p1*h;
        double p2Fill = p2*h;
        double fill = p1Fill+p2Fill;
        double overflow = fill-v;

        if(fill<=v){
            double fillPercentage = (fill/v)*100;
            double p1Contribution = (p1Fill/fill)*100;
            double p2Contribution = (p2Fill/fill)*100;
            System.out.printf("The pool is %.2f full. Pipe 1: %.2f%% Pipe 2: %.2f%%.",fillPercentage,p1Contribution,p2Contribution);
        }
        else
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.",h,overflow);


    }
}
