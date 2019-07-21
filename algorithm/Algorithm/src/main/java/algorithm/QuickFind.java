package algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QuickFind implements QuickFindInterface{
    static int[] arr;

    public QuickFind() {
        arr = new int[10];
        IntStream.range(0, 10).forEach(value -> {
            arr[value] = value;
        });
    }

    public void Union(int a, int b) {
        int changeTo = arr[b];
        int compare = arr[a];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == compare) {
                arr[i] = changeTo;
            }
        }
        print();
    }

    private static void print() {
        System.out.println(Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(",")));
    }

    public boolean isConnected(int a, int b) {
        return arr[a] == arr[b];
    }

    @Test
    public void TestMe() {
        QuickFind qf = new QuickFind();
        qf.Union(4, 3);
        qf.Union(3, 8);
        qf.Union(6, 5);
        qf.Union(9, 4);
        qf.Union(2, 1);
        qf.Union(5, 0);
        qf.Union(7, 2);
        qf.Union(6, 1);
        assert (qf.isConnected(0, 7));
        assert (qf.isConnected(3, 9));
        assert (!qf.isConnected(0, 9));
    }
}
