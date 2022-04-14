import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder(input);
        for (int i = result.length()-1; i >= 0; i--) {
            if (result.charAt(i) == '>'){
                int explosionPower = Integer.parseInt(String.valueOf(result.charAt(i+1)));
                for (int j = i+1; j <= i+explosionPower ; j++) {
                    if (result.charAt(j) == '>'){
                        explosionPower++;
                    } else {
                        result.deleteCharAt(j);
                        j--;
                        explosionPower--;
                    }
                    if (j + 1 >= result.length()){
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
