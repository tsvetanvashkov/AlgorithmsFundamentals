package PathFinder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class pathFinder {

    public static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nodes = Integer.parseInt(reader.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            String nextLine = reader.readLine();
            if(nextLine.trim().equals("")){
                graph.add(new ArrayList<>());
            }else{
                List<Integer> nextNodes = Arrays.stream(nextLine.split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                graph.add(nextNodes);
            }
        }
        int pathNumber = Integer.parseInt(reader.readLine());
        List<List<Integer>>paths = new ArrayList<>();
        for (int i = 0; i < pathNumber; i++) {
            List<Integer> nextNodes = Arrays.stream(reader.readLine().split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            paths.add(nextNodes);
        }
        for (int i = 0; i < paths.size(); i++) {
            List<Integer> path = paths.get(i);
            try{
                dfs(0, path);
                System.out.println("no");
            }catch (IllegalStateException ex){
                System.out.println(ex.getMessage());
            }
        }

        System.out.println();
    }

    private static void dfs(int index, List<Integer> path) {
        if (index == path.size() - 1){
            throw new IllegalStateException("yes");
        }
        for (Integer child : graph.get(path.get(index))) {
            if (child == path.get(index + 1)){
                dfs(index + 1, path);
            }
        }

    }
}
