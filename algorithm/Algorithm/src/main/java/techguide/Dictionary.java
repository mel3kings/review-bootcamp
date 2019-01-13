package techguide;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Dictionary {

    public static void main(String[] args) {
        Dictionary d = new Dictionary();
        d.match("appbble", new String[]{"apple", "banana", "cat"});

    }

    public static boolean match(String word, String[] dictionary) {
        Map<String, Long> wordMap = IntStream.range(0, word.length())
                .mapToObj(n -> String.valueOf(word.charAt(n)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        System.out.println(wordMap);
        return false;
    }
}
