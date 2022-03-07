package RecursionAndBacktracking;

import java.util.Scanner;

public class recursiveDrawing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        scan.close();
        printFigure(number);
    }

    private static void printFigure(int number) {
        if (number < 1) {
            return;
        }
        printLineOfChars('*', number);
        printFigure(number - 1);
        printLineOfChars('#', number);
    }

    private static void printLineOfChars(char c, int number) {
        for (int i = 0; i < number; i++) {
            System.out.printf("%c", c);
        }
        System.out.println();
    }
}
