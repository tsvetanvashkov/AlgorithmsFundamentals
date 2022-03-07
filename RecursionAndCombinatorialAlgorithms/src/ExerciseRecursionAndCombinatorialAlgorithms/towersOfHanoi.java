package ExerciseRecursionAndCombinatorialAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.stream.Collectors;

public class towersOfHanoi {
    public static Deque<Integer> source = new ArrayDeque<>();
    public static Deque<Integer> destination = new ArrayDeque<>();
    public static Deque<Integer> spare = new ArrayDeque<>();
    public static StringBuilder out = new StringBuilder();
    public static int step = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int disk = Integer.parseInt(reader.readLine());

        for (int i = disk; i > 0; i--) {
            source.push(i);
        }
        print();
        solve(disk, source, destination, spare);
        System.out.println(out.toString());
    }

    private static void solve(int disk, Deque<Integer> source, Deque<Integer> destination, Deque<Integer> spare) {
        if (disk == 1) {
            destination.push(source.pop());
            out.append(String.format("Step #%d: Moved disk\n", step++));
            print();
        } else {
            solve(disk - 1, source, spare, destination);
            solve(1, source, destination, spare);
            solve(disk - 1, spare, destination, source);
        }

    }

    private static void print() {
        out.append(String.format("Source: %s\nDestination: %s\nSpare: %s\n",
                formatValue(source), formatValue(destination), formatValue(spare)))
                .append(System.lineSeparator());
    }

    private static String formatValue(Deque<Integer> value) {
        return value.stream()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
