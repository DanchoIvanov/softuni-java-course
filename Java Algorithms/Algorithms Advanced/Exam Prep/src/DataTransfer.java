import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DataTransfer {

    public static int[][] graph;
    public static int source;
    public static int destination;
    public static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(reader.readLine());
        int edges = Integer.parseInt(reader.readLine());

        String input = reader.readLine();
        source = Integer.parseInt(input.split("\\s+")[0]);
        destination = Integer.parseInt(input.split("\\s+")[1]);

        graph = new int[nodes][nodes];

        parents = new int[graph.length];

        for (int i = 0; i < edges; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            int from = Integer.parseInt(tokens[0]);
            int to = Integer.parseInt(tokens[1]);
            int weight = Integer.parseInt(tokens[2]);

            graph[from][to] = weight;
        }

        int maxFlow = 0;

        while (bfs()) {
            int flow = Integer.MAX_VALUE;
            int node = destination;

            while (node != source) {
                flow = Math.min(flow, graph[parents[node]][node]);
                node = parents[node];
            }

            maxFlow += flow;

            node = destination;

            while (node != source) {
                graph[parents[node]][node] -= flow;
                graph[node][parents[node]] += flow;
                node = parents[node];
            }
        }
        System.out.println(maxFlow);
    }

    private static boolean bfs() {
        boolean[] visited = new boolean[graph.length];

        Arrays.fill(parents, -1);

        Deque<Integer> deque = new ArrayDeque<>();

        deque.offer(source);
        visited[source] = true;

        while (!deque.isEmpty()) {
            int node = deque.poll();

            for (int child = 0; child < graph[node].length; child++) {
                if (graph[node][child] > 0 && !visited[child]) {
                    visited[child] = true;
                    parents[child] = node;
                    deque.offer(child);
                }
            }
        }

        return visited[destination];
    }
}
