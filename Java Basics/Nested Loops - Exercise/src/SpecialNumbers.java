import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        boolean isSpecial = true;

        for (int i = 1111; i <= 9999 ; i++) {
            isSpecial =true;
            int value = i;
            for (int j = 1; j <=4 ; j++) {
                int moduleValue = value % 10;
                value = value / 10;
                if(moduleValue == 0){
                    isSpecial = false;
                    break;
                }
                if (n % moduleValue != 0){
                    isSpecial = false;
                    break;
                }
            }
            if (isSpecial){
                System.out.printf("%d ",i);
            }
        }
    }
}
