package algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WeightedQuickUnion implements QuickFindInterface{

    private static int[] arr = new int[10];
    private static int[] arrWeight = new int[10];

    public WeightedQuickUnion() {
        IntStream.range(0, 10).forEach(i -> arr[i] = i);
        IntStream.range(0, 10).forEach(i -> arrWeight[i] = 1);

    }

    public static void main(String[] args) {
        System.out.println("Test");
    }

    public void Union(int p, int q) {
        int pRoot = getRoot(p);
        int qRoot = getRoot(q);
        if (arrWeight[p] > arrWeight[q]) {
            arr[pRoot] = qRoot;
            arrWeight[p] = arrWeight[p] + 1;
        } else {
            arr[qRoot] = pRoot;
            arrWeight[q] = arrWeight[q] + 1;
        }
        print();
    }

    public boolean isConnected(int a, int b) {
        if (getRoot(a) == getRoot(b)) {
            return true;
        }
        return false;
    }

    public int getRoot(int a) {
        int getValue = a;
        while (arr[getValue] != getValue) {
            getValue = arr[getValue];
        }
        return getValue;
    }

    public void print() {
        System.out.println(Arrays.stream(arr).
                mapToObj(String::valueOf).
                collect(Collectors.joining(",")));

    }

    public void printWeight() {
        System.out.println(Arrays.stream(arrWeight).
                mapToObj(String::valueOf).
                collect(Collectors.joining(",")));

    }

    @Test
    public void TestQuickUnion() {
        WeightedQuickUnion qf = new WeightedQuickUnion();
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
        printWeight();
    }
}
