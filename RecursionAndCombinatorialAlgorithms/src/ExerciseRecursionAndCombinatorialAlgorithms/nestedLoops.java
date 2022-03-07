package ExerciseRecursionAndCombinatorialAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class nestedLoops {
    public static int[] arr;
    public static int number;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        number = Integer.parseInt(reader.readLine());
        arr = new int[number];
        recursion(0);
    }

    private static void recursion(int index) {
        if (index == arr.length) {
            print();
        } else {
            for (int i = 1; i <= number; i++) {
                arr[index] = i;
                recursion(index + 1);
            }
        }
    }

    private static void print() {
        for (Integer n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
