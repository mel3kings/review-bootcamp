package crackingcode.recursion;

import java.util.HashMap;

public class FindGCD {

    public static void main(String[] args) {
        System.out.println(findGCD(new int[]{25, 100, 125}, 3));
        System.out.println(generalizedGCD(new int[]{25, 100, 125}, 3));
    }

    private static int longest = 0;
    private static HashMap<Integer, Boolean> map = new HashMap<>();

    public static int generalizedGCD(int[] arr, int num) {
        int largest = 1;
        for (int i = 0; i < num; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        map.put(1, true);
        for (int j = 0; j < arr.length; j++) {
            for (int holder = 2; holder < largest; holder++) {
                if (arr[j] > 0 && arr[j] % holder == 0 && !map.containsKey(holder)) {
                    map.put(holder, true);
                }

                if (arr[j] > 0 && arr[j] % holder != 0) {
                    map.put(holder, false);
                }
            }
        }
        longest = 0;
        for (Integer i : map.keySet()) {
            if (map.get(i).equals(true) && i > longest) {
                longest = i;
            }
        }
        return longest;
    }

    public static int findGCD(int arr[], int n) {
        int result = arr[0];
        for (int i = 1; i < n; i++)
            result = gcd(arr[i], result);

        return result;
    }

    /**
     * Euclidean Algorithm
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}
