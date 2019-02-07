package easy;

import java.util.ArrayList;
import java.util.Arrays;

public class BetweenTwoSets {

    public static void main(String[] args) {
        int response = getTotalX(new int[]{2, 4}, new int[]{32, 96, 16});
        System.out.println(response);
    }

    static int getTotalX(int[] a, int[] b) {
        Arrays.sort(b);
        ArrayList<Integer> considered = new ArrayList<>();

        for (int max = b[0]; max > 0; max--) {
            boolean isFactor = true;
            for (int i = 0; i < a.length && isFactor; i++) {
                if (max % a[i] != 0) {
                    isFactor = false;
                }
            }
            if (isFactor) {
                considered.add(max);
            }
        }
        int counter = 0;

        for (int j : considered) {
            boolean isFactor = true;

            for (int i = 0; i < b.length; i++) {
                int check = b[i];
                if (check % j != 0) {
                    isFactor = false;
                    break;
                }
            }
            if (isFactor) {
                counter++;
            }

        }
        return counter;
    }
}
