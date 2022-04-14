import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, TreeMap<String, Integer>> playerPool = new HashMap<>();
        while (!input.equals("Season end")){
            if(input.contains("->")) {
                String player = input.split(" -> ")[0];
                String position = input.split(" -> ")[1];
                int skill = Integer.parseInt(input.split(" -> ")[2]);
                playerPool.putIfAbsent(player, new TreeMap<>());
                playerPool.get(player).putIfAbsent(position, skill);
                if (playerPool.get(player).get(position) < skill){
                    playerPool.get(player).put(position, skill);
                }
            } else if(input.contains(" vs ")){
                String player1 = input.split(" vs ")[0];
                String player2 = input.split(" vs ")[1];
                if (playerPool.containsKey(player1) && playerPool.containsKey(player2)){
                    boolean sharePosition = false;
                    for (Map.Entry <String, Integer> position : playerPool.get(player1).entrySet()){
                        if(playerPool.get(player2).containsKey(position.getKey())){
                            sharePosition = true;
                            break;
                        }
                    }
                    if (sharePosition){
                        int player1Skill = playerPool.get(player1).values().stream().mapToInt(i -> i).sum();
                        int player2Skill = playerPool.get(player2).values().stream().mapToInt(i -> i).sum();
                        if (player1Skill > player2Skill) {
                            playerPool.remove(player2);
                        } else if (player2Skill > player1Skill){
                            playerPool.remove(player1);
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        Map <String, Integer> playersSkill = new HashMap<>();
        for (Map.Entry<String, TreeMap<String, Integer>> entry : playerPool.entrySet()){
            int playerSkill = 0;
            for (Map.Entry <String, Integer> position : entry.getValue().entrySet()){
                playerSkill += position.getValue();
            }
            playersSkill.put(entry.getKey(), playerSkill);
        }
        playersSkill.entrySet().stream()
                .sorted((e1,e2)-> e2.getValue().compareTo(e1.getValue()))
                .forEach(e->{
                    System.out.printf("%s: %d skill%n",e.getKey(), e.getValue());
                    playerPool.get(e.getKey()).entrySet()
                            .stream().sorted((pos1, pos2) -> pos2.getValue().compareTo(pos1.getValue()))
                            .forEach(position -> System.out.printf("- %s <::> %d%n",position.getKey(),position.getValue()));
                });
    }
}
