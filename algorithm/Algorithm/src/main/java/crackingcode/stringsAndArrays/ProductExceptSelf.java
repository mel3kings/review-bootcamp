package crackingcode.stringsandarrays;

import java.util.Arrays;

public class ProductExceptSelf {
    /**
     * Input:  [1,2,3,4]
     * holder: [1,2,3,4]
     * output
     * Output: [24,12,8,6]
     *
     * @param args
     */
    public static void main(String[] args) {
         int[] output = productExceptSelf(new int[]{1, 2, 3,4});
        Arrays.stream(output).forEach(System.out::println);

    }

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] t1 = new int[nums.length];
        int[] t2 = new int[nums.length];
        t1[0] = 1;
        t2[nums.length - 1] = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            t1[i + 1] = nums[i] * t1[i];
        }
        for (int i = nums.length - 1; i > 0; i--) {
            t2[i - 1] = t2[i] * nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = t1[i] * t2[i];
        }
        return result;
    }

}
