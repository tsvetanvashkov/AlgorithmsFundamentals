package SearchingSortingAndGreedyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class mergeSort {
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
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int begin, int end) {
        if (begin >= end){
            return;
        }
        int mid = (begin + end) / 2;
        mergeSort(arr, begin, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, begin, mid, end);
    }

    private static void merge(int[] arr, int begin, int mid, int end) {
        if(mid < 0 || mid >= arr.length || arr[mid] < arr[mid+1]){
            return;
        }
        int left = begin;
        int right = mid + 1;
        int[] helper = new int[arr.length];
        for (int i = begin; i < arr.length; i++) {
            helper[i] = arr[i];
        }

        for (int i = begin; i <= end; i++) {
            if (left > mid){
                arr[i] = helper[right++];
            }else if (right > end){
                arr[i] = helper[left++];
            } else if (helper[left] < helper[right]) {
                arr[i] = helper[left++];
            }else {
                arr[i] = helper[right++];
            }
        }
    }
}
