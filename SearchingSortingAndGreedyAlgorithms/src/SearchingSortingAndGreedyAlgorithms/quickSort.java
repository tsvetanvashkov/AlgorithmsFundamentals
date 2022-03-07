package SearchingSortingAndGreedyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        reader.close();

        sort(arr);
        print(arr);

    }

    private static void print(int[] arr) {
        for (Integer num: arr) {
            System.out.print(num + " ");
        }
    }

    private static void sort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private static void quicksort(int[] arr, int low, int high) {
        if(low < high){
            int pi = partition(arr, low, high);
            quicksort(arr, low, pi - 1);
            quicksort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int index = low - 1;
        for (int i = low; i < high; i++) {
            if (arr[i] <= pivot){
                index++;
                swap(arr, index, i);
            }
        }
        swap(arr, index + 1, high);
        return  index + 1;
    }

    private static void swap(int[] arr, int k, int n) {
        int temp = arr[k];
        arr[k] = arr[n];
        arr[n] = temp;
    }
}
