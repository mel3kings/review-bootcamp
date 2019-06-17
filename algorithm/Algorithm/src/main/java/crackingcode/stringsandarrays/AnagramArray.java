package crackingcode.stringsandarrays;

import java.util.Arrays;

public class AnagramArray {

    public static void main(String[] args) {
        System.out.println(isAnagram2("algorithm", "mhtirogla"));
    }

    private static boolean isAnagram2(String a, String b) {
        int[] asci = new int[256];
        a.chars().forEach(val -> asci[val]++);
        b.chars().forEach(val -> asci[val]--);
        return !Arrays.stream(asci).anyMatch(i -> i != 0);
    }
}
