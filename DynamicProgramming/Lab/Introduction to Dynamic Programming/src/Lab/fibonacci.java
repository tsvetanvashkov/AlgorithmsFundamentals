package Lab;

import java.util.Scanner;

public class fibonacci {

    public static long[] dp;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        scan.close();
        dp = new long[num + 1];
        long fib = calcFib(num);
        System.out.println(fib);
    }

    private static long calcFib(int n) {
        if(n <= 2){
            return 1;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        return dp[n] = calcFib(n - 1) + calcFib(n - 2);
    }
}
