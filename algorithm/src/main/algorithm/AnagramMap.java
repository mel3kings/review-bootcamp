package algorithm;

import java.util.HashMap;

public class AnagramMap {

    public static void main(String[] args) {
        System.out.println(isAnagram("testing", "gnitest"));
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
}
