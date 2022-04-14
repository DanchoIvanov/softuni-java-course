import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map <String, Set<String>> usersIP = new TreeMap<>();
        Map <String, Long> usersDuration  = new HashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String ipAddress = input.split("\\s+")[0];
            String user = input.split("\\s+")[1];
            int duration = Integer.parseInt(input.split("\\s+")[2]);

            usersIP.putIfAbsent(user, new TreeSet<>());
            usersIP.get(user).add(ipAddress);
            usersDuration.putIfAbsent(user, 0L);
            usersDuration.put(user, usersDuration.get(user) + duration);
        }
        usersDuration.forEach((u, d)-> System.out.printf("%s: %d %s%n",u,d,usersIP.get(u)));
    }
}
