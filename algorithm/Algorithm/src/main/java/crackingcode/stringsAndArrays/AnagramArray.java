package crackingcode.stringsAndArrays;

import java.util.Arrays;

public class AnagramArray {
    public static void main(String[] args) {
        System.out.println(isAnagram("algorithm", "mhtirogla"));
        System.out.println(isAnagramEight("algorit1hm", "mhtirogla"));
    }

    public static boolean isAnagram(String a, String b) {
        int[] asci = new int[256];
        for (char c : a.toCharArray()) {
            asci[c]++;
        }
        for (char c : b.toCharArray()) {
            asci[c]--;
        }

        for (int i = 0; i < asci.length; i++) {
            if (asci[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAnagramEight(String a, String b){
        int[] asci = new int[256];
        a.chars().forEach(val ->asci[val]++);
        b.chars().forEach(val->asci[val]--);
        return !(Arrays.stream(asci).anyMatch(value -> value != 0));
    }
}
