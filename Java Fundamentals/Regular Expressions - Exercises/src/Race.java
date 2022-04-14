import java.util.*;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] racers = scanner.nextLine().split(", ");
        Map <String, Integer> competition = new LinkedHashMap<>();
        for (String racer : racers){
            competition.putIfAbsent(racer, 0);
        }
        String input = scanner.nextLine();
        while (!input.equals("end of race")){
            StringBuilder racer = new StringBuilder();
            int distance = 0;
            for (char character : input.toCharArray()){
                if(Character.isLetter(character)){
                    racer.append(character);
                } else if (Character.isDigit(character)){
                    distance += Integer.parseInt(String.valueOf(character));
                }
            }
            if (competition.containsKey(racer.toString())){
                competition.put(racer.toString(), competition.get(racer.toString()) + distance);
            }
            input = scanner.nextLine();
        }
        List<String> winners = new ArrayList<>();
        competition.entrySet().stream()
                .sorted((e1, e2)-> e2.getValue().compareTo(e1.getValue()))
                .limit(3)
                .forEach(e-> winners.add(e.getKey()));
        System.out.println("1st place: " + winners.get(0));
        System.out.println("2nd place: " + winners.get(1));
        System.out.println("3rd place: " + winners.get(2));
    }
}
