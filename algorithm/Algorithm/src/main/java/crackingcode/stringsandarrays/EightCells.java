package crackingcode.stringsandarrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EightCells {


    /**
     * FIRST EXAMPLE
     * 1,0,0,0,0,1,0,0
     * 0,1,0,0,1,0,1,0
     * <p>
     * SECOND example
     * 11101111
     * 10101001
     * 00000110
     *
     * @param args
     */
    public static void main(String[] args) {
        EightCells d = new EightCells();
        d.completeCell(new int[]{1, 0, 0, 0, 0, 1, 0, 0}, 1).forEach(System.out::print);
        System.out.println("");
        d.completeCell(new int[]{1, 1, 1, 0, 1, 1, 1, 1}, 2).forEach(System.out::print);
    }

    public List<Integer> completeCell(int[] states, int days) {
        int[] temp = new int[states.length];
        for (int i = 0; i < days; i++) {
            int previous = 0;
            int current;
            int next;
            for (int j = 0; j < states.length; j++) {
                if (j < states.length - 1) {
                    next = states[j + 1];
                } else {
                    next = 0;
                }

                if (previous == next) {
                    current = 0;
                } else {
                    current = 1;
                }
                previous = states[j];
                temp[j] = current;
            }
            states = temp;
        }
        return Arrays.stream(temp).boxed().collect(Collectors.toList());
    }
}
