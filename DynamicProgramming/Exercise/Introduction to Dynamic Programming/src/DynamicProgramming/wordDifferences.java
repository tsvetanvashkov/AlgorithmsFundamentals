package DynamicProgramming;

import java.util.Scanner;

public class wordDifferences {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] first = scan.nextLine().toCharArray();
        char[] second = scan.nextLine().toCharArray();

        int[][] dp = new int[first.length + 1][second.length + 1];

        for (int i = 0; i <= first.length; i++) {
            for (int j = 0; j <= second.length; j++) {
                if (i == 0){
                    dp[i][j] = j;
                }else if(j == 0){
                    dp[i][j] = i;
                }else if (first[i - 1] == second[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        System.out.println("Deletions and Insertions: " + dp[first.length][second.length]);
    }
}
