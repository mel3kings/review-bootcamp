package easy;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/bon-appetit/problem
 */
public class BonAppetit {

    public static void main(String[] args) {
        bonAppetit(Arrays.asList(1, 2, 3), 1, 12);
    }

    static void bonAppetit(List<Integer> bill, int k, int b) {
        int total = 0;
        for (int i = 0; i < bill.size(); i++) {
            if (i != k) {
                total += bill.get(i);
            }
        }
        total = total / 2;
        if (b == total) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(b - total);
        }
    }
}
