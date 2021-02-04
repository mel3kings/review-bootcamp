package easy;

import java.util.*;

public class Persist {
    public static HashMap<Integer, List<Integer>> memo = new HashMap<>();

    public static List<Integer> bestSum(int n, int[] arr) {
        if (memo.containsKey(n)) {
            //System.out.printf("From memo: %d->"+ memo.get(n)+"%n",n);
            return memo.get(n);
        }
        if (n == 0) return new ArrayList<>();
        if (n < 0) return null;
        List<Integer> minn = null;
        for (int i = 0; i < arr.length; i++) {
            var temp = bestSum(n - arr[i], arr);
            if (temp != null) {
                temp.add(arr[i]);
                if (minn == null || temp.size() < minn.size()) {
                    minn = new ArrayList<>(temp);

                }
            }
        }
        //System.out.println(n+": "+minn);
        memo.put(n, minn);
        //System.out.println(memo.get(n));
        return minn;
    }

    public static void main(String[] args) {
        System.out.println(bestSum(7, new int[]{2, 1, 3}));
        System.out.println(memo);
    }

}
