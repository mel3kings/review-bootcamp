package algorithm;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] tester = {1, 123, 412, 123, 455, 11, 22, 34};
        bubbleSort(tester);

    }

    /**
     * Note remember length -1
     * Note remember to swap using j and j+1 vs i and j
     * @param unsorted
     */
    public static void bubbleSort(int[] unsorted) {
        boolean swapPerformed;
        for (int i = 0; i < unsorted.length - 1; i++) {
            swapPerformed = false;
            for (int j = 0; j < unsorted.length - 1; j++) {
                if (unsorted[j] > unsorted[j + 1]) {
                    int holder = unsorted[j];
                    unsorted[j] = unsorted[j + 1];
                    unsorted[j + 1] = holder;
                    swapPerformed = true;
                }
            }
            if (swapPerformed == false) {
                break;
            }
        }

        Arrays.stream(unsorted).forEach(i -> System.out.print(i + " ,"));
    }
}
