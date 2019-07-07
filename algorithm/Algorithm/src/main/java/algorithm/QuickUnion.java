package algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QuickUnion implements QuickFindInterface {

    private static int[] arr = new int[10];

    public QuickUnion() {
        IntStream.range(0, 10).forEach(i -> arr[i] = i);
    }


    public int getRoot(int a) {
        if (arr[a] == a) {
            return arr[a];
        } else {
            return getRoot(arr[a]);
        }
    }

    public void Union(int a, int b) {
        int i = getRoot(a);
        int j = getRoot(b);
        arr[i] = j;
    }

    public boolean isConnected(int a, int b) {
        return getRoot(a) == getRoot(b);
    }

    private static void print() {
        System.out.println(Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(",")));
    }

    @Test
    public void TestQuickUnion() {
        QuickUnion qf = new QuickUnion();
        print();
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
