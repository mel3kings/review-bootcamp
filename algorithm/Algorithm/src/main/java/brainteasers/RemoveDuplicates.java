package brainteasers;

import java.util.LinkedHashSet;

/**
 * Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer.
 * NOTE: One or two additional variables are fine. An extra copy of the array is not.
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        String withDuplicates = "mississippi";
        System.out.print(removeDuplicates(withDuplicates));
    }

    private static String removeDuplicates(String a) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        a.chars().mapToObj(e -> (char) e).forEach(set::add);
        return set.toString();
    }
}
