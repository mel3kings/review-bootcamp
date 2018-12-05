package medium;

public class Permutations {
    public static void main(String[] args){
        String word = "abba";
        permutation(word);
    }

    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++) {
                String test = prefix + str.charAt(i);
                String p2 = str.substring(0, i) + str.substring(i + 1, n);
                permutation(test, p2);
                }
        }
    }

}
