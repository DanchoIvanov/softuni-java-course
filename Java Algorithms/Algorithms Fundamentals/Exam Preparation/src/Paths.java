import java.util.*;
import java.util.stream.Collectors;

public class Paths {
    public static List<List<Integer>> graph = new ArrayList<>();
    public static List<List<Integer>> paths = new ArrayList<>();
    public static List<Integer> currentPath = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n - 1; i++) {
            List<Integer> edges = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Integer::parseInt).collect(Collectors.toList());
            graph.add(edges);
        }

        for (int i = 0; i < graph.size(); i++) {
            dfs(i, n - 1);
        }

        StringBuilder sb = new StringBuilder();

        for (List<Integer> path : paths) {
            for (Integer node : path) {
                sb.append(node).append(" ");
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb.toString().trim());
    }

    private static void dfs(int node, int destination) {
        if (node == destination) {
            currentPath.add(node);
            paths.add(new ArrayList<>(currentPath));
            currentPath.remove(currentPath.size() - 1);
            return;
        }

        currentPath.add(node);

        for (Integer child : graph.get(node)) {
            dfs(child, destination);
        }

        currentPath.remove(currentPath.size() - 1);
    }
}
