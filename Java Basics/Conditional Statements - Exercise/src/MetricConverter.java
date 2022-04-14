import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double meters = Double.parseDouble(scanner.nextLine());
        String inputMetric = scanner.nextLine();
        String outputMetric = scanner.nextLine();

        if (inputMetric.equals("mm")){
            meters = meters/1000;
        }
        else if (inputMetric.equals("cm")){
            meters = meters/100;
        }

        double result = 0;

        if (outputMetric.equals("mm")){
           result=meters*1000;
        }
        else if (outputMetric.equals("cm")){
            result=meters*100;
        }
        else result = meters;

        System.out.printf("%.3f",result);
    }
}
