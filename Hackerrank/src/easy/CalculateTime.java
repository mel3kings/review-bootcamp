package easy;

import java.util.*;
//https://leetcode.com/problems/single-row-keyboard/
public class CalculateTime {
    class Solution {
        public int calculateTime(String keyboard, String word) {
            Map<Character, Integer> keyboardMap = new HashMap();
            char c[] = keyboard.toCharArray();
            for(int i = 0; i < c.length; i++){
                keyboardMap.put(c[i], i);
            }
            char w[] = word.toCharArray();
            int response =0;
            int current = 0;
            for(int i = 0; i < w.length; i++){
                int goingTo = keyboardMap.get(w[i]);
                response+= Math.abs(goingTo- current);
                current = goingTo;
            }
            return response;
        }
    }
}
