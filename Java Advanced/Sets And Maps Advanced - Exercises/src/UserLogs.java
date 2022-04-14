import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map <String, Map<String, Integer>> logs = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("end")){
            String ipAddress = input.split("\\s+")[0].replace("IP=","");
            String username = input.split("\\s+")[2].replace("user=","");

            logs.putIfAbsent(username, new LinkedHashMap<>());
            logs.get(username).putIfAbsent(ipAddress, 0);
            logs.get(username).put(ipAddress, logs.get(username).get(ipAddress) + 1);

            input = scanner.nextLine();
        }

        logs.forEach((k,v) -> {
            System.out.printf("%s: %n",k);
            List<String> ipAddresses = new LinkedList<>();
            v.forEach((ip, count) -> ipAddresses.add(String.format("%s => %d",ip, count)));
            System.out.println(String.join(", ", ipAddresses) + ".");
        });
    }
}
