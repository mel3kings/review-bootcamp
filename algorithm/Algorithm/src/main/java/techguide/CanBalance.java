package techguide;

public class CanBalance {
    /**
     * Given a non-empty array,
     * return true if there is a place to split the array
     * so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.
     * <p>
     * canBalance([1, 1, 1, 2, 1]) → true
     * canBalance([2, 1, 1, 2, 1]) → false
     * canBalance([10, 10]) → true
     *
     * @param nums
     * @return
     */
    public boolean canBalance(int[] nums) {
        int left = 0, right = 0;

        for (int j = nums.length - 1; j > 0; j--) {
            right += nums[j];
            for (int i = 0; i < j; i++) {
                left += nums[i];
            }
            if (left == right) {
                return true;
            }
            left = 0;
        }

        return false;
    }


}
