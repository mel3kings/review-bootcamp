package easy;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/sock-merchant/problem
 */
public class SockMerchant {

    public static void main(String[] args) {
        System.out.println(5 / 2);
        System.out.println(sockMerchant(10, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20}));
    }

    static int sockMerchant(int n, int[] ar) {
        Map<Integer, Long> map = Arrays.stream(ar).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int result = map.values().stream()
                .mapToInt(v -> v.intValue() / 2).boxed().reduce(0, Integer::sum);
        return result;
    }
}
