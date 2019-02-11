package techguide;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Dictionary {

    public static void main(String[] args) {
        Dictionary d = new Dictionary();
        d.match("appbananable", new String[]{"apple", "banana", "cat", "acid"});
        List<String> wordsList = Arrays.asList("hello", "bye", "ciao", "bye", "ciao");
        // a p p b a n a n a p b l e
        // apple
        // banana
        // cat

        //words in play map
        // apple -> appple
        // banana ->
        // acid ->

    }

    public static boolean match(String word, String[] dictionary) {
        HashMap<Character, List<String>> dictionaryMap =
                Arrays.stream(dictionary).collect(groupingBy(val -> val.charAt(0),
                        HashMap::new,
                        Collectors.toList()));
        HashMap<String, String> wordsInPlay = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (dictionaryMap.containsKey(c)) {
                dictionaryMap.get(c).stream().forEach(play -> wordsInPlay.computeIfAbsent(play, v -> String.valueOf(c)));
            } else {
                for (String keys : wordsInPlay.keySet()) {
                    if (keys.contains(String.valueOf(c))) {
                        wordsInPlay.compute(keys, (k, v) -> v + c);
                    }
                }
            }
        }
        return false;
    }
}
