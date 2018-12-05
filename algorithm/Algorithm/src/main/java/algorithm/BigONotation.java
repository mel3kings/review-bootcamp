package algorithm;


import java.util.List;

public class BigONotation {

    public static void main(String[] args) throws Exception {
        System.out.println("FINAL ANSWER : "  + evenFibo(100));

    }

    private static boolean isNull(String empty) {
        return empty == null;
    }

    private static void isNull(List<String> empty) {
        for (String data : empty) {
            System.out.println("processing " + data);
            for (String nested : empty) {
                System.out.println("processing again " + nested);
            }
        }
    }

    private static int Fibonacci(int number) {
        System.out.print(number + " ");
        if(number % 2 ==0){
            System.out.println("EVEN " + number);
        }
        if (number <= 1){
            System.out.println("(" + number + ")");
            return number;
        }
        return Fibonacci(number - 1) + Fibonacci(number - 2);
    }

    private static int evenFibo(int number){
        int holder = 1;
        int totalSum = 0;
        int i =1;
        for(; i<number;  holder = i, i = totalSum ){
            System.out.println(" i " + i + " holder " + holder);
            if(i+holder > number){
                break;
            }
            totalSum = i + holder;
            System.out.println(" sum " + totalSum);
        }
        return totalSum;
    }

    private static long evenFiboHacker(long number){
        long holder = 1,totalSum = 0, i =1, result = 0;
        for(; i<number;  holder = i, i = totalSum ){
            if(i+holder > number){
                break;
            }
            totalSum = i + holder;
            if(totalSum% 2 ==0){
                result += totalSum;
            }
        }
        return result;
    }
}
