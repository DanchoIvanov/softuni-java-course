import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class PathFinder {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static List<Set<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        int nodes = Integer.parseInt(reader.readLine());

        for (int i = 0; i < nodes; i++) {
            Set<Integer> edges = new HashSet<>();
            String input = reader.readLine();
            if (!input.trim().equals("")) {
                edges = Arrays.stream(input.split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toSet());
            }

            graph.add(edges);
        }
        StringBuilder sb = new StringBuilder();

        int paths = Integer.parseInt(reader.readLine());

        for (int i = 0; i < paths; i++) {
            List<Integer> path = Arrays.stream(reader.readLine().split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            boolean hasPath = true;

            for (int j = 1; j < path.size(); j++) {

                int node = path.get(j -1);
                int destination = path.get(j);

                if (!graph.get(node).contains(destination)) {
                    hasPath = false;
                    break;
                }
            }

            if (hasPath) {
                sb.append("yes");
            } else {
                sb.append("no");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString().trim());
    }
}
