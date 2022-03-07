package MonkeyBusiness;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class monkeyBusiness {

    public static int[] sequence;
    public static int solution = 0;
    public static StringBuilder out = new StringBuilder();
    public static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        reader.close();
        sequence = new int[num];
        numbers = new int[num];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        combination(0);
        out.append("Total Solutions: ").append(solution);
        System.out.println(out.toString());

    }

    private static void combination(int index) {
        if (index >= sequence.length){
            printCombination();
        }else{
                sequence[index] = numbers[index];
                combination(index + 1);
                sequence[index] = -numbers[index];
                combination(index + 1);

        }
    }

    private static void printCombination() {
        int sum = Arrays.stream(sequence).sum();
        if (sum == 0){
            solution++;
            for (int i = 0; i < sequence.length; i++) {
                String numberAsString = sequence[i] > 0 ? "+" + sequence[i] : String.valueOf(sequence[i]);
                out.append(numberAsString).append(" ");
            }
            out.append(System.lineSeparator());
        }
    }
}
