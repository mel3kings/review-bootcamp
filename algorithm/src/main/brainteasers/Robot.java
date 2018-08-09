package brainteasers;

import java.util.Arrays;

public class Robot {
    private final static String PICKUP = "P", MOVE = "M", LOWER = "L";
    private static int[] stash = new int[10];

    public static void main(String[] args) {
        String command = "PMLPMMMLPMLPMML";
        executeCommand(command);
    }

    private static void executeCommand(String command) {
        int block = 0;
        int stashLocation = 0;
        for (Character c : command.toCharArray()) {
            if (String.valueOf(c).equals(PICKUP)) {
                block = 1;
            } else if (String.valueOf(c).equals(MOVE)) {
                if (stashLocation < 10) {
                    stashLocation++;
                }
            } else if (String.valueOf(c).equals(LOWER)) {
                if (block != 0) {
                    stash[stashLocation] = stash[stashLocation] + 1;
                    block = 0;
                    stashLocation = 0;
                }
            }
        }
        Arrays.stream(stash).forEach(System.out::print);
    }
}

