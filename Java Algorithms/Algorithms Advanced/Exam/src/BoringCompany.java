import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BoringCompany {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(reader.readLine());
        int edges = Integer.parseInt(reader.readLine());
        int connections = Integer.parseInt(reader.readLine());

        int[][] graph = new int[nodes][nodes];

        for (int i = 0; i < edges; i++) {
            int[] tokens = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int source = tokens[0];
            int destination = tokens[1];
            int weight = tokens[2];

            graph[source][destination] = weight;
        }

        PriorityQueue<int[]> edgesQueue = new PriorityQueue<>(Comparator.comparingInt(n -> graph[n[0]][n[1]]));

        for (int row = 0; row < graph.length; row++) {
            for (int col = 0; col < graph[row].length; col++) {
                if (graph[row][col] != 0) {
                    edgesQueue.offer(new int[]{row, col});
                }
            }
        }

        int[] roots = new int[nodes];

        int forestSum = 0;

        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }

        for (int i = 0; i < connections ; i++) {
            int [] connection = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            roots[connection[1]] = connection[0];
        }

        StringBuilder sb = new StringBuilder();

        while (!edgesQueue.isEmpty()) {

            int[] edge = edgesQueue.poll();
            int source = edge[0];
            int destination = edge[1];
            int weight = graph[source][destination];

            int firstRoot = findRoot(source, roots);
            int secondRoot = findRoot(destination, roots);

            if (firstRoot != secondRoot) {
                roots[firstRoot] = secondRoot;
                forestSum += weight;
            }
        }
        System.out.println("Minimum budget: " + forestSum);
    }

    private static int findRoot(int source, int[] roots) {

        while (roots[source] != source) {
            source = roots[source];
        }

        return roots[source];
    }
}
