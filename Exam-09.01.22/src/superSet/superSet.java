package superSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class superSet {

    public static int[] elements;
    public static int[] combinations;
    public static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        elements = Arrays.stream(reader.readLine().split(",\\s+"))
                                .mapToInt(Integer::parseInt)
                                .toArray();
        reader.close();
        for (int i = 0; i <= elements.length; i++) {
            combinations = new int[i];
            combination(0, 0, i);
        }

    }

    private static void combination(int start, int index, int length) {
        if (index == length){
            print(combinations);
        }else {
            for (int i = start; i < elements.length; i++) {
                combinations[index] = elements[i];
                combination(i + 1, index + 1, length);
            }
        }


    }

    private static void print(int[] combinations) {
        for (int i = 0; i < combinations.length; i++) {
            System.out.print(combinations[i]);
            if (i < combinations.length - 1){
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
