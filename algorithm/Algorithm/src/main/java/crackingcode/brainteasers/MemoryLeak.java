package crackingcode.brainteasers;

import java.util.ArrayList;
import java.util.List;

public class MemoryLeak {


    public static List<Integer> leakingList = new ArrayList<>();

    public static void LeakSomeMemory() {
        // keep adding to the list,  but never clear it
        // the list will grow and grow and none of the objects
        // will be deallocated even though I don't need them
        // anymore
        leakingList.add(new Integer(0));
    }

    public static void main(String args[]) {
        while (true) {
            // this will eventually throw OutOfMemory exception
            LeakSomeMemory();
        }
    }

}
