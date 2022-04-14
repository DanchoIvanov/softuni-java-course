package greedy_times;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] vault = scanner.nextLine().split("\\s+");

        Map<String, LinkedHashMap<String, Long>> bag = new LinkedHashMap<>();
        long gold = 0;
        long gems = 0;
        long cash = 0;

        for (int i = 0; i < vault.length; i += 2) {
            String name = vault[i];
            long lootCount = Long.parseLong(vault[i + 1]);

            String kvoE = "";

            if (name.length() == 3) {
                kvoE = "Cash";
            } else if (name.toLowerCase().endsWith("gem")) {
                kvoE = "Gem";
            } else if (name.equalsIgnoreCase("gold")) {
                kvoE = "Gold";
            }

            if (kvoE.equals("")) {
                continue;
            } else if (bagCapacity < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + lootCount) {
                continue;
            }

            switch (kvoE) {
                case "Gem":
                    if (!bag.containsKey(kvoE)) {
                        if (bag.containsKey("Gold")) {
                            if (lootCount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(kvoE).values().stream().mapToLong(e -> e).sum() + lootCount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(kvoE)) {
                        if (bag.containsKey("Gem")) {
                            if (lootCount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(kvoE).values().stream().mapToLong(e -> e).sum() + lootCount > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!bag.containsKey(kvoE)) {
                bag.put((kvoE), new LinkedHashMap<>());
            }

            if (!bag.get(kvoE).containsKey(name)) {
                bag.get(kvoE).put(name, 0L);
            }


            bag.get(kvoE).put(name, bag.get(kvoE).get(name) + lootCount);
            if (kvoE.equals("Gold")) {
                gold += lootCount;
            } else if (kvoE.equals("Gem")) {
                gems += lootCount;
            } else if (kvoE.equals("Cash")) {
                cash += lootCount;
            }
        }

        for (var x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.printf("<%s> $%s%n", x.getKey(), sumValues);

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }
}