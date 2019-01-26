package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class DifferentTeams {

    public static void main(String[] args) {
        System.out.println(differentTeams("pcmpp"));
    }

    static int differentTeams(String skills) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('p', 0);
        map.put('c', 0);
        map.put('m', 0);
        map.put('b', 0);
        map.put('z', 0);
        for (Character c : skills.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        int result = map.values().stream().min(Integer::compareTo).map(o -> o.intValue()).orElse(0);
        return result;
    }
}
