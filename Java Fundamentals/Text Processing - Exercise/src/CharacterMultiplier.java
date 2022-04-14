import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String string1 = input.split(" ")[0];
        String string2 = input.split(" ")[1];
        multiplyCharacters(string1, string2);
    }

    private static void multiplyCharacters (String string1, String string2){
        String shortString = string2;
        String longString = string1;
        if (string1.length()<= string2.length()){
            shortString = string1;
            longString = string2;
        }

        int result = 0;
        for (int i = 0; i < shortString.length(); i++) {
            result += shortString.charAt(i)*longString.charAt(i);
        }
        for (int i = shortString.length(); i <longString.length() ; i++) {
            result+= longString.charAt(i);
        }
        System.out.println(result);
    }
}
