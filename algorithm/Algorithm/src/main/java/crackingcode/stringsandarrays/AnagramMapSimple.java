package crackingcode.stringsandarrays;

import java.util.HashMap;
import java.util.stream.IntStream;

public class AnagramMapSimple {
    public static void main(String[] args){
        System.out.println(isAnagram("BANANA", "ANANABA"));
    }

    public static boolean isAnagram(String a, String b){
        HashMap<Character, Integer> map = new HashMap<>();
        IntStream.range(0, a.length()).mapToObj(a::charAt)
                .forEach(c -> {
                    int holder = map.getOrDefault(c, 0);
                    map.put(c, ++holder);
                });
        IntStream.range(0, b.length()).mapToObj(b::charAt)
                .forEach(c -> {
                    int holder = map.getOrDefault(c, 0);
                    map.put(c, --holder);
                });
        return map.values().stream().anyMatch(mapValues -> mapValues != 0);
    }
}