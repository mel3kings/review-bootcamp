package crackingcode.stringsandarrays;

import java.util.stream.Collectors;

public class CheckDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("Melchore"));
    }

    private static String removeDuplicates(String a) {
        return a.chars().mapToObj(e -> (char) e).collect(Collectors.toSet()).toString();
    }
}
