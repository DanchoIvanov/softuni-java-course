import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DoraTheExplorer {
    public static Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
    public static int timeSpentOnStop;
    public static int source;
    public static int destination;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int edges = Integer.parseInt(reader.readLine());

        for (int i = 0; i < edges; i++) {
            int[] tokens = Arrays.stream(reader.readLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int startNode = tokens[0];
            int endNode = tokens[1];
            int distance = tokens[2];

            graph.putIfAbsent(startNode, new HashMap<>());
            graph.get(startNode).putIfAbsent(endNode, distance);
            graph.putIfAbsent(endNode, new HashMap<>());
            graph.get(endNode).putIfAbsent(startNode, distance);
        }

        timeSpentOnStop = Integer.parseInt(reader.readLine());
        source = Integer.parseInt(reader.readLine());
        destination = Integer.parseInt(reader.readLine());

        dijkstra();
    }

    private static void dijkstra() {

        Map<Integer, Integer> time = new HashMap<>();
        Map<Integer, Integer> prev = new HashMap<>();

        Set<Integer> visited = new HashSet<>();

        for (Integer node : graph.keySet()) {
            time.putIfAbsent(node, Integer.MAX_VALUE);
            prev.putIfAbsent(node, -1);
        }

        time.put(source, 0);

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(time::get).reversed());

        queue.offer(source);

        while (!queue.isEmpty()) {
            int parent = queue.poll();
            visited.add(parent);

            Map<Integer, Integer> children = graph.get(parent);

            for (Map.Entry<Integer, Integer> child : children.entrySet()) {
                int currentTime = child.getValue();
                if (!visited.contains(child.getKey())) {
                    queue.offer(child.getKey());

                    int newTime = time.get(parent) + currentTime;
                    if (child.getKey() != destination) {
                        newTime += timeSpentOnStop;
                    }

                    if (newTime < time.get(child.getKey())) {
                        time.put(child.getKey(), newTime);
                        prev.put(child.getKey(), parent);
                    }
                }
            }
        }
        Deque<Integer> path = new ArrayDeque<>();
        path.push(destination);

        int index = prev.get(destination);

        while (index != -1) {
            path.push(index);
            index = prev.get(index);
        }
        StringBuilder sb = new StringBuilder();
        while (!path.isEmpty()) {
            sb.append(path.pop()).append(System.lineSeparator());
        }

        System.out.println("Total time: " + time.get(destination));
        System.out.println(sb.toString().trim());
    }
}
