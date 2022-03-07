package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class pathsInLabyrinth {
    public static List<Character> path = new ArrayList<>();
    public static char[][] labyrint;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int row = Integer.parseInt(scan.nextLine());
        int col = Integer.parseInt(scan.nextLine());
        labyrint = new char[row][col];
        for (int i = 0; i < row; i++) {
            labyrint[i] = scan.nextLine().toCharArray();
        }
        findPath(0, 0, ' ');
    }

    private static void findPath(int row, int col, char direction) {
        if (!isInBound(labyrint, row, col)) {
            return;
        }
        path.add(direction);
        if (isExit(row, col)) {
            printPath();
        } else if (!isVisited(row, col) && isFree(row, col)) {
            mark(row, col);
            findPath(row, col + 1, 'R');
            findPath(row + 1, col, 'D');
            findPath(row, col - 1, 'L');
            findPath(row - 1, col, 'U');
            unmark(row, col);
        }
        path.remove(path.size() - 1);

    }

    private static void unmark(int row, int col) {
        labyrint[row][col] = '-';
    }

    private static void mark(int row, int col) {
        labyrint[row][col] = 'V';
    }

    private static boolean isFree(int row, int col) {
        return labyrint[row][col] != '*';
    }

    private static boolean isVisited(int row, int col) {
        return labyrint[row][col] == 'V';
    }

    private static void printPath() {
        for (int i = 1; i < path.size(); i++) {
            System.out.print(path.get(i));
        }
        System.out.println();
    }

    private static boolean isExit(int row, int col) {
        return labyrint[row][col] == 'e';
    }

    private static boolean isInBound(char[][] labyrint, int row, int col) {
        return row >= 0 && row < labyrint.length && col >= 0 && col < labyrint[row].length;
    }
}
