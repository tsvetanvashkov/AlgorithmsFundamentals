package RecursionAndBacktracking;

public class eightQueensPuzzle {
    public static char[][] chessboard = new char[8][8];

    public static void main(String[] args) {
        fillBoard();
        putQueens(0);
    }

    private static void putQueens(int row) {
        if (row == 8) {
            printSolution();
        } else {
            for (int col = 0; col < 8; col++) {
                if (canPlaceQueen(row, col)) {
                    setQueen(row, col);
                    putQueens(row + 1);
                    removeQueen(row, col);
                }
            }
        }
    }

    private static void removeQueen(int row, int col) {
        chessboard[row][col] = '-';
    }

    private static void setQueen(int row, int col) {
        chessboard[row][col] = '*';
    }


    private static boolean canPlaceQueen(int row, int col) {
        for (int r = 0; r < 8; r++) {
            if (chessboard[r][col] == '*') {
                return false;
            }
        }
        for (int c = 0; c < 8; c++) {
            if (chessboard[row][c] == '*') {
                return false;
            }
        }
        int r = row;
        int c = col;
        while (--r >= 0 && --c >= 0) {
            if (chessboard[r][c] == '*') {
                return false;
            }
        }
        r = row;
        c = col;
        while (++r < 8 && ++c < 8) {
            if (chessboard[r][c] == '*') {
                return false;
            }
        }
        r = row;
        c = col;
        while (--r >= 0 && ++c < 8) {
            if (chessboard[r][c] == '*') {
                return false;
            }
        }
        r = row;
        c = col;
        while (++r < 8 && --c >= 0) {
            if (chessboard[r][c] == '*') {
                return false;
            }
        }
        return true;
    }

    private static void printSolution() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(chessboard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void fillBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessboard[i][j] = '-';
            }
        }
    }
}
