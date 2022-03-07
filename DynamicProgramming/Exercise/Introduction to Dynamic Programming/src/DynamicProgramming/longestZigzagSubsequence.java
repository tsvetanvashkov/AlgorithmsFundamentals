package DynamicProgramming;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class longestZigzagSubsequence {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] number = Arrays.stream(scan.nextLine().split("\\s+"))
                                .mapToInt(Integer::parseInt)
                                .toArray();
        int[][] dp = new int[number.length + 1][2];
        int[][] prev = new int[number.length + 1][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        prev[0][0] = -1;
        prev[0][1] = -1;
        int maxLength = 0;
        int[] best = new int[2];

        for (int currentIndex = 0; currentIndex < number.length; currentIndex++) {
            int currentNumber = number[currentIndex];
            for (int prevIndex = currentIndex - 1; prevIndex >= 0; prevIndex--) {
                int prevNumber = number[prevIndex];
                if (currentNumber > prevNumber && dp[currentIndex][0] <= dp[prevIndex][1] + 1){
                    dp[currentIndex][0] = dp[prevIndex][1] + 1;
                    prev[currentIndex][0] = prevIndex;
                }else if (currentNumber < prevNumber && dp[currentIndex][1] <= dp[prevIndex][0] + 1){
                    dp[currentIndex][1] = dp[prevIndex][0] + 1;
                    prev[currentIndex][1] = prevIndex;
                }
            }

            if (maxLength < dp[currentIndex][0]){
                maxLength = dp[currentIndex][0];
                best[0] = currentIndex;
                best[1] = 0;
            }else if (maxLength < dp[currentIndex][1]){
                maxLength = dp[currentIndex][1];
                best[0] = currentIndex;
                best[1] = 1;
            }
        }

        Deque<Integer> sequence = new ArrayDeque<>();
        int beginRow = best[0];
        while (beginRow >= 0){
            sequence.push(number[beginRow]);
            beginRow = prev[beginRow][best[1]];
            best[1] = best[1] == 0 ? 1 : 0;
        }
        while (!sequence.isEmpty()){
            System.out.print(sequence.pop() + " ");
        }
    }
}
