package algorithm;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        QuickSort s = new QuickSort();
        int[] sort = new int[]{3, 1, 2, 5, 6, 8, 4};
        s.quickSort(sort, 0, sort.length - 1);
        Arrays.stream(sort).forEach(System.out::println);
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int partition = partition(nums, start, end);
            quickSort(nums, start, partition - 1);
            quickSort(nums, partition + 1, end);
        }
    }

    public int partition(int[] nums, int start, int end) {
        int partition = nums[end];
        int i = start - 1;
        for (int j = start; j <= end; j++) {
            if (nums[j] <= partition) {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return i;
    }
}
