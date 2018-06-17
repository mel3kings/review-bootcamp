package algorithm;


import java.util.Arrays;

/**
 * Iterate over the array one by one finding the smallest number against the current smallest
 * and then swapping them until you reach the end
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] test = {9, 8, 19, 1234, 33, 1, 2, 34};
        selectionSort(test);
        Arrays.stream(test).forEach(System.out::println);
    }

    public static void selectionSort(int[] unsortedArray) {
        for (int i = 0; i < unsortedArray.length; i++) {
            for (int j = i + 1; j < unsortedArray.length; j++) {
                if (unsortedArray[i] > unsortedArray[j]) {
                    int temp = unsortedArray[i];
                    unsortedArray[i] = unsortedArray[j];
                    unsortedArray[j] = temp;
                }
            }
        }
    }
}

