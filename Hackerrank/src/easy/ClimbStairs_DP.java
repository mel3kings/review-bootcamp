package easy;

public class ClimbStairs_DP {

    int[] memo;

    public int climbStairs(int n) {
        memo = new int[n + 1];
        return compute(n);
    }

    public int compute(int n) {

        if (memo[n] != 0) {
            return memo[n];
        }
        int result = 0;
        if (n == 1) {
            result = 1;
        } else if (n == 2) {
            result = 2;
        } else {
            result = compute(n - 1) + compute(n - 2);
        }
        memo[n] = result;
        return result;
    }
}
