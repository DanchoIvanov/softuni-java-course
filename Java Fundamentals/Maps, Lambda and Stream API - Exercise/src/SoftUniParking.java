import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> registeredUsers = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String command = input.split("\\s+")[0];
            String userName = input.split("\\s+")[1];
            switch (command){
                case "register":
                    String licensePlate = input.split("\\s+")[2];
                    if (registeredUsers.containsKey(userName)){
                        System.out.printf("ERROR: already registered with plate number %s%n",licensePlate);
                    } else {
                        registeredUsers.put(userName, licensePlate);
                        System.out.printf("%s registered %s successfully%n",userName, licensePlate);
                    }
                    break;
                case "unregister":
                    if (registeredUsers.containsKey(userName)){
                        registeredUsers.remove(userName);
                        System.out.printf("%s unregistered successfully%n",userName);
                    } else {
                        System.out.printf("ERROR: user %s not found%n",userName);
                    }
                    break;
            }
        }
        for (Map.Entry <String, String> entry : registeredUsers.entrySet()){
            System.out.printf("%s => %s%n",entry.getKey(), entry.getValue());
        }
    }
}
