package ExerciseRecursionAndCombinatorialAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class reverseArray {
    public static int[] values;
    public static int[] arr;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        values = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        scan.close();
        arr = new int[values.length];
        reverse(0);
        print(arr);
    }

    private static void reverse(int index) {
        if (index == values.length) {
            return;
        }
        reverse(index + 1);
        arr[values.length - index - 1] = values[index];
    }

    private static void print(int[] arr) {
        for (int number : arr) {
            System.out.print(number + " ");
        }
    }
}
