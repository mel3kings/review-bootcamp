package medium;

//https://leetcode.com/problems/product-of-array-except-self/

public class ProductExceptSelf {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] prods = new int[nums.length];
            boolean[] zeroes = new boolean[nums.length];
            int zeroesCount = 0;
            int running = nums[0];
            for(int i = 1; i < nums.length; i++){
                if(nums[i] == 0){
                    zeroes[i] = true;
                    zeroesCount++;
                }else{
                    running*= nums[i];
                }
                if(zeroesCount > 1){
                    return prods;
                }

            }
            for(int i = 0; i < nums.length; i++){
                if(zeroesCount == 1){
                    prods[i] = 0;
                }else{
                    prods[i] = running/nums[i];
                }
                if(zeroes[i]){
                    prods[i] = running;
                    return prods;
                }

            }
            return prods;
        }
    }
}

//[-1,-2,3,-4]
//[1,2,3,4]
//[-1,-2,3,-4]
//[1,2,3,4]
//[2,4,-2,1,2,-1,4,1,3,-3,-1,2,1,2,1,-3,1,-1,1,3,3,-2,-2,3,-3,-1,1,-2,-4,-2]
//[2,4,-2,1,2,-1,4,1,0,-3,-1,2,1,2,1,-3,1,-1,1,3,3,-2,-2,3,-3,-1,1,-2,0,-2]
//[1,2,3,4,5,6,7]
//[-1,-2,-3,-4,-5]
//[-30,30]
//[30,23]
//[1,2]
//[-1,-10]
//[-1,-1]
//[-1,1,0,-3,3,0]