import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> plantsRarity = new HashMap<>();
        Map<String, List<Integer>> plantsRating = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String plant = input.split("<->")[0];
            int rarity = Integer.parseInt(input.split("<->")[1]);
            plantsRarity.put(plant, rarity);
            plantsRating.put(plant, new ArrayList<>());
        }
        String input = scanner.nextLine();
        while (!input.equals("Exhibition")){
            String[] command = input.split("(: | - )");
            String action = command[0];
            String plant = command[1];
            if (plantsRarity.containsKey(plant)){
                switch (action){
                    case "Rate":
                        int rating = Integer.parseInt(command[2]);
                        plantsRating.put(plant, plantsRating.get(plant)).add(rating);
                        break;
                    case "Update":
                        int rarity = Integer.parseInt(command[2]);
                        plantsRarity.put(plant, rarity);
                        break;
                    case "Reset":
                        if (plantsRating.containsKey(plant)) {
                            plantsRating.put(plant, new ArrayList<>());
                        } else {
                            System.out.println("error");
                        }
                        break;
                    default:
                        System.out.println("error");
                }
            } else {
                System.out.println("error");
            }
            input = scanner.nextLine();
        }
        Map<String, Double> plantsAverageRating = new HashMap<>();
        for (Map.Entry <String, List<Integer>> entry : plantsRating.entrySet()){
            double averageRating = 0;
            for (int rating : entry.getValue()){
                averageRating += rating;
            }
            if (entry.getValue().size() > 0) {
                averageRating = averageRating / entry.getValue().size();
            }
            plantsAverageRating.put(entry.getKey(), averageRating);
        }
        System.out.println("Plants for the exhibition:");
        plantsRarity.entrySet().stream()
                .sorted((e2,e1)->{
                    int diff = e1.getValue().compareTo(e2.getValue());
                    if (diff == 0){
                        diff = plantsAverageRating.get(e1.getKey()).compareTo(plantsAverageRating.get(e2.getKey()));
                    }
                    return diff;
                })
                .forEach(e -> {
                    double averageRating =  plantsAverageRating.get(e.getKey());
                    System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",e.getKey(),e.getValue(),averageRating);
                });
    }
}
