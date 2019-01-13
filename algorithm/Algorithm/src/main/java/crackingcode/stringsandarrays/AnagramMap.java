package crackingcode.stringsandarrays;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AnagramMap {
    public static void main(String[] args) {
        System.out.println(isAnagram("testinga", "agnitest"));
        System.out.println(isAnagramEight("testinga", "agnitest"));
    }

    public static boolean isAnagram(String a, String b) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : a.toCharArray()) {
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        for (char c : b.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            if (map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            }
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }
        return map.isEmpty();
    }

    private static boolean isAnagramEight(String a, String b) {
        Map<Character, Long> map = IntStream.range(0, a.length())
                .mapToObj(a::charAt)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        IntStream.range(0, b.length())
                .mapToObj(b::charAt)
                .forEach(bVal ->
                        map.compute(bVal, (k, v) -> {
                            long value = null == v ? -1 : v - 1;
                            return value;
                        }));
        return !map.values().stream().anyMatch(value -> value != 0);
    }
}
