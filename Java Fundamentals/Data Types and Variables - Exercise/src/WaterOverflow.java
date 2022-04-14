import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int pouredWater = Integer.parseInt(scanner.nextLine());
            if (sum + pouredWater > 255){
                System.out.println("Insufficient capacity!");
            } else {
                sum += pouredWater;
            }
        }
        System.out.println(sum);
    }
}
