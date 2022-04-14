import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\\\");
        String name = input[input.length-1].split("\\.")[0];
        String extension = input[input.length-1].split("\\.")[1];
        System.out.printf("File name: %s%nFile extension: %s%n",name,extension);
    }
}
