package algorithm;

import java.util.Arrays;

public class MergeInPlaceAlgo {
    private static int[] helper;
    private static int[] sorted;

    public static void main(String[] args) {
        int[] test = {12, 7, 5, 0, 9, 2};
        sorted = test;
        helper = new int[test.length];
        sort(0, test.length - 1);
        Arrays.stream(sorted).forEach(i -> System.out.print(i + ","));
    }

    public static void sort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(start, mid);
            sort(mid + 1, end);
            merge(start, mid, end);
        }
    }

    public static void merge(int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            helper[i] = sorted[i];
        }
        int left = start;
        int right = mid + 1;
        int k = start;
        while (left <= mid && right <= end) {
            if (helper[left] <= helper[right]) {
                sorted[k] = helper[left];
                left++;
            } else {
                sorted[k] = helper[right];
                right++;
            }
            k++;
        }
        while (left <= mid) {
            sorted[k] = helper[left];
            k++;
            left++;
        }
    }
}
