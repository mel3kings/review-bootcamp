package algorithm;

public class Prime {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.print("Is " + i + " prime?");
            System.out.println("" + isPrime(i));
        }
    }

    public static boolean isPrime(int num) {
        if (num > 2 && num % 2 == 0) {
            return false;
        }
        for (int i = 3; i < Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


}
