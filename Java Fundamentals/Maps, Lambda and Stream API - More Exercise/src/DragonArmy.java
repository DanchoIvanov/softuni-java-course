import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, TreeMap<String, List<Integer>>> dragonTypes = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String type = input.split(" ")[0];
            String name = input.split(" ")[1];
            String dmg = input.split(" ")[2];
            int damage = 0;
            if (dmg.equals("null")){
                damage = 45;
            } else {
                damage = Integer.parseInt(dmg);
            }
            String life = input.split(" ")[3];
            int health = 0;
            if (life.equals("null")){
                health = 250;
            } else {
                health = Integer.parseInt(life);
            }
            String shield = input.split(" ")[4];
            int armor = 0;
            if (shield.equals("null")) {
                armor = 10;
            } else {
                armor = Integer.parseInt(shield);
            }
            dragonTypes.putIfAbsent(type, new TreeMap<>());
            dragonTypes.get(type).putIfAbsent(name, new ArrayList<>());
            dragonTypes.get(type).get(name).add(0, damage);
            dragonTypes.get(type).get(name).add(1, health);
            dragonTypes.get(type).get(name).add(2, armor);
        }
        dragonTypes.entrySet().stream().forEach(e ->{
            int totalDamage = 0;
            for (Map.Entry<String, List<Integer>> dragon : e.getValue().entrySet()){
                totalDamage += dragon.getValue().get(0);
            }
            double averageDamage = totalDamage*1.0/e.getValue().size();
            int totalHealth = 0;
            for (Map.Entry<String, List<Integer>> dragon : e.getValue().entrySet()){
                totalHealth += dragon.getValue().get(1);
            }
            double averageHealth = totalHealth*1.0/e.getValue().size();
            int totalArmor = 0;
            for (Map.Entry<String, List<Integer>> dragon : e.getValue().entrySet()){
                totalArmor += dragon.getValue().get(2);
            }
            double averageArmor = totalArmor*1.0/e.getValue().size();
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n",e.getKey(),averageDamage,averageHealth,averageArmor);
            e.getValue().entrySet().stream().forEach(dragon -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",dragon.getKey(),dragon.getValue().get(0),dragon.getValue().get(1),dragon.getValue().get(2)));
        });
    }
}
