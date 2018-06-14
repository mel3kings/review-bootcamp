package algorithm;

import java.util.Arrays;

/**
 * Swaps out based on a pivot point.
 */
public class QuickSort {
    public static void main(String[] args){
        int[] test = {6,8,7,2,4,3,5};
        QuickSort qs = new QuickSort();
        qs.sort(test, 0, test.length -1);
        Arrays.stream(test).forEach(System.out::println);
    }

    public void sort(int[] inputArray, int start, int end){
        if(start<end){
            int pp = partition(inputArray, start, end);
            sort(inputArray, start, pp-1);
            sort(inputArray, pp+1, end);
        }
    }

    public int partition(int[] input, int start, int end){
        int pivot = input[end];
        int i = start - 1;
        for(int j = start; j <= end-1; j++){
            if(input[j] <= pivot){
                i++;
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
            }
        }

        int temp = input[i+1];
        input[i+1] = input[end];
        input[end] = temp;
        return i+1;
    }
}
