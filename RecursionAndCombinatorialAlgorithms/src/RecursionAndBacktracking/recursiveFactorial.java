package RecursionAndBacktracking;

import java.util.Scanner;

public class recursiveFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        scan.close();
        int output = factorial(number);
        System.out.println(output);
    }

    private static int factorial(int number) {
        if (number <= 0) {
            return 1;
        }
        return (number * factorial(number - 1));
    }
}
