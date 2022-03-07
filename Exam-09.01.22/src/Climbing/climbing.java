package Climbing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class climbing {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] dp = new int[rows][cols];
        int endRow = rows - 1;
        int endCol = cols - 1;
        dp[endRow][endCol] = matrix[endRow][endCol];

        for (int col = endCol - 1; col >= 0; col--) {
            dp[endRow][col] = dp[endRow][col + 1] + matrix[endRow][col];
        }
        for (int row = endRow - 1; row >= 0; row--) {
            dp[row][endCol] = dp[row + 1][endCol] + matrix[row][endCol];
        }
        for (int row = endRow - 1; row >= 0; row--) {
            for (int col = endCol - 1; col >= 0; col--) {
                dp[row][col] = Math.max(dp[row + 1][col] + matrix[row][col],
                        dp[row][col + 1] + matrix[row][col]);
            }
        }

        int sum = dp[0][0];

        int row = 0;
        int col = 0;
        List<String> path = new ArrayList<>();
        path.add(String.valueOf(matrix[row][col]));

        while (row < endRow || col < endCol){
            int top = -1;
            if(row < endRow){
                top = dp[row + 1][col];
            }
            int left = -1;
            if(col < endCol){
                left = dp[row][col + 1];
            }

            if(top > left){
                row++;
            }else{
                col++;
            }
            path.add(String.valueOf(matrix[row][col]));
        }
        Collections.reverse(path);
        System.out.println(sum);
        System.out.println(String.join(" ", path));

    }
}
