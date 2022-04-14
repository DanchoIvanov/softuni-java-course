import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, String> contests = new HashMap<>();
        while (!input.equals("end of contests")) {
            String contest = input.split(":")[0];
            String password = input.split(":")[1];
            contests.put(contest, password);
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        Map<String, TreeMap<String, Integer>> submissions = new TreeMap<>();
        while (!input.equals("end of submissions")) {
            String contest = input.split("=>")[0];
            String password = input.split("=>")[1];
            String username = input.split("=>")[2];
            int points = Integer.parseInt(input.split("=>")[3]);
            if (contests.containsKey(contest)) {
                if (contests.get(contest).equals(password)) {
                    submissions.putIfAbsent(username, new TreeMap<>());
                    submissions.get(username).putIfAbsent(contest, points);
                    if (submissions.get(username).get(contest) < points) {
                        submissions.get(username).put(contest, points);
                    }
                }
            }
            input = scanner.nextLine();
        }
        int maxPoints = 0;
        String bestCandidate = "";
        for (Map.Entry <String, TreeMap<String, Integer>> username : submissions.entrySet()){
            int currentPoints = 0;
            for (Map.Entry <String, Integer> entry : username.getValue().entrySet()){
                currentPoints += entry.getValue();
            }
            if (currentPoints > maxPoints){
                maxPoints = currentPoints;
                bestCandidate = username.getKey();
            }
        }
        System.out.printf("Best candidate is %s with total %d points.%n",bestCandidate,maxPoints);
        System.out.println("Ranking:");
        submissions.forEach((key, value) -> {
            System.out.println(key);
            value.entrySet().stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(user -> System.out.printf("#  %s -> %d%n", user.getKey(), user.getValue()));
        });
    }
}
