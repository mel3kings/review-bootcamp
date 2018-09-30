package algorithm;

import java.util.Arrays;

/**
 * Keeps breaking the array into two parts until base, then merges them in sorted order
 */
public class MergeSortAlgo {
    public static void main(String[] args) {
        int[] test = {12, 7, 5, 0, 9, 2};
        sort(test, 0, test.length - 1);
        Arrays.stream(test).forEach(System.out::println);


    }

    public static void sort(int[] unsorted, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(unsorted, start, mid);
            sort(unsorted, mid + 1, end);
            merge(unsorted, start, mid, end);
        }
    }

    public static void merge(int[] unsorted, int start, int mid, int end) {
        // the size of the temp array is critical here.
        int[] temp = new int[end - start + 1];
        int leftSlot = start;
        int rightSlot = mid + 1;
        int k = 0;

        while (leftSlot <= mid && rightSlot <= end) {
            if (unsorted[leftSlot] < unsorted[rightSlot]) {
                temp[k] = unsorted[leftSlot];
                leftSlot++;
            } else {
                temp[k] = unsorted[rightSlot];
                rightSlot++;
            }
            k++;
        }

        //right side sorted or left side already sorted
        if (leftSlot <= mid) {
            while (leftSlot <= mid) {
                temp[k] = unsorted[leftSlot];
                leftSlot++;
                k++;
            }
        } else if (rightSlot <= end) {
            while (rightSlot <= end) {
                temp[k] = unsorted[rightSlot];
                rightSlot++;
                k++;
            }
        }

        //we are replacing on the some spots on the unsorted array based on the size of the temp one
        for (int i = 0; i < temp.length; i++) { //NOTE start + i on replacing, as our temp is dynamic as well based on size
            unsorted[start + i] = temp[i];
        }
    }
}
