import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class VampireLabyrinth {

    public static int[][] graph;
    public static int source;
    public static int destination;
    public static int[] previous;
    public static int[] weight;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(reader.readLine());
        int edges = Integer.parseInt(reader.readLine());

        String input = reader.readLine();
        source = Integer.parseInt(input.split("\\s+")[0]);
        destination = Integer.parseInt(input.split("\\s+")[1]);

        graph = new int[nodes][nodes];

        for (int i = 0; i < edges; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            int from = Integer.parseInt(tokens[0]);
            int to = Integer.parseInt(tokens[1]);
            int weight = Integer.parseInt(tokens[2]);

            graph[from][to] = weight;
            graph[to][from] = weight;
        }

        dijkstra();
    }

    private static void dijkstra() {

        weight = new int[graph.length];
        Arrays.fill(weight, Integer.MAX_VALUE);
        weight[source] = 0;

        previous = new int[graph.length];
        Arrays.fill(previous, -1);

        visited = new boolean[graph.length];

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(n -> weight[n]));

        queue.offer(source);

        while (!queue.isEmpty()) {
            int parent = queue.poll();
            visited[parent] = true;

            int[] children = graph[parent];
            for (int child = 0; child < children.length ; child++) {
                int currentWeight = children[child];
                if (currentWeight != 0 && !visited[child]) {
                    queue.offer(child);

                    int newWeight = currentWeight + weight[parent];
                    if (newWeight < weight[child]) {
                        weight[child] = newWeight;
                        previous[child] = parent;
                    }
                }
            }
        }

        Deque<Integer> path = new ArrayDeque<>();
        path.push(destination);

        int index = previous[destination];

        while (index != -1) {
            path.push(index);
            index = previous[index];
        }

        StringBuilder sb = new StringBuilder();

        while (!path.isEmpty()) {
            sb.append(path.pop()).append(" ");
        }

        sb.append(System.lineSeparator()).append(weight[destination]);
        System.out.println(sb.toString().trim());
    }
}
