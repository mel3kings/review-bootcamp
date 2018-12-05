package crackingcode.review;

import java.util.Arrays;
import java.util.HashMap;

public class Robot {
    private static int[] stash = new int[10];
    private static HashMap<Integer, String> map = new HashMap<Integer, String>();

    public static void main(String[] args) {
        map.put(10, "A");
        map.put(11, "B");
        map.put(12, "C");
        map.put(13, "D");
        map.put(14, "E");
        map.put(15, "F");

        String command = "PMLPMLPMLPMLPMLPMLPMLPMLPMLPMLPMLPMLPMLPMLPMLPMLPMLPMLPMMMLPMLPMMLPMMMMMMMMMMLPMMMMMMMMMML";
        executeCommand(command);
    }

    private static void executeCommand(String command) {
        int block = 0;
        int stashLocation = 0;
        for (Character c : command.toCharArray()) {
            switch (c) {
                case 'P':
                    if (block == 0) {
                        block = 1;
                    } else {
                        stashLocation = 0;
                    }
                    break;
                case 'M':
                    if (stashLocation < 9) {
                        stashLocation++;
                    }
                    break;
                case 'L':
                    if (block != 0 && stash[stashLocation] < 15) {
                        stash[stashLocation] = stash[stashLocation] + 1;
                        block = 0;
                        stashLocation = 0;
                    }
                    break;
            }
        }
        Arrays.stream(stash).forEach(val -> {
            if (map.containsKey(val)) {
                System.out.print(map.get(val));
            } else {
                System.out.print(val);
            }
        });
    }
}

