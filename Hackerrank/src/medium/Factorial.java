package medium;

import java.math.BigInteger;

public class Factorial {

    public static void main(String[] args){
        int n = 25;
        extraLongFactorials(n);

    }

    static void extraLongFactorials(int n) {
        BigInteger sum = BigInteger.valueOf(n);
        n--;
        while ( n > 0){
            BigInteger holder = BigInteger.valueOf(n);
            sum = sum.multiply(holder);
            n--;
        }
        System.out.print(sum);

    }
}
