package GraphTheoryTraversalAndShortestPathsExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class distanceBetweenVertices {

    public static int[][] graph;
    public static Map<Integer, Integer> indexMapper = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nodes = Integer.parseInt(reader.readLine());
        int pairs = Integer.parseInt(reader.readLine());
        graph = new int[nodes + 1][];
        for (int i = 0; i < nodes; i++) {
            String[] edges = reader.readLine().split(":");
            indexMapper.put(Integer.parseInt(edges[0]), i);
            if (edges.length == 1){
                graph[i] = new int[0];
            }else{
                graph[i] = Arrays.stream(edges[1].split("\\s+"))
                                    .mapToInt(Integer::parseInt)
                                    .toArray();
            }
        }
        while (pairs-- > 0){
            int[] relations = Arrays.stream(reader.readLine().split("-"))
                                        .mapToInt(Integer::parseInt)
                                        .toArray();
            int source = relations[0];
            int dest = relations[1];
            System.out.printf("{%d, %d} -> ", source, dest );
            int[] prev = new int[graph.length];
            Arrays.fill(prev, -1);

            bfs(graph, indexMapper.get(source), indexMapper.get(dest), prev);

            List<Integer> path = new ArrayList<>();
            int parent = prev[indexMapper.get(dest)];
            while (parent != -1){
                path.add(parent);
                parent = prev[parent];
            }
            int size = path.isEmpty() ? -1 : path.size();

            System.out.println(size);
        }

    }

    private static void bfs(int[][] graph, Integer source, Integer dest, int[] prev) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        boolean[] visited = new boolean[graph.length +1];
        visited[source] = true;

        while (!queue.isEmpty()){
            Integer node = queue.poll();
            if (node == dest){
                return;
            }
            for (int i = 0; i < graph[node].length; i++) {
                int child = indexMapper.get(graph[node][i]);
                if (!visited[child]){
                    prev[child] = node;
                    visited[child] = true;
                    queue.offer(child);
                }
            }
        }
        prev[source] = -1;
    }
}
