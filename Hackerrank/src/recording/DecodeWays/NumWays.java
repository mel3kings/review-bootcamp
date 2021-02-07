package recording.DecodeWays;

public class NumWays {

    // TODO REFRACTOR
    int[] dp;

    public int numDecodings(String s) {
        dp = new int[s.length()];
        return numWays(s);

    }

    public int numWays(String s) {
        int currLength = s.length();
        if (currLength == 1) {
            int firstNumber = Integer.parseInt(s);
            if (firstNumber == 0) {
                return 0;
            }
            return 1;
        } else if (currLength == 2) {
            int firstTwo = Integer.parseInt(s);
            if (firstTwo > 26 || firstTwo == 10 || firstTwo == 20) {
                return 1;
            } else if (firstTwo == 0) {
                return 0;
            }
            return 2;
        } else {
            String lastTwo = s.substring(currLength - 2, currLength);
            int lastTwoInt = Integer.parseInt(lastTwo);
            if (lastTwoInt == 0) {
                return 0;
            } else if (lastTwoInt > 26) {
                int result = numWays(s.substring(0, currLength - 1));
                return result;
            } else {
                int result = numWays(s.substring(0, currLength - 1)) + numWays(s.substring(0, currLength - 2));
                return result;
            }
        }
    }
}

