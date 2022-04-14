import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Molecules {
    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(reader.readLine());
        int edges = Integer.parseInt(reader.readLine());

        for (int i = 0; i <= nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges; i++) {
            String input = reader.readLine();
            int node = Integer.parseInt(input.split("\\s+")[0]);
            int child = Integer.parseInt(input.split("\\s+")[1]);
            graph.get(node).add(child);
        }

        visited = new boolean[nodes + 1];

        Deque<Integer> queue = new ArrayDeque<>();

        int start = Integer.parseInt(reader.readLine());
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;

            for (Integer child : graph.get(node)) {
                if (!visited[child]) {
                    queue.offer(child);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
