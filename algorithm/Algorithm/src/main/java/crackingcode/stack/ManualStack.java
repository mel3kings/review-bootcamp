package crackingcode.stack;

public class ManualStack {
    int pointer = 0;
    private static int STACK_SIZE = 2;
    private String[] contents = new String[STACK_SIZE];

    public static void main(String[] args) {
        ManualStack stk = new ManualStack();
        stk.push("hello");
        stk.push("bye");
        stk.push("exceed");
        stk.push("really exceed");
        System.out.println(stk.peek());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
    }


    public String pop() {
        if (pointer == 0) {
            throw new IllegalArgumentException("Empty stack");
        }
        pointer--;
        return contents[pointer];
    }

    public String peek() {
        if (pointer == 0) {
            throw new IllegalArgumentException("Empty stack");
        }
        return contents[pointer - 1];
    }

    public void push(String value) {
        if (pointer == STACK_SIZE) {
            STACK_SIZE = STACK_SIZE * STACK_SIZE;
            String[] newContents = new String[STACK_SIZE];
            for (int i = 0; i < contents.length; i++) {
                newContents[i] = contents[i];
            }
            contents = newContents;
        }
        contents[pointer] = value;
        pointer++;
    }

}
