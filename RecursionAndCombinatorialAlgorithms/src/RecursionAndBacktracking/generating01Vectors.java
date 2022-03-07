package RecursionAndBacktracking;

import java.util.Scanner;

public class generating01Vectors {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numBit = scan.nextInt();
        scan.close();
        Integer[] memory = new Integer[numBit];
        generateVector(memory, 0);

    }

    private static void generateVector(Integer[] memory, int i) {
        if (memory.length <= i) {
            print(memory);
            return;
        }
        for (int j = 0; j <= 1; j++) {
            memory[i] = j;
            generateVector(memory, i + 1);
        }
    }

    private static void print(Integer[] memory) {
        for (Integer i : memory) {
            System.out.print(i);
        }
        System.out.println();
    }
}
