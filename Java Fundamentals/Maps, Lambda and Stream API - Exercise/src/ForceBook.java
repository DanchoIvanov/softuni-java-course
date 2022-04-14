import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map <String, List<String>> forceBook = new TreeMap<>();
        while(!input.equals("Lumpawaroo")){
            if (input.contains("|")) {
                String forceSide = input.split(" \\| ")[0];
                String forceUser = input.split(" \\| ")[1];
                forceBook.putIfAbsent(forceSide, new ArrayList<>());
                boolean userExists = false;
                for (Map.Entry<String, List<String>> side : forceBook.entrySet()) {
                    if (side.getValue().contains(forceUser)) {
                        userExists = true;
                        break;
                    }
                }
                if (!userExists) {
                    forceBook.get(forceSide).add(forceUser);
                }
            } else if (input.contains("->")){
                String forceSide = input.split(" -> ")[1];
                String forceUser = input.split(" -> ")[0];
                forceBook.putIfAbsent(forceSide, new ArrayList<>());
                forceBook.forEach((key, value) -> value.remove(forceUser));
                forceBook.get(forceSide).add(forceUser);
                System.out.printf("%s joins the %s side!%n",forceUser,forceSide);
            }


            input = scanner.nextLine();
        }
        forceBook.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(e ->{
                    if(!e.getValue().isEmpty()){
                        System.out.printf("Side: %s, Members: %d%n",e.getKey(),e.getValue().size());
                        e.getValue().stream()
                                .sorted(String::compareTo)
                                .forEach(user -> System.out.printf("! %s%n",user));
                    }
                });
    }
}
