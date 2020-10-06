package medium;

import java.util.*;

/**
 * https://leetcode.com/problems/permutations-ii/submissions/
 * back tracking with dups
 */
public class Permutation {

    List<List<Integer>> result = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        bt(new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return result;
    }

    public void bt(List<Integer> tmp, int[] nums, boolean[] used) {
        if (tmp.size() == nums.length) {
            ArrayList<Integer> add = new ArrayList<Integer>(tmp);
            if (!set.contains(add)) {
                result.add(add);
                set.add(add);
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;

                tmp.add(nums[i]);
                used[i] = true;
                bt(tmp, nums, used);

                used[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
