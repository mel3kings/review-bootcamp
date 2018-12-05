package algorithm.eulers;

public class Euler1 {
    public static void main(String[] args) {
        System.out.println(traditional(10));
        System.out.println(summation(10));
    }

    public static int traditional(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static int manuallyAdding(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
        }
        return sum;
    }

    public static long summation(int val) {
        int divisibleThree = 3, divisibleFive = 5, divisibleFifteen = 15;
        long iterationsThree = (val - 1) / divisibleThree;
        long iterationFive = (val - 1) / divisibleFive;
        long iterationFifteen = (val - 1) / divisibleFifteen;
        // at this point we are getting how many iterations of 3 is for this value
        // for example 15 has 5 iterations of 3 or (5 x 3)
        //Remember that the formula for summation is n * (n +1) / 2

        long totalSum = (3 * (iterationsThree * (iterationsThree + 1) / 2)) + (5 * (iterationFive * (iterationFive + 1) / 2));
        totalSum = totalSum - (15 * (iterationFifteen * (iterationFifteen + 1) / 2));
        return totalSum;
    }
}
