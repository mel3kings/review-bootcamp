package algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QuickFind {
    static int[] arr;

    public QuickFind() {
        arr = new int[10];
        IntStream.range(0, 10).forEach(value -> {
            arr[value] = value;
        });
    }

    public static void union(int a, int b) {
        int changeTo = arr[b];
        int compare = arr[a];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == compare) {
                arr[i] = changeTo;
            }
        }
    }

    private static void print() {
        System.out.println(Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(",")));
    }

    public static boolean isConnected(int a, int b) {
        return arr[a] == arr[b];
    }

    @Test
    public void TestMe() {
        QuickFind qf = new QuickFind();
        QuickFind.union(4, 3);
        QuickFind.union(3, 8);
        QuickFind.union(6, 5);
        QuickFind.union(9, 4);
        QuickFind.union(2, 1);
        QuickFind.union(5, 0);
        QuickFind.union(7, 2);
        QuickFind.union(6, 1);
        print();
        assert (QuickFind.isConnected(0, 7));
        assert (QuickFind.isConnected(3, 9));
        assert (!QuickFind.isConnected(0, 9));
    }
}
