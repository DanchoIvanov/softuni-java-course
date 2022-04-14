package topological_sorting;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static boolean[] visited;
    public static Map<String, List<String>> graph = new LinkedHashMap<>();
    public static void main(String[] args) {
        graph = readGraph();
        Collection<String> sorted = topSort(graph);
        print(sorted);
    }

    private static void print(Collection<String> collection) {

        System.out.println("Topological sorting:");
        System.out.println(String.join(", ", collection));

    }

    private static void dfs(int node, List<List<Integer>> graph, Deque<Integer> currentComponents) {
        if (!visited[node]) {
            visited[node] = true;
            for (Integer child : graph.get(node)) {
                dfs(child, graph, currentComponents);
            }
            currentComponents.add(node);
        }
    }


    private static Map<String, List<String>> readGraph() {
        Map<String, List<String>> graph = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);

        String regex = "\"(?<node>\\w+)\"";
        Pattern pattern = Pattern.compile(regex);

        String input = scanner.nextLine();
        while (!input.equals("")) {
            Matcher matcher = pattern.matcher(input);
            List<String> nodes = new ArrayList<>();
            while (matcher.find()) {
                nodes.add(matcher.group("node"));
            }
            graph.put(nodes.get(0), new ArrayList<>());
            for (int i = 1; i < nodes.size(); i++) {
                graph.get(nodes.get(0)).add(nodes.get(i));
            }
            input = scanner.nextLine();
        }
        return graph;
    }

    public static List<Deque<Integer>> getConnectedComponents(List<List<Integer>> graph) {
        List<Deque<Integer>> connectedComponents = new ArrayList<>();

        visited = new boolean[graph.size()];

        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                Deque<Integer> currentComponents = new ArrayDeque<>();
                dfs(i, graph, currentComponents);
                connectedComponents.add(currentComponents);
            }
        }

        return connectedComponents;
    }

    public static Collection<String> topSort(Map<String, List<String>> graph) {
        Set<String> visited = new HashSet<>();
        Set<String> cycle = new HashSet<>();

        List<String> sorted = new ArrayList<>();

        for (String node : graph.keySet()) {
            topSortDfs(sorted, visited, node, graph, cycle);
        }

        return sorted;
    }

    private static void topSortDfs(List<String> sorted, Set<String> visited, String node, Map<String, List<String>> graph, Set<String> cycle) {
        if (cycle.contains(node)) {
            throw new IllegalArgumentException();
        }

        if (!visited.contains(node)) {
            visited.add(node);
            cycle.add(node);

            for (String child : graph.get(node)) {
                topSortDfs(sorted, visited, child, graph, cycle);
            }

            cycle.remove(node);
            sorted.add(0, node);
        }
    }
}
