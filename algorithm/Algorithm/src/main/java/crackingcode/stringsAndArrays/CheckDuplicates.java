package crackingcode.stringsandarrays;

import java.util.LinkedHashSet;

public class CheckDuplicates {

    public static void main(String[] args) {
        System.out.println(checkDuplicate("Melchore"));
    }

    private static boolean checkDuplicate(String str) {
        boolean[] listOfChars = new boolean[266];
        for (Character c : str.toCharArray()) {
            if (listOfChars[c]) {
                return true;
            }
            listOfChars[c] = true;
        }
        return false;
    }

    /**
     * Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer.
     * NOTE: One or two additional variables are fine. An extra copy of the array is not.
     */
    private static String removeDuplicates(String a) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        a.chars().mapToObj(e -> (char) e).forEach(set::add);
        return set.toString();
    }
}
