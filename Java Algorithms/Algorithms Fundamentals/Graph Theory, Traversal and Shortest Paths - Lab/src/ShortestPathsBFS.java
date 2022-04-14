import java.util.*;

public class ShortestPathsBFS {
    public static boolean[] visited;
    public static int[] prevNodes;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodes = Integer.parseInt(scanner.nextLine());
        int edges = Integer.parseInt(scanner.nextLine());

        Map<Integer, List<Integer>> dependencies = new HashMap<>();

        for (int i = 0; i < edges; i++) {
            String input = scanner.nextLine();
            int parent = Integer.parseInt(input.split("\\s+")[0]);
            int child = Integer.parseInt(input.split("\\s+")[1]);

            dependencies.putIfAbsent(parent, new ArrayList<>());
            dependencies.get(parent).add(child);
        }

        int start = Integer.parseInt(scanner.nextLine());
        int destination = Integer.parseInt(scanner.nextLine());

        prevNodes = new int[nodes + 1];
        visited = new boolean[nodes + 1];

        Arrays.fill(prevNodes, -1);

        bfs(dependencies, start, destination);

        List<Integer> path = new ArrayList<>();
        path.add(destination);

        int prevNode = prevNodes[destination];
        while (prevNode != -1) {
            path.add(prevNode);
            prevNode = prevNodes[prevNode];
        }

        print(path);
    }

    private static void print(List<Integer> path) {
        System.out.println("Shortest path length is: " + (path.size() - 1));

        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
    }

    private static void bfs(Map<Integer, List<Integer>> dependencies, int start, int destination) {
        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == destination) {
                return;
            }
            if (dependencies.containsKey(node)) {
                for (Integer child : dependencies.get(node)) {
                    if (!visited[child]) {
                        visited[child] = true;
                        prevNodes[child] = node;
                        queue.offer(child);
                    }
                }
            }
        }
    }
}
