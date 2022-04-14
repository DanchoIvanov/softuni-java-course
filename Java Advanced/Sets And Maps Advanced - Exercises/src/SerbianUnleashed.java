import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputPattern = "(?<name>\\w+[ \\w]*) @(?<venue>\\w+[ \\w]*) (?<ticketCount>[0-9]+) (?<ticketPrice>[0-9]+)";
        Pattern pattern = Pattern.compile(inputPattern);
        Map<String, Map<String, Long>> concerts = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")){
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                String singer = matcher.group("name");
                String venue = matcher.group("venue");
                int ticketPrice = Integer.parseInt(matcher.group("ticketPrice"));
                int ticketCount = Integer.parseInt(matcher.group("ticketCount"));

                concerts.putIfAbsent(venue, new LinkedHashMap<>());
                concerts.get(venue).putIfAbsent(singer, 0L);
                concerts.get(venue).put(singer, concerts.get(venue).get(singer) + ((long) ticketCount * ticketPrice));
            }
            input = scanner.nextLine();
        }
        concerts.forEach((k,v) -> {
            System.out.println(k);
            v.entrySet().stream()
                    .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                    .forEach(e -> System.out.printf("#  %s -> %d%n",e.getKey(),e.getValue()));
        });
    }
}
