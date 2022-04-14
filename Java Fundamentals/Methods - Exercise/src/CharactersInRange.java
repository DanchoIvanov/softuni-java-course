import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);
        printCharsInBetween(firstChar,secondChar);
    }

    public static void printCharsInBetween(char firstChar, char secondChar){
        char smallerChar = firstChar;
        char biggerChar = secondChar;

        if (firstChar >= secondChar) {
            biggerChar = firstChar;
            smallerChar = secondChar;
        }
        for (int i = smallerChar+1; i < biggerChar; i++) {
            System.out.printf("%c ",i);
        }
    }
}
