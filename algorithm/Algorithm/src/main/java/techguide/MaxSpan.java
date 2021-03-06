package techguide;

public class MaxSpan {

    /**
     * Consider the leftmost and righmost appearances of some value in an array.
     * We'll say that the "span" is the number of elements between the two inclusive.
     * A single value has a span of 1. Returns the largest span found in the given array.
     * (Efficiency is not a priority.)
     *
     *
     * MaxSpan([1, 2, 1, 1, 3]) → 4
     * MaxSpan([1, 4, 2, 1, 4, 1, 4]) → 6
     * MaxSpan([1, 4, 2, 1, 4, 4, 4]) → 6
     *
     * @return
     */

    public static void main(String[] args){
        MaxSpan n = new MaxSpan();
        n.maxSpan(new int[]{1,2,1,1,3});
    }

    public int maxSpan(int[] nums) {
        int longestLength = 0;
        for(int i = 0; i <= nums.length; i++){
            for(int j = i; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    int tempCounter=  (j -i) +1;
                    if(tempCounter > longestLength){
                        longestLength = tempCounter;
                    }
                }
            }
        }
        return longestLength;
    }

    public int maxSpanV2(int[] nums) {
        int longestSpan = 0;
        for (int i = 0; i < nums.length; i++) {
            int difference = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    difference = 1 + (j - i);
                }

            }
            if (difference > longestSpan) {
                longestSpan = difference;
            }
        }
        return longestSpan;
    }

}