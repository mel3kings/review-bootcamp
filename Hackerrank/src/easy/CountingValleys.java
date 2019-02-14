package easy;

/**
 * https://www.hackerrank.com/challenges/counting-valleys/problem
 */
public class CountingValleys {

    public static void main(String[] args) {
        System.out.println(countingValleys(2, "DDUUDDUDUUUD"));
    }

    static int countingValleys(int n, String s) {
        int valleys = 0, seaLevel = 0;
        boolean goingUp = false;
        for (int i = 0; i < s.length(); i++) {
            String current = String.valueOf(s.charAt(i));
            if (current.equals("U")) {
                goingUp = true;
                seaLevel++;
            } else if (current.equals("D")) {
                seaLevel--;
                goingUp = false;
            }
            if (seaLevel == 0 && i != 0 && goingUp) {
                valleys++;
            }
        }
        return valleys;
    }
}
