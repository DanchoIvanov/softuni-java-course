import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Integer> legendaryMaterials = new HashMap<>();
        Map<String, Integer> junkMaterials = new TreeMap<>();
        legendaryMaterials.put("shards",0);
        legendaryMaterials.put("fragments",0);
        legendaryMaterials.put("motes",0);
        boolean shardsCollected = false;
        boolean fragmentsCollected = false;
        boolean motesCollected = false;
        String legendaryItem = "";
        while (!shardsCollected && !fragmentsCollected && !motesCollected) {
            String input = scanner.nextLine();
            String[] rewards = input.split("\\s+");
            for (int i = 0; i < rewards.length / 2; i++) {
                String item = rewards[i * 2 + 1].toLowerCase();
                int quantity = Integer.parseInt(rewards[i * 2]);
                if (legendaryMaterials.containsKey(item)) {
                    legendaryMaterials.put(item, legendaryMaterials.get(item) + quantity);
                } else {
                    if (!junkMaterials.containsKey(item)) {
                        junkMaterials.put(item, quantity);
                    } else {
                        junkMaterials.put(item, junkMaterials.get(item) + quantity);
                    }
                }
                int shards = legendaryMaterials.get("shards");
                int fragments = legendaryMaterials.get("fragments");
                int motes = legendaryMaterials.get("motes");
                if (shards >= 250){
                    shardsCollected = true;
                    legendaryMaterials.put("shards",legendaryMaterials.get("shards") - 250);
                    legendaryItem = "Shadowmourne";
                    break;
                } else if (fragments >= 250){
                    fragmentsCollected = true;
                    legendaryMaterials.put("fragments",legendaryMaterials.get("fragments") - 250);
                    legendaryItem = "Valanyr";
                    break;
                } else if (motes >= 250){
                    motesCollected = true;
                    legendaryMaterials.put("motes",legendaryMaterials.get("motes") - 250);
                    legendaryItem = "Dragonwrath";
                    break;
                }
            }
        }
        System.out.printf("%s obtained!%n",legendaryItem);

        legendaryMaterials.entrySet().stream().sorted((e1, e2) -> {
            int diff = e2.getValue().compareTo(e1.getValue());
            if (diff == 0) {
                diff = e1.getKey().compareTo(e2.getKey());
            }
            return diff;}).forEach(e -> System.out.printf("%s: %d%n", e.getKey(), Math.round(e.getValue())));

        for (Map.Entry <String, Integer> entry : junkMaterials.entrySet()){
            System.out.printf("%s: %d%n",entry.getKey(), entry.getValue());
        }
    }
}
