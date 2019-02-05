package hackerrank;

import java.util.*;

public class TriangleDisplay {

    public static void print(String text) {
        String[] words = text.split(" ");
        Deque<String> ordered = new LinkedList<>();
        int previousLine = 0;
        StringBuffer line = new StringBuffer();
        for (int i = words.length - 1; i >= 0; i--) {
            String currentWord = words[i];
            line.insert(0, " " + currentWord);
            if (line.length() >= previousLine || i == 0) {
                ordered.push(line.toString());
                previousLine = line.length();
                line = new StringBuffer("");
            }
        }
        while (!ordered.isEmpty()) {
            System.out.println(ordered.poll());
        }
    }

    public static void main(String[] args) {
        String s = "Property prices in Sydney and Melbourne dropped sharply again in January as the decline in the " +
                "once-booming housing market continues to gather pace Prices in the Melbourne market fell by a huge 1" +
                ".6% in the first month of the year, eclipsing even Sydney’s 1.3% fall, researcher CoreLogic said on" +
                " Friday in its regular monthly release. Other capital cities have also begun to lose steam as " +
                "restrictions in mortgage lending – especially to investors – weak wages growth and oversupply in " +
                "apartments took their toll on buyer sentiment and increasingly threatens to impact economic growth.";
        print(s);
    }
}
