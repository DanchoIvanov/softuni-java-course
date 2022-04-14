import java.util.Scanner;

public class VowelsSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int vowelsSum = 0;

        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            if (letter == 'a'){
                vowelsSum = vowelsSum+1;
            }
            else if (letter == 'e'){
                vowelsSum = vowelsSum +2;
            }
            else if (letter == 'i'){
                vowelsSum = vowelsSum +3;
            }
            else if (letter == 'o'){
                vowelsSum = vowelsSum + 4;
            }
            else if (letter == 'u'){
                vowelsSum = vowelsSum +5;
            }
        }
        System.out.println(vowelsSum);
    }
}
