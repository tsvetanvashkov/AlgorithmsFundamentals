package CombinatorialProblems;

import java.util.Scanner;

public class variationsWithoutRepetition {
    public static String[] elements;
    public static String[] variations;
    public static boolean[] used;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        elements = scan.nextLine().split("\\s+");
        int number = scan.nextInt();
        scan.close();
        variations = new String[number];
        used = new boolean[elements.length];
        variation(0);
    }

    private static void variation(int index) {
        if (index == variations.length) {
            print(variations);
            return;
        }
        for (int i = 0; i < elements.length; i++) {
            if (!used[i]) {
                used[i] = true;
                variations[index] = elements[i];
                variation(index + 1);
                used[i] = false;
            }
        }
    }

    private static void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }
}
