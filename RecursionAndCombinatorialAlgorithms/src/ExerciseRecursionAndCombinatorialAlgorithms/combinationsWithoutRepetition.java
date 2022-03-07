package ExerciseRecursionAndCombinatorialAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class combinationsWithoutRepetition {
    public static int[] arr;
    private static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());
        reader.close();
        arr = new int[k];
        combination(0, 1);

    }

    private static void combination(int index, int start) {
        if (index == arr.length) {
            print();
        } else {
            for (int i = start; i <= num; i++) {
                arr[index] = i;
                combination(index + 1, i + 1);
            }
        }
    }

    private static void print() {
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
