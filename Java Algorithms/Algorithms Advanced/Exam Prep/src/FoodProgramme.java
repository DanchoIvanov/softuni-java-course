import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FoodProgramme {

    public static int[][] graph;
    public static boolean[] visited;
    public static int[] travelTime;
    public static int[] previousNode;
    public static int source;
    public static int destination;

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

        visited = new boolean[graph.length];

        travelTime = new int[graph.length];
        Arrays.fill(travelTime, Integer.MAX_VALUE);
        travelTime[source] = 0;

        previousNode = new int[graph.length];
        Arrays.fill(previousNode, -1);

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(n -> travelTime[n]));

        queue.offer(source);

        while(!queue.isEmpty()) {

            int parent = queue.poll();
            visited[parent] = true;

            int[] children = graph[parent];

            for (int child = 0; child < children.length; child++) {
                int timeToTravel = graph[parent][child];
                if (timeToTravel != 0 && !visited[child]) {
                    queue.offer(child);

                    int newTime = travelTime[parent] + timeToTravel;
                    if (newTime < travelTime[child]) {
                        travelTime[child] = newTime;
                        previousNode[child] = parent;
                    }
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        path.add(destination);

        int index = previousNode[destination];

        while (index != -1) {
            path.add(index);
            index = previousNode[index];
        }

        StringBuilder sb = new StringBuilder();

        for (int i = path.size() - 1; i >= 0; i--) {
            sb.append(path.get(i)).append(" ");
        }

        System.out.println(sb.toString().trim());
        System.out.println(travelTime[destination]);
    }
}
