package algorithm;

import java.util.ArrayList;

public class PrimeNumber {

    public static void main(String[] args){
        System.out.println(prime(13195));
    }

    public static long prime(long n){
        ArrayList<Long> al = new ArrayList<Long>();
        for(long i =0; i <= n; i++){
            System.out.println("Current number " + i);
            System.out.println(i % 2 );
            System.out.println(i % 3 );

            if(i % 2 == 1 && i % 3 ==1){
                System.out.println("this is a prime : " + i);
                al.add(i);
            }

        }

        return al.get(al.size() -1);
    }
}
