package crackingcode.stack;

public class TripleManualStack {
    private static int SIZE = 30;
    private static int[] pointers = {0, 0, 0};
    private String[] contents = new String[SIZE];

    /**
     * USING one array create stack implementation
     * limitation is that it does not resize.
     * @param args
     */
    public static void main(String[] args) {
        int step = SIZE / 3;
        for (int divider = 0, i = 0; divider < SIZE; divider += step, i++) {
            System.out.println(divider);
            pointers[i] = divider;
        }

        TripleManualStack stk = new TripleManualStack();
        stk.push(0, "first");
        stk.push(0, "first2");
        stk.push(1, "SECOND");
        stk.push(1, "SECOND");

        stk.push(1, "SEC");
        stk.push(2, "THIRD");
        stk.push(2, "THIRD2");
        stk.push(2, "THIRD34");

        System.out.println(stk);
    }

    public void push(int stackNum, String value) {
        int index = pointers[stackNum];
        pointers[stackNum]++;
        contents[index] = value;
        System.out.println(index);
    }

    public String pop(int stacknNum) {
        int pointer = pointers[stacknNum];
        pointer--;
        pointers[stacknNum] = pointer;
        return contents[pointer];
    }

    public String peek(int stackNum) {
        int pointer = pointers[stackNum];
        return contents[pointer - 1];
    }
}
