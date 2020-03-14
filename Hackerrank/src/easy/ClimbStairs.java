package easy;

public class ClimbStairs {
    static int[] memoize = null;

    public static int climbStairs(int n) {
        if (memoize == null) {
            memoize = new int[n+1];
        }
        if (memoize[n] != 0){
            return memoize[n];
        }
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        int value = climbStairs(n - 1) + climbStairs(n - 2);
        memoize[n] =value;
        return value;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
}
