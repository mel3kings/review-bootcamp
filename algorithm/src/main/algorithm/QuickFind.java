package algorithm;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QuickFind {
    static int[] arr;

    private QuickFind(int size) {
        arr = new int[size];
        IntStream.range(0, size).forEach(value -> {
            arr[value] = value;
        });
    }

    private static void union(int a, int b) {
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

    private static boolean isConnected(int a, int b) {
        return arr[a] == arr[b];
    }

    public static void main(String[] args) {
        QuickFind qf = new QuickFind(10);
        union(4, 3);
        union(3, 8);
        union(6, 5);
        union(9, 4);
        union(2, 1);
        union(5, 0);
        union(7, 2);
        union(6, 1);
        print();
        System.out.println(isConnected(0, 7));
        System.out.println(isConnected(3, 9));
        System.out.println(isConnected(0, 9));
    }
}
