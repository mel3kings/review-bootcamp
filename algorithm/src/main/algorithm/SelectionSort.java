package algorithm;


import java.util.Arrays;

/**
 * Iterate over the array one by one finding the smallest number against the current smallest
 * and then swapping them until you reach the end
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] test = {9, 8, 19, 1234, 33, 1, 2, 34};
        Arrays.stream(selectionSort(test)).forEach(System.out::println);
    }

    public static int[] selectionSort(int[] sortMe) {
        for (int i = 0; i < sortMe.length; i++) {
            int minimum = i;
            for (int j = i + 1; j < sortMe.length; j++) {
                if (sortMe[j] < sortMe[minimum]) {
                    minimum = j;
                }
            }
            int temp = sortMe[i];
            sortMe[i] = sortMe[minimum];
            sortMe[minimum] = temp;
        }
        return sortMe;

    }
}
