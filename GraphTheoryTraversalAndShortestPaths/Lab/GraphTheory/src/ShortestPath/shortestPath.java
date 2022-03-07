package ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class shortestPath {

    public static boolean[] visited;
    public static int[] prevNodes;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(reader.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < node + 1; i++) {
            graph.add(new ArrayList<>());
        }
        int edges = Integer.parseInt(reader.readLine());
        for (int i = 0; i < edges; i++) {
            int[] paths = Arrays.stream(reader.readLine().split("\\s+"))
                                    .mapToInt(Integer::parseInt)
                                    .toArray();
            graph.get(paths[0]).add(paths[1]);
        }
        int source = Integer.parseInt(reader.readLine());
        int destination = Integer.parseInt(reader.readLine());
        visited = new boolean[node + 1];
        prevNodes = new int[node + 1];
        Arrays.fill(prevNodes, -1);

        bfs(graph, source, destination);

        List<Integer> path = new ArrayList<>();
        path.add(destination);
        int prevNode = prevNodes[destination];
        while (prevNode != -1){
            path.add(prevNode);
            prevNode = prevNodes[prevNode];
        }

        System.out.println("Shortest path length is: " + (path.size() - 1));
        for (int i = path.size() - 1; i >= 0 ; i--) {
            System.out.print(path.get(i) + " ");
        }

    }

    private static void bfs(List<List<Integer>> graph, int source, int destination) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        visited[source] = true;
        while (!queue.isEmpty()){
            int node = queue.poll();
            if (node == destination){
                return;
            }
            for (int child: graph.get(node)) {
                if (!visited[child]){
                    visited[child] = true;
                    prevNodes[child] = node;
                    queue.offer(child);
                }
            }
        }
    }
}
