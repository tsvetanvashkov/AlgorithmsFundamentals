package CombinatorialProblems;

import java.util.Scanner;

public class combinationsWithRepetition {
    public static String[] elements;
    public static String[] combinations;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        elements = scan.nextLine().split("\\s+");
        int number = scan.nextInt();
        scan.close();
        combinations = new String[number];
        combination(0, 0);
    }

    private static void combination(int index, int start) {
        if (index == combinations.length) {
            print(combinations);
        } else {
            for (int i = start; i < elements.length; i++) {
                combinations[index] = elements[i];
                combination(index + 1, i);
            }
        }
    }

    private static void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }
}
