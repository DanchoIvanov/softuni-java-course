import java.util.Scanner;

public class Generating01Vectors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] vector = new int[n];

        generateVector(0,vector);
    }

    private static void generateVector(int index, int[] vector) {
        if (index >= vector.length){
            print(vector);
            return;
        }
        for (int i = 0; i <= 1; i++) {
            vector[index] = i;
            generateVector(index + 1, vector);
        }
    }

    private static void print(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i]);
        }
        System.out.println();
    }
}
