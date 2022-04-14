package connected_components;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static boolean[] visited;
    public static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) {
        graph = readGraph();

        List<Deque<Integer>> connectedComponents = getConnectedComponents(graph);
        print(connectedComponents);
    }

    private static void print(List<Deque<Integer>> connectedComponents) {

        for (Deque<Integer> connectedGraph : connectedComponents) {
            StringBuilder sb = new StringBuilder();
            while (!connectedGraph.isEmpty()) {
                sb.append(" ").append(connectedGraph.pop());
            }
            System.out.printf("Connected component:%s%n", sb);
        }

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

    private static List<List<Integer>> readGraph() {
            List<List<Integer>> graph = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int nodes = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < nodes; i++) {
            List<Integer> currentEdges = new ArrayList<>();
            String currentLine = scanner.nextLine();
            if (!currentLine.trim().equals("")){
                currentEdges = Arrays.stream(currentLine.split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
            }
            graph.add(currentEdges);
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
        throw new AssertionError("Not Implemented");
    }
}
