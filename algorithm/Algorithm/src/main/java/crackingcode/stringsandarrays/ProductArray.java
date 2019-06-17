package crackingcode.stringsandarrays;

import java.util.Arrays;

public class ProductArray {

    public static void main(String[] args) {
        ProductArray a = new ProductArray();
        int[] result = a.product(new int[]{1, 2, 3, 4, 5});
        Arrays.stream(result).forEach(System.out::println);
    }

    public int[] product(int[] n) {
        int[] prod = Arrays.stream(n).map(i -> i * i).toArray();
        return prod;
    }
}
