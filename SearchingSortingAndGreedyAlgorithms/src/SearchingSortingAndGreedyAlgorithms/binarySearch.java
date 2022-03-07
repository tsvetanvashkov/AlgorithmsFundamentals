package SearchingSortingAndGreedyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class binarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(reader.readLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int num = Integer.parseInt(reader.readLine());
        reader.close();
        int out = getIndex(arr, num);
        System.out.println(out);
    }

    private static int getIndex(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int mid = (start + end) / 2;
            int value = arr[mid];
            if (key < value){
                end = mid - 1;
            }else if (key > value){
                start = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
