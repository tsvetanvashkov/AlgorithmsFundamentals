package Paths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class paths {

    public static int[][] graph;
    public static boolean[] visited;
    public static List<Integer> path;
    public static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberNodes = Integer.parseInt(reader.readLine());
        graph = new int[numberNodes - 1][];
        visited = new boolean[numberNodes];
        for (int i = 0; i < numberNodes - 1; i++) {
            graph[i] = Arrays.stream(reader.readLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        }
        for (int i = 0; i < numberNodes; i++) {
            path = new LinkedList<>();
            if(i < numberNodes - 1) {
                path.add(i);
            }
            dfs(i);
        }

    }

    private static void dfs(int node) {
        if(node >= graph.length){
            print();
            return;
        }

        visited[node] = true;
        for (Integer child : graph[node]) {
            if (!visited[child]){
                path.add(child);
                dfs(child);
                path.remove(child);
            }
        visited[node] = false;

        }
        out.append(System.lineSeparator());
    }

    private static void print() {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }

}
