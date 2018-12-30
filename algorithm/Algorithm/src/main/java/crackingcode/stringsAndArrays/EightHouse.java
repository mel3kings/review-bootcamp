package crackingcode.stringsandarrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EightHouse {

    private static final int ACTIVE = 1, INACTIVE = 0;
    private HashMap<Integer, Integer> map = new HashMap<>();

    //1,0,0,0,0,1,0,0
    //0,1,0,0,1,0,1,0
    public static void main(String[] args) {
        EightHouse d = new EightHouse();
        d.cellCompete2(new int[]{1, 0, 0, 0, 0, 1, 0, 0}, 1).forEach(System.out::println);
        d.cellCompete(new int[]{1, 0, 0, 0, 0, 1, 0, 0}, 1).forEach(System.out::println);
    }

    public List<Integer> cellCompete(int[] states, int days) {
        List<Integer> listOfStates = new ArrayList<Integer>();
        int left = 0;
        int right = 0;
        int[] copy = new int[states.length];
        for (int j = 0; j < states.length; j++) {
            copy[j] = states[j];
        }
        for (int d = 0; d < days; d++) {
            for (int i = 0; i < states.length; i++) {
                if (i == 0) {
                    left = INACTIVE;
                    right = states[i + 1];
                } else if (i == states.length - 1) {
                    right = INACTIVE;
                    left = states[i - 1];
                } else {
                    left = states[i - 1];
                    right = states[i + 1];
                }
                if (left == right) {
                    copy[i] = INACTIVE;
                } else {
                    copy[i] = ACTIVE;
                }
            }
            states = copy;
        }

        for (int j = 0; j < copy.length; j++) {
            listOfStates.add(copy[j]);
        }
        return listOfStates;
    }

    static List<Integer> cellCompete2(int[] states, int days) {
        int index, previousValue, nextValue;
        for (int i = 0; i < days; i++) {
            index = 0;
            previousValue = 0;
            nextValue = 0;
            while (index < states.length) {
                if (index < states.length - 1) {
                    nextValue = states[index + 1];
                }
                if (nextValue == previousValue) {
                    previousValue = states[index];
                    states[index] = 0;
                } else {
                    previousValue = states[index];
                    states[index] = 1;
                }
                index++;
            }
        }
        List<Integer> listOfStates = new ArrayList<Integer>();
        for (int j = 0; j < states.length; j++) {
            listOfStates.add(states[j]);
        }
        return listOfStates;
    }
}
