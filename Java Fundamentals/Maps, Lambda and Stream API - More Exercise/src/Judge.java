import java.util.*;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map <String, Map<String, Integer>> submissions = new LinkedHashMap<>();
        while(!input.equals("no more time")){
            String username = input.split(" -> ")[0];
            String contest = input.split(" -> ")[1];
            int points = Integer.parseInt(input.split(" -> ")[2]);
            submissions.putIfAbsent(contest, new TreeMap<>());
            submissions.get(contest).putIfAbsent(username, points);
            if(submissions.get(contest).get(username) < points){
                submissions.get(contest).put(username, points);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry <String, Map<String, Integer>> contest : submissions.entrySet()){
            System.out.printf("%s: %d participants%n",contest.getKey(), contest.getValue().size());
            var ref = new Object() {
                int n = 0;
            };
            contest.getValue().entrySet().stream()
                    .sorted((e1,e2)-> e2.getValue().compareTo(e1.getValue()))
                    .forEach(e-> {
                        ref.n++;
                        System.out.printf("%d. %s <::> %d%n",ref.n,e.getKey(),e.getValue());

                    });
        }
        System.out.println("Individual standings:");
        Map <String, Integer> individualStatistics = new TreeMap<>();
        submissions.forEach((key, value) -> {
            for (Map.Entry<String, Integer> user : value.entrySet()) {
                individualStatistics.putIfAbsent(user.getKey(), 0);
                individualStatistics.put(user.getKey(), user.getValue() + individualStatistics.get(user.getKey()));
            }
        });
        var ref = new Object() {
            int n = 0;
        };
        individualStatistics.entrySet().stream()
                .sorted((e1,e2)->e2.getValue().compareTo(e1.getValue()))
                .forEach(e-> {
                    ref.n++;
                    System.out.printf("%d. %s -> %d%n", ref.n,e.getKey(),e.getValue());
                });
    }
}
