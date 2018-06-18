package algorithm;

public class AnagramArray {
    public static void main(String[] args) {
        System.out.println(isAnagram("algorithm", "mhtirogla"));
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
}
