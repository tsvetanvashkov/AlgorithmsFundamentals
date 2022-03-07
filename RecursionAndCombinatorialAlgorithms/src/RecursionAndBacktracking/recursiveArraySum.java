package RecursionAndBacktracking;

import java.util.Arrays;
import java.util.Scanner;

public class recursiveArraySum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        scan.close();

        int sum = sumNumbers(input, 0);
        System.out.println(sum);

    }

    private static int sumNumbers(int[] arr, int index) {
        if (index >= arr.length) {
            return 0;
        }
        return arr[index] + sumNumbers(arr, index + 1);
    }
}
