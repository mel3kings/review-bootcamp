package techguide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Dictionary {

    public static void main(String[] args) {
        System.out.println(longestWord("abppplekangarooe", new String[]{"able", "ale", "apple", "bale", "kangaroo"}));
    }

    /*
     For example, given the input of S = "abppplee" and
      D = {"able", "ale", "apple", "bale", "kangaroo"} the correct output would be "apple"
     */
    //SET, MAP, LIST, array
    public static String longestWord(String word, String[] dictionary) {
        //SOLUTION FIRST
        // a b p p p l e
        // a - > able ale, apple
        // b- bale
        // k - kangaro

        // a b p p l e
        // at A
        // get all A -> able ale apple increment with 1
        // at B -> get all with more than 0 and check if they have b if yes increment with A
        // get B -> increment with 1
        // AT P get all with more than 0 increment with 1
        // for each word with more than 1 equals to length return match

        HashMap<Character, ArrayList<String>> map = new HashMap<>();
        for (String dictionaryWord : dictionary) {
            Character c = dictionaryWord.charAt(0);
            if (null == map.get(c)) {
                map.put(c, new ArrayList<>(Arrays.asList(dictionaryWord)));
            } else {
                map.get(c).add(dictionaryWord);
            }
        }
        HashMap<String, Integer> activeWords = new HashMap<>();
        for (Character c : word.toCharArray()) {
            if (null != map.get(c)) {
                for (String validWords : map.get(c)) {
                    activeWords.put(validWords, 1);
                }
            }
        }
        for (Character c : word.toCharArray()) {
            for (String keys : activeWords.keySet()) {
                if (keys.contains(String.valueOf(c))) {
                    activeWords.put(keys, activeWords.get(keys) + 1);
                }
            }
        }
        int longest = 0;
        String longestWord = "";
        for (String keys : activeWords.keySet()) {
            if (activeWords.get(keys) > longest) {
                longest = activeWords.get(keys);
                longestWord = keys;
            }
        }
        return longestWord;
    }

    public static void bruteForce(String word, String[] dictionary) {
        // first step brute force of iteration
        for (String dict : dictionary) {
            int length = 0;
            for (char c : dict.toCharArray()) {
                if (word.contains(String.valueOf(c))) {
                    System.out.println("FOUND: " + c);
                    length++;
                }
                System.out.println(length);
            }
        }
    }
}
