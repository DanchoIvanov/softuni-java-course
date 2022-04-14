import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] arr = new int[1];
        arr[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int element:arr) {
                System.out.printf("%d ",element);
            }
            System.out.println();
            int[] arr2 = new int[i+1];
            for (int j = 0; j < arr2.length; j++) {
               if (j==0){
                   arr2[j] = 1;
               } else if (j==arr2.length-1){
                   arr2[j] = 1;
               } else {
                   arr2[j] = arr[j] + arr[j-1];
               }
            }
            arr = arr2;
        }
    }
}
