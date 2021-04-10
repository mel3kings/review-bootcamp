package easy;

//https://leetcode.com/problems/armstrong-number/
public class Armstrong {
    public boolean isArmstrong(int n) {
        double running = 0;
        int orig = n;
        int length = String.valueOf(n).length();
        while (n > 0) {
            int mod = n % 10;
            double temp = Math.pow(mod, length);
            running += temp;
            n /= 10;
        }

        if ((int) running == orig) return true;
        return false;

    }

}
