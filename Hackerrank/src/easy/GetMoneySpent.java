package easy;

/**
 * https://www.hackerrank.com/challenges/electronics-shop/problem
 */
public class GetMoneySpent {

    public static void main(String[] args) {
        int[] keyboards = {3, 1};
        int[] drives = {5, 2, 8};
        int max = 10;
        System.out.println(getMoneySpent(keyboards, drives, max));
    }

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int spent = 0;
        for (int i = 0; i < keyboards.length; i++) {
            for (int j = 0; j < drives.length; j++) {
                int current = keyboards[i] + drives[j];
                if (current <= b && current > spent) {
                    spent = current;
                }
            }
        }
        return spent > 0 ? spent : -1;
    }

}
