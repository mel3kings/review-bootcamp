package algorithm;

public class PrimeNumberSum {
    public static void main(String[] args) {
        int input = 989999;
        input = 13;
        System.out.println(input + " is a Prime? " + isPrime(input));
        System.out.println("Summation of values " + summationOfValues(input));
    }

    public static boolean isPrime(int n) {
        if ((n > 2 && n % 2 == 0) || n == 1) {
            return false;
        }
        for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int summationOfValues(int input) {
        int sum = 0;
        int copyInput = input;
        while (copyInput > 0) {
            sum = sum + copyInput % 10;
            copyInput = copyInput / 10;
        }
        return sum;
    }
}
