package algorithm.eulers;

public class Euler3 {

    public static void main(String[] args) {
        int check = 1000000000;
        System.out.println(prime(check));
        System.out.println(prime2(check));
    }

    //this is the long way, this works but takes too long.
    public static long prime(long value) {
        for (int divisor = 2; divisor < value; divisor++) {
            if (value % divisor == 0) {
                value = value / divisor;
            }
            System.out.println("VALUE:" + value + " DIVISOR: " + divisor);
        }
        return value;
    }

    //this is the correct way
    public static long prime2(long value) {
        while (value % 2 == 0) {    //check first if it is divisible by two just like how you would do in paper
            value = value / 2;
            if (value == 1) {   // this is for numbers like 16 that will be : 8,4,2,1 = meaning 2 is the largest
                return 2;
            }
        }
        // we do not need to check up to the maximum value, we can but it will be slow,
        //hence the square root
        // we have already checked the 2s hence we are checking the 3s incrementing by 2 (3 5 7 9 11)
        for (int i = 3; i <= Math.sqrt(value); i = i + 2) {
            if (value % i == 0) {
                value = value / i;
                i =1;   // we are reverting back to 1 so it can be incremented to 3 again,
//                for example:
//                VALUE:625 DIVISOR: 3
//                VALUE:625 DIVISOR: 5
//                VALUE:125 DIVISOR: 3
//                VALUE:125 DIVISOR: 5 -- notice here that the divisor is at 5
//                VALUE:25 DIVISOR: 3   -- just like you would do on paper, if you reach 25, if you did not revert it back to 3 again
//                VALUE:25 DIVISOR: 5 -- it would try to divide by 7 and it would return 25 as the largest prime factor
            }
        }
        return value;
    }


}
