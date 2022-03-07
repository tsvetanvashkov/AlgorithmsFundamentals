package ExerciseRecursionAndCombinatorialAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class connectedAreasInMatrix {
    public static char[][] matrix;
    public static List<int[]> areas;

    public static void main(String[] args) throws IOException {
        readMatrix();
        areas = new ArrayList<int[]>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == '-')
                    areas.add(new int[]{r, c, 0});
                findArea(r, c);
            }
        }
        System.out.printf("Total areas found: %d\n", areas.size());
        AtomicInteger counter = new AtomicInteger(1);
        areas.stream()
                .sorted((f, s) -> Integer.compare(s[2], f[2]))
                .forEach(a -> {
                    System.out.printf("Area #%d at (%d, %d), size: %d\n", counter.getAndIncrement(), a[0], a[1], a[2]);
                });

    }

    private static void findArea(int row, int col) {
        if (isOutOfBound(row, col) || isNotPass(row, col)) {
            return;
        }
        matrix[row][col] = 'V';
        areas.get(areas.size() - 1)[2]++;
        findArea(row - 1, col);
        findArea(row, col - 1);
        findArea(row + 1, col);
        findArea(row, col + 1);
    }

    private static boolean isNotPass(int row, int col) {
        return matrix[row][col] == 'V' || matrix[row][col] == '*';
    }

    private static boolean isOutOfBound(int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static void readMatrix() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int row = Integer.parseInt(reader.readLine());
        int col = Integer.parseInt(reader.readLine());
        matrix = new char[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = reader.readLine().toCharArray();
        }
        reader.close();
    }
}
