import java.util.Scanner;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        String currentChar = "";
        StringBuilder result = new StringBuilder();
        for (String segment : input){
            switch (segment){
                case ".-":
                    currentChar = "A";
                    break;
                case "-...":
                    currentChar = "B";
                    break;
                case "-.-.":
                    currentChar = "C";
                    break;
                case "-..":
                    currentChar = "D";
                    break;
                case ".":
                    currentChar = "E";
                    break;
                case "..-.":
                    currentChar = "F";
                    break;
                case "--.":
                    currentChar = "G";
                    break;
                case "....":
                    currentChar = "H";
                    break;
                case "..":
                    currentChar = "I";
                    break;
                case ".---":
                    currentChar = "J";
                    break;
                case "-.-":
                    currentChar = "K";
                    break;
                case ".-..":
                    currentChar = "L";
                    break;
                case "--":
                    currentChar = "M";
                    break;
                case "-.":
                    currentChar = "N";
                    break;
                case "---":
                    currentChar = "O";
                    break;
                case ".--.":
                    currentChar = "P";
                    break;
                case "--.-":
                    currentChar = "Q";
                    break;
                case ".-.":
                    currentChar = "R";
                    break;
                case "...":
                    currentChar = "S";
                    break;
                case "-":
                    currentChar = "T";
                    break;
                case "..-":
                    currentChar = "U";
                    break;
                case "...-":
                    currentChar = "V";
                    break;
                case ".--":
                    currentChar = "W";
                    break;
                case "-..-":
                    currentChar = "X";
                    break;
                case "-.--":
                    currentChar = "Y";
                    break;
                case "--..":
                    currentChar = "Z";
                    break;
                case "|":
                    currentChar = " ";
                    break;
            }
            result.append(currentChar);
        }
        System.out.println(result);
    }
}
