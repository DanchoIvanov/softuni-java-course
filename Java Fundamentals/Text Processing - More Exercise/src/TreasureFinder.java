import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] key = scanner.nextLine().split("\\s+");
        String input = scanner.nextLine();
        String treasureTypeRegex = "&(?<treasure>\\w*)&";
        String coordinatesRegex = "<(?<coordinates>\\w*)>";
        Pattern treasureTypePattern = Pattern.compile(treasureTypeRegex);
        Pattern coordinatesPatter = Pattern.compile(coordinatesRegex);
        while(!input.equals("find")){
            StringBuilder decryptedCode = new StringBuilder();
            int keyPosition = 0;
            for (char letter : input.toCharArray()){
                decryptedCode.append((char)(letter - Integer.parseInt(key[keyPosition])));
                keyPosition++;
                if (keyPosition >= key.length){
                    keyPosition = 0;
                }
            }
            Matcher treasureTypeMatcher = treasureTypePattern.matcher(decryptedCode);
            Matcher coordinatesMatcher = coordinatesPatter.matcher(decryptedCode);
            boolean found = treasureTypeMatcher.find();
            String treasureType = treasureTypeMatcher.group("treasure");
            boolean found1 = coordinatesMatcher.find();
            String coordinates = coordinatesMatcher.group("coordinates");
            System.out.printf("Found %s at %s%n",treasureType,coordinates);
            input = scanner.nextLine();
        }
    }
}
