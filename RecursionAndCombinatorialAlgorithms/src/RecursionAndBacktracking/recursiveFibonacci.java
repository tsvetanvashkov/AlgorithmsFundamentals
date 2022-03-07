package RecursionAndBacktracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class recursiveFibonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        reader.close();
        System.out.println(fibonacci(number));
    }

    private static long fibonacci(int number) {
        if (number <= 1) {
            return 1;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }
}
