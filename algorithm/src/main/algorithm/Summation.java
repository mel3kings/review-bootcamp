package algorithm;

public class Summation {
    public static void main(String[] args) {
        int input = 13;
        System.out.println("Summation of values " + summationOfValues(input));
    }


    public static int summationOfValues(int input) {
        int sum = 0;
        while (input > 0) {
            sum += input % 10;
            input = input / 10;
        }
        return sum;
    }
}
