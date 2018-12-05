package algorithm.eulers;

public class Euler2 {

    public static void main(String[] args){
       System.out.println(fibo(100));
    }


    public static long fibo(long max){
        long first =1, second =1, current =0;
       long total = 0;
        for(; first + second< max;){
            current  = first + second;
            first = second;
            second = current;
            if(current % 2 == 0){
                total += current;
            }
        }
        return total;
    }
}
