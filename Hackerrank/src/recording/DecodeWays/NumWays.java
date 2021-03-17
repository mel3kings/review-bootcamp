package recording.DecodeWays;

import java.util.*;

public class NumWays {
    int[] dp;

    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return numWays(s, s.length());
    }


    public int numWays(String s, int length) {
        if (dp[length] != -1) {
            return dp[length];
        }
        if (length == 1) {
            int firstNumber = Integer.parseInt(s);
            int response = firstNumber == 0 ? 0 : 1;
            dp[length] = response;
            return response;
        } else if (length == 2) {
            String firstVal = s.substring(0, 1);
            int response;
            int firstTwo = Integer.parseInt(s);
            if (firstVal.equals("0")) {
                response = 0;
            } else if (firstTwo > 26 || firstTwo == 10 || firstTwo == 20) {
                response = 1;
            } else if (firstTwo == 0) {
                response = 0;
            } else {
                response = 2;
            }
            dp[length] = response;
            return response;
        } else {
            String lastTwo = s.substring(length - 2, length);
            int lastTwoInt = Integer.parseInt(lastTwo);
            int response;
            if (lastTwoInt == 0) {
                response = 0;
            } else if (lastTwoInt > 26) {
                String sub = s.substring(0, length - 1);
                response = numWays(sub, sub.length());
            } else {
                String sub = s.substring(0, length - 1);
                String sub2 = s.substring(0, length - 2);
                response = numWays(sub, sub.length()) + numWays(sub2, sub2.length());
            }
            dp[length] = response;
            return response;
        }
    }
}

