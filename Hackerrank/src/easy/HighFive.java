package easy;

import java.util.*;

//https://leetcode.com/problems/high-five/
public class HighFive {
    public int[][] highFive(int[][] items) {
        Map<Integer, List<Integer>> scores = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            int id = items[i][0];
            int score = items[i][1];

            scores.computeIfAbsent(id, (k) -> {
                return new ArrayList<Integer>();
            });

            List temp = scores.get(id);
            temp.add(score);
            Collections.sort(temp, Collections.reverseOrder());
            scores.put(id, temp);

        }
        int pointer = 0;
        int[][] response = new int[scores.size()][2];
        for (int key : scores.keySet()) {
            List<Integer> spp = scores.get(key);
            int running = 0;
            int average = 0;
            for (int i = 0; i < spp.size() && i < 5; i++) {
                running += spp.get(i);
                average++;
            }
            running = running / average;

            response[pointer][0] = key;
            response[pointer][1] = running;
            pointer++;
        }

        System.out.println(Arrays.deepToString(response));
        return response;
    }

}
