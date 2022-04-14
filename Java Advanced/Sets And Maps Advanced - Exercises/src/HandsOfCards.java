import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map <String, Set<String>> playersHands = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("JOKER")){
            String playerName = input.split(": ")[0];
            String[] hand = input.split(": ")[1].split(", ");
            playersHands.putIfAbsent(playerName, new HashSet<>());
            for (String card : hand){
                playersHands.get(playerName).add(card);
            }
            input = scanner.nextLine();
        }
        playersHands.forEach((k,v)-> System.out.printf("%s: %d%n",k,getHandPower(v)));

    }

    private static int getHandPower(Set<String> v) {
        int handPower = 0;
        String cardPowerPattern = "[\\d]+";
        Pattern pattern = Pattern.compile(cardPowerPattern);
        for (String card : v){
            Matcher matcher = pattern.matcher(card);
            int cardPower = 0;
            if (matcher.find()){
                cardPower = Integer.parseInt(matcher.group());
            } else {
                if (card.startsWith("J")){
                    cardPower = 11;
                } else if (card.startsWith("Q")){
                    cardPower = 12;
                } else if (card.startsWith("K")){
                    cardPower = 13;
                } else if (card.startsWith("A")){
                    cardPower = 14;
                }
            }
            int typeMultiplier = 0;
            if (card.endsWith("S")){
                typeMultiplier= 4;
            } else if (card.endsWith("H")){
                typeMultiplier= 3;
            } else if (card.endsWith("D")){
                typeMultiplier= 2;
            } else if (card.endsWith("C")){
                typeMultiplier= 1;
            }

            handPower += cardPower * typeMultiplier;
        }
        return handPower;
    }
}
