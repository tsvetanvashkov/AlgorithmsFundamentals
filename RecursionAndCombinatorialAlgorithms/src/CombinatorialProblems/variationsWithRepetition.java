package CombinatorialProblems;

import java.util.Scanner;

public class variationsWithRepetition {
    public static String[] elements;
    public static String[] variations;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        elements = scan.nextLine().split("\\s+");
        int number = scan.nextInt();
        scan.close();
        variations = new String[number];
        variation(0);

    }

    private static void variation(int index) {
        if (index == variations.length) {
            print(variations);
            return;
        } else {
            for (int i = 0; i < elements.length; i++) {
                variations[index] = elements[i];
                variation(index + 1);
            }
        }

    }

    private static void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }
}
