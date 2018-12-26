package crackingcode.brainteasers;

public class Factorial {

    public static void main(String[] args) {
        Factorial f = new Factorial();
        System.out.println(f.getFactorial(5));
    }

    private int getFactorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * getFactorial(n - 1);
    }
}
