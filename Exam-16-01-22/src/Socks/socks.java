package Socks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class socks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] leftSocks = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] rightSocks = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[][] dp = new int[rightSocks.length + 1][leftSocks.length + 1];
        for (int i = 1; i <= rightSocks.length; i++) {
            for (int j = 1; j <= leftSocks.length; j++) {
                if (rightSocks[i - 1] == leftSocks[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[rightSocks.length][leftSocks.length]);
    }
}
