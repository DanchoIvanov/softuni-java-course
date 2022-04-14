import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] demons = scanner.nextLine().split("[, ]+");
        String healthRegex = "[^\\d+\\-*.\\/]";
        Pattern healthPattern = Pattern.compile(healthRegex);
        String dmgRegex = "-?\\d+\\.?\\d*";
        Pattern dmgPattern = Pattern.compile(dmgRegex);
        Map <String, List<Double>> demonBook = new TreeMap<>();
        for (String demon : demons){
            if (!demon.contains(" ") && !demon.contains(",")) {
                double health = 0;
                Matcher healthMatcher = healthPattern.matcher(demon);
                while (healthMatcher.find()) {
                    health += healthMatcher.group().charAt(0);
                }
                double damage = 0;
                Matcher dmgMatcher = dmgPattern.matcher(demon);
                while (dmgMatcher.find()) {
                    damage += Double.parseDouble(dmgMatcher.group());
                }
                if (damage != 0) {
                    for (char letter : demon.toCharArray()) {
                        if (letter == '/') {
                            damage = damage / 2;
                        } else if (letter == '*') {
                            damage = damage * 2;
                        }
                    }
                }
                demonBook.putIfAbsent(demon, new ArrayList<>());
                demonBook.get(demon).add(0, health);
                demonBook.get(demon).add(1, damage);
            }
        }
        demonBook.forEach((key, value)-> System.out.printf("%s - %.0f health, %.2f damage%n",key,value.get(0), value.get(1)));
    }
}
