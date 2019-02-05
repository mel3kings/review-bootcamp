package hackerrank;

public class GetConsecutive {

    public static long getConsecutive(long num) {
        long counter = 0;
        long mid = (num / 2) + 1;
        long start = 0;
        long sum = 0;
        long tail = 0;
        while (start <= mid) {
            sum += start;
            while (sum >= num && tail != start) {
                if (sum == num) {
                    counter++;
                }
                tail++;
                sum -= tail;
            }
            start++;
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(getConsecutive(15));
    }
}
