package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnagramGroups {

    public static void main(String[] args) {
        System.out.println(sameContents(new String[]{"abcd", "testering", "a"}, new String[]{"testering", "a", "abcd"}));
        friendlyWords(new String[]{"car", "cheating", "dale", "deal", "lead", "listen", "silent", "teaching",
                "beaching", "dale"});
    }

    private static boolean sameContents(String[] a, String[] b) {
        if (null == a || null == b) { return false; }
        Map<String, Long> map = Arrays.stream(a).filter(val -> val != null && !val.equals(""))
                .collect(Collectors.groupingBy(Function.identity(), java.util.stream.Collectors.counting()));
        Arrays.stream(b).forEach(bVal -> map.compute(bVal, (k, v) -> null == v ? -1 : v - 1));
        return map.values().stream().noneMatch(value -> value != 0);
    }

    /**
     * Groups words by hashcode and groups them by sound alikes
     * @param input
     */
    static void friendlyWords(String[] input) {
        Map<Integer, List<String>> friendlyWordsMap = Arrays.stream(input)
                .collect(Collectors.groupingBy(AnagramGroups::anagramHashCode));
        friendlyWordsMap.values().stream().forEach(list -> {
            list.sort(Comparator.comparing(Object::toString));
            if (list.size() > 1) {
                System.out.println(String.join(" ", list));
            }
        });
    }

    private static int anagramHashCode(String input) {
        char[] letters = input.toCharArray();
        Arrays.sort(letters);
        String newWord = new String(letters);
        return newWord.hashCode();
    }
}
