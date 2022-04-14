import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String firstPart = input.split("\\|")[0];
        String secondPart = input.split("\\|")[1];
        String thirdPart = input.split("\\|")[2];
        String capitalLettersRegex = "([#$%*&])(?<letters>[A-Z]+)\\1";
        Pattern capitalLettersPattern = Pattern.compile(capitalLettersRegex);
        Matcher capitalLettersMatcher = capitalLettersPattern.matcher(firstPart);
        if (capitalLettersMatcher.find()){
            String capitalLetters = capitalLettersMatcher.group("letters");
            for (char letter : capitalLetters.toCharArray()){
                String regex = (int) letter + ":(?<length>\\d{2})\\D";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(secondPart);
                if (matcher.find()){
                    int length = Integer.parseInt(matcher.group("length"));
                    if (length >=1 && length<=20) {
                        String regexWord = "(?>^|\\s+)(?<name>" + letter + "[\\S]{" + length + "}\\b)";
                        Pattern patternWord = Pattern.compile(regexWord);
                        Matcher matcherWord = patternWord.matcher(thirdPart);
                        if (matcherWord.find()) {
                            System.out.println(matcherWord.group("name"));
                        }
                    }
                }
            }
        }
    }
}
