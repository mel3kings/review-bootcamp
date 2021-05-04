package easy;

//https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

public class CheckSortedArray {
    class Solution {
        public boolean check(int[] nums) {
            int min = nums[0];
            int minIndex = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] <= min){
                    min = nums[i];
                    minIndex = i;
                }
            }


            for(int i = 1;  i < minIndex; i++){
                if(nums[i] < nums[i-1]){
                    return false;
                }
            }
            if(minIndex != nums.length && minIndex != 0){
                for(int i = minIndex+1; i < nums.length; i++){
                    if(nums[i] < nums[i-1]){
                        return false;
                    }
                }
            }
            if(minIndex !=0 && nums[0] < nums[nums.length-1]){
                return false;
            }
            return true;
        }
    }
}

//[3,4,5,1,2]
//[2,1,3]
//[2,1,3,4]
//[1,1,1]
//[2,1]
//[1]
//[1,2,3]
//[1,2,3,4,5]
//[1,3,4,5]
//[3,6,10,1,8,9,9,8,9]
//[1,4,1,2,3,5]
//[7,9,1,1,1,3]//WRONG
