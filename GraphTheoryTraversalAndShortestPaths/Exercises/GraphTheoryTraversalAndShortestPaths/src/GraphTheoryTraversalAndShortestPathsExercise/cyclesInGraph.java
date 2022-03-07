package GraphTheoryTraversalAndShortestPathsExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class cyclesInGraph {

    public  static Map<String, List<String>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String source = null;
        String prev = null;
        while (!input.equals("End")){
            String[] tokens = input.split("-");
            if(source == null){
                source = tokens[0];
            }
            graph.putIfAbsent(tokens[0], new ArrayList<>());
            graph.get(tokens[0]).add(tokens[1]);
            if (!graph.containsKey(tokens[1])){
                graph.putIfAbsent(tokens[1], new ArrayList<>());
            }
            graph.get(tokens[1]).add(tokens[0]);
            input = reader.readLine();
        }

        Set<String> visited = new HashSet<>();
        Set<String> cycles = new HashSet<>();

        try{
            dfs(source, prev, visited, cycles);
            System.out.println("Acyclic: Yes");
        }catch (IllegalStateException ex){
            System.out.println(ex.getMessage());
        }

    }

    private static void dfs(String source, String prev, Set<String> visited, Set<String> cycles) {
        if (cycles.contains(source)){
            throw new IllegalStateException("Acyclic: No");
        }
        if (visited.contains(source)){
            return;
        }
        cycles.add(source);
        visited.add(source);

        List<String> children = graph.get(source);
        if (children == null){
            return;
        }
        for (String child : graph.get(source)) {
            if (!child.equals(prev)){
                prev = source;
                dfs(child, prev, visited, cycles);
            }
        }
        cycles.remove(source);
    }
}
