package crackingcode.recursion;

import java.util.stream.Stream;

/**
 * Recursive + Iterative solution
 */
public class Fibonacci {


    public static void main(String[] args) {
        System.out.println(fibonacci(8));
        System.out.println(fiboIteration(8));
        fiboStream(20);
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    private static void fiboStream(int n) {
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(n).forEach(t -> System.out.print("(" + " " + t[0] + " ," + t[1] + ")"));
    }

    public static int fiboIteration(int n) {
        int fibo = 0, first = 0, second = 1;
        for (int i = 1; i < n; i++) {
            fibo = first + second;
            first = second;
            second = fibo;
        }
        return fibo;
    }

    private static long evenFiboHacker(long number) {
        long holder = 1, totalSum = 0, i = 1, result = 0;
        for (; i < number; holder = i, i = totalSum) {
            if (i + holder > number) {
                break;
            }
            totalSum = i + holder;
            if (totalSum % 2 == 0) {
                result += totalSum;
            }
        }
        return result;
    }
}
